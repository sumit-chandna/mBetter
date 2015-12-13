package com.mbetter.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbetter.domain.MenuMaster;
import com.mbetter.domain.RoleMaster;
import com.mbetter.domain.SubMenuMaster;
import com.mbetter.model.MenuVO;
import com.mbetter.model.RoleVO;
import com.mbetter.model.SubMenuVO;
import com.mbetter.repositories.MenuRepository;
import com.mbetter.repositories.RoleRepository;
import com.mbetter.repositories.SubMenuRepository;
import com.mbetter.service.MenuService;
import com.mbetter.service.RoleService;
import com.mbetter.util.RoleUtil;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private SubMenuRepository subMenuRepository;
	@Autowired
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public SubMenuRepository getSubMenuRepository() {
		return subMenuRepository;
	}

	public void setSubMenuRepository(SubMenuRepository subMenuRepository) {
		this.subMenuRepository = subMenuRepository;
	}

	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<String> getDistinctRoles() {
		return roleRepository.getDistinctRoles();
	}

	@Override
	@Transactional
	public void saveRoleData(RoleVO roleVO) {
		List<RoleMaster> roleMasters = convertRoleVoTORoleMaster(roleVO);
		if (roleMasters.size() > 0) {
			for (RoleMaster roleMaster : roleMasters) {
				roleRepository.save(roleMaster);
			}
		}
	}

	private List<RoleMaster> convertRoleVoTORoleMaster(RoleVO roleVO) {
		List<RoleMaster> roleMasters = new ArrayList<RoleMaster>();
		for (MenuVO menuVO : roleVO.getMenus()) {
			MenuMaster menuMaster = menuRepository.findOne(menuVO.getId());
			if (null == menuVO.getSubMenus()
					|| menuVO.getSubMenus().size() == 0) {
				RoleMaster roleMaster = createOrGetRoleMaster(menuMaster, null,
						roleVO.getUserRole());
				if (anyMenuOptionSelected(menuVO)) {
					roleMaster.setUserRole(roleVO.getUserRole());
					roleMaster.setMenu(menuMaster);
					StringBuilder options = createOptionsFromMenuVO(menuVO);
					roleMaster.setOptions(options.toString());
					roleMaster.setIsActive(true);
					roleMasters.add(roleMaster);
				} else {
					roleMaster.setIsActive(false);
					if (roleMaster.getRoleId() != null) {
						roleMasters.add(roleMaster);
					}
				}
			} else {
				for (SubMenuVO subMenuVO : menuVO.getSubMenus()) {
					SubMenuMaster subMenuMaster = subMenuRepository
							.findOne(subMenuVO.getId());
					RoleMaster roleMaster = createOrGetRoleMaster(menuMaster,
							subMenuMaster, roleVO.getUserRole());
					if (anySubMenuOptionSelected(subMenuVO)) {
						roleMaster.setUserRole(roleVO.getUserRole());
						roleMaster.setMenu(menuMaster);
						roleMaster.setSubMenu(subMenuMaster);
						StringBuilder options = createOptionsFromSubMenuVO(subMenuVO);
						roleMaster.setOptions(options.toString());
						roleMaster.setIsActive(true);
						roleMasters.add(roleMaster);
					} else {
						roleMaster.setIsActive(false);
						if (roleMaster.getRoleId() != null) {
							roleMasters.add(roleMaster);
						}
					}
				}
			}
		}
		return roleMasters;
	}

	private RoleMaster createOrGetRoleMaster(MenuMaster menuMaster,
			SubMenuMaster subMenuMaster, String department) {
		RoleMaster roleMaster;
		if (subMenuMaster != null) {
			roleMaster = roleRepository.getRoleMasterForMenuAndSubMenu(
					menuMaster, subMenuMaster, department);
		} else {
			roleMaster = roleRepository.getRoleMasterForMenuAndNoSubMenu(
					menuMaster, department);
		}
		if (roleMaster == null) {
			roleMaster = new RoleMaster();
		}
		return roleMaster;
	}

	private boolean anySubMenuOptionSelected(SubMenuVO subMenuVO) {
		return subMenuVO.getAdd() || subMenuVO.getUpdate()
				|| subMenuVO.getView();
	}

	private boolean anyMenuOptionSelected(MenuVO menuVO) {
		return menuVO.getAdd() || menuVO.getUpdate() || menuVO.getView();
	}

	@Override
	public RoleVO getRoleMenuesForDepartment(String department) {
		List<RoleMaster> roleMasters = roleRepository
				.getAllRolesByDepartment(department);
		RoleVO roleVO = new RoleVO();
		List<MenuVO> menuVOs = new ArrayList<MenuVO>();
		roleVO.setUserRole(department);
		Map<String, MenuVO> menuMap = new HashMap<String, MenuVO>();
		for (RoleMaster roleMaster : roleMasters) {
			if (roleMaster.getMenu() != null) {
				MenuMaster menuMaster = roleMaster.getMenu();
				MenuVO menuVO = getOrCreateMenu(menuMaster.getMenuName(),
						menuMap);
				RoleUtil.populateMenuVO(menuVO, menuMaster);
				List<SubMenuVO> subMenuVOs = menuVO.getSubMenus() == null ? new ArrayList<SubMenuVO>()
						: menuVO.getSubMenus();
				if (roleMaster.getSubMenu() != null) {
					SubMenuMaster subMenuMaster = roleMaster.getSubMenu();
					SubMenuVO subMenuVO = new SubMenuVO();
					RoleUtil.populateSubMenuVO(subMenuVO, subMenuMaster);
					populateOptions(roleMaster, subMenuVO);
					subMenuVOs.add(subMenuVO);
				} else {
					populateOptions(roleMaster, menuVO);
				}
				menuVO.setSubMenus(subMenuVOs);
				if (!menuVOs.contains(menuVO)) {
					menuVOs.add(menuVO);
				}
			}
		}
		roleVO.setMenus(menuVOs);
		return roleVO;
	}

	private void populateOptions(RoleMaster roleMaster, Object object) {
		String options = roleMaster.getOptions();
		boolean isMenuVO = false;
		SubMenuVO subMenuVO = null;
		MenuVO menuVO = null;
		if (object instanceof SubMenuVO) {
			isMenuVO = false;
			subMenuVO = (SubMenuVO) object;
		} else if (object instanceof MenuVO) {
			isMenuVO = true;
			menuVO = (MenuVO) object;
		} else {
			return;
		}
		if (options != null) {
			for (String option : options.split(",")) {
				if ("add".equalsIgnoreCase(option)) {
					if (isMenuVO)
						menuVO.setAdd(true);
					else
						subMenuVO.setAdd(true);
				} else if ("update".equalsIgnoreCase(option)) {
					if (isMenuVO)
						menuVO.setUpdate(true);
					else
						subMenuVO.setUpdate(true);
				} else if ("view".equalsIgnoreCase(option)) {
					if (isMenuVO)
						menuVO.setView(true);
					else
						subMenuVO.setView(true);
				}
			}
		}
	}

	private MenuVO getOrCreateMenu(String menuName, Map<String, MenuVO> menuMap) {
		MenuVO menuVO = menuMap.get(menuName) == null ? new MenuVO(menuName)
				: menuMap.get(menuName);
		menuMap.put(menuName, menuVO);
		return menuVO;
	}

	@Override
	@Transactional
	public void updateRoleData(RoleVO roleVO) {
		List<RoleMaster> roleMasters = convertRoleVoTORoleMaster(roleVO);
		roleRepository.save(roleMasters);
	}

	private StringBuilder createOptionsFromMenuVO(MenuVO menuVO) {
		StringBuilder options = new StringBuilder();
		if (menuVO.getAdd()) {
			options.append("add");
		}
		if (menuVO.getUpdate()) {
			String update = options.length() == 0 ? "update" : ",update";
			options.append(update);
		}
		if (menuVO.getView()) {
			String view = options.length() == 0 ? "view" : ",view";
			options.append(view);
		}
		return options;
	}

	private StringBuilder createOptionsFromSubMenuVO(SubMenuVO subMenuVO) {
		StringBuilder options = new StringBuilder();
		if (subMenuVO.getAdd()) {
			options.append("add");
		}
		if (subMenuVO.getUpdate()) {
			String update = options.length() == 0 ? "update" : ",update";
			options.append(update);
		}
		if (subMenuVO.getView()) {
			String view = options.length() == 0 ? "view" : ",view";
			options.append(view);
		}
		return options;
	}

	private MenuVO getMenuVoForMenuId(List<MenuVO> menuVOs, Long id) {
		for (MenuVO menuVO : menuVOs) {
			if (menuVO.getId() == id) {
				return menuVO;
			}
		}
		return null;
	}

	private SubMenuVO getSubMenuVoForSubMenuId(List<SubMenuVO> subMenuVOs,
			Long id) {
		for (SubMenuVO subMenuVO : subMenuVOs) {
			if (subMenuVO.getId() == id) {
				return subMenuVO;
			}
		}
		return null;
	}

	@Override
	public RoleVO getRoleMenuesForUpdateByDepartment(String department) {
		RoleVO roleVO = getRoleMenuesForDepartment(department);
		List<MenuVO> menuVOs = menuService.getAllMenus();
		List<MenuVO> finalList = new ArrayList<MenuVO>();
		for (MenuVO menuVO : menuVOs) {
			MenuVO dbMenuVO = getMenuVoForMenuId(roleVO.getMenus(),
					menuVO.getId());
			if (dbMenuVO != null) {
				if (dbMenuVO.getSubMenus().size() != menuVO.getSubMenus()
						.size()) {
					List<SubMenuVO> finalSubMenuVOs = new ArrayList<SubMenuVO>();
					for (SubMenuVO subMenuVO : menuVO.getSubMenus()) {
						SubMenuVO dbSubMenuVO = getSubMenuVoForSubMenuId(
								dbMenuVO.getSubMenus(), subMenuVO.getId());
						if (dbSubMenuVO != null) {
							finalSubMenuVOs.add(dbSubMenuVO);
						} else {
							finalSubMenuVOs.add(subMenuVO);
						}

					}
					dbMenuVO.setSubMenus(finalSubMenuVOs);
					finalList.add(dbMenuVO);
				} else {
					finalList.add(dbMenuVO);
				}
			} else {
				finalList.add(menuVO);
			}
		}
		roleVO.setMenus(finalList);
		return roleVO;
	}
}
