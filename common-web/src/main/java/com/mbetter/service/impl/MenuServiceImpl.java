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

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private SubMenuRepository subMenuRepository;

	public SubMenuRepository getSubMenuRepository() {
		return subMenuRepository;
	}

	public void setSubMenuRepository(SubMenuRepository subMenuRepository) {
		this.subMenuRepository = subMenuRepository;
	}

	@Autowired
	private RoleRepository roleRepository;

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public List<MenuVO> getAllMenus() {
		return populateMenus(menuRepository.findAll());
	}

	private List<MenuVO> populateMenus(List<MenuMaster> menus) {
		List<MenuVO> menuVoList = new ArrayList<MenuVO>();
		for (MenuMaster master : menus) {
			MenuVO menuVO = new MenuVO();
			menuVO.setMenuName(master.getMenuName());
			menuVO.setId(master.getMenuId());
			List<SubMenuVO> subMenuVOs = new ArrayList<SubMenuVO>();
			for (SubMenuMaster subMenuMaster : master.getSubMenus()) {
				SubMenuVO subMenuVO = new SubMenuVO();
				subMenuVO.setMenuName(subMenuMaster.getMenuName());
				subMenuVO.setId(subMenuMaster.getMenuId());
				subMenuVOs.add(subMenuVO);
			}
			menuVO.setSubMenus(subMenuVOs);
			menuVoList.add(menuVO);
		}
		return menuVoList;
	}

	@Override
	@Transactional
	public void saveRoleData(RoleVO roleVO) {
		List<RoleMaster> roleMasters = new ArrayList<RoleMaster>();
		for (MenuVO menuVO : roleVO.getMenus()) {
			if (null == menuVO.getSubMenus()
					|| menuVO.getSubMenus().size() == 0) {
				if (menuVO.getAdd() || menuVO.getDelete() || menuVO.getView()) {
					RoleMaster roleMaster = new RoleMaster();
					roleMaster.setUserRole(roleVO.getUserRole());
					roleMaster.setMenu(menuRepository.findOne(menuVO.getId()));
					StringBuilder options = new StringBuilder();
					if (menuVO.getAdd()) {
						options.append("add");
					}
					if (menuVO.getDelete()) {
						String delete = options.length() == 0 ? "delete"
								: ",delete";
						options.append(delete);
					}
					if (menuVO.getView()) {
						String view = options.length() == 0 ? "view" : ",view";
						options.append(view);
					}
					roleMaster.setOptions(options.toString());
					roleMasters.add(roleMaster);
				}
			} else {
				for (SubMenuVO subMenuVO : menuVO.getSubMenus()) {
					if (subMenuVO.getAdd() || subMenuVO.getDelete()
							|| subMenuVO.getView()) {
						RoleMaster roleMaster = new RoleMaster();
						roleMaster.setUserRole(roleVO.getUserRole());
						roleMaster.setMenu(menuRepository.findOne(menuVO
								.getId()));
						roleMaster.setSubMenu(subMenuRepository
								.findOne(subMenuVO.getId()));
						StringBuilder options = new StringBuilder();
						if (subMenuVO.getAdd()) {
							options.append("add");
						}
						if (subMenuVO.getDelete()) {
							String delete = options.length() == 0 ? "delete"
									: ",delete";
							options.append(delete);
						}
						if (subMenuVO.getView()) {
							String view = options.length() == 0 ? "view"
									: ",view";
							options.append(view);
						}
						roleMaster.setOptions(options.toString());
						roleMasters.add(roleMaster);
					}
				}
			}
		}
		if (roleMasters.size() > 0) {
			for (RoleMaster roleMaster : roleMasters) {
				roleRepository.save(roleMaster);
			}
		}
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
				menuVO.setId(menuMaster.getMenuId());
				List<SubMenuVO> subMenuVOs = menuVO.getSubMenus() == null ? new ArrayList<SubMenuVO>()
						: menuVO.getSubMenus();
				if (roleMaster.getSubMenu() != null) {
					SubMenuMaster subMenuMaster = roleMaster.getSubMenu();
					SubMenuVO subMenuVO = new SubMenuVO();
					subMenuVO.setMenuName(subMenuMaster.getMenuName());
					subMenuVO.setId(subMenuMaster.getMenuId());
					String options = roleMaster.getOptions();
					if (options != null) {
						for (String option : options.split(",")) {
							if ("add".equalsIgnoreCase(option)) {
								subMenuVO.setAdd(true);
							} else if ("delete".equalsIgnoreCase(option)) {
								subMenuVO.setDelete(true);
							} else if ("view".equalsIgnoreCase(option)) {
								subMenuVO.setView(true);
							}
						}
					}
					subMenuVOs.add(subMenuVO);
				} else {
					String options = roleMaster.getOptions();
					if (options != null) {
						for (String option : options.split(",")) {
							if ("add".equalsIgnoreCase(option)) {
								menuVO.setAdd(true);
							} else if ("delete".equalsIgnoreCase(option)) {
								menuVO.setDelete(true);
							} else if ("view".equalsIgnoreCase(option)) {
								menuVO.setView(true);
							}
						}
					}
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

	private MenuVO getOrCreateMenu(String menuName, Map<String, MenuVO> menuMap) {
		MenuVO menuVO = menuMap.get(menuName) == null ? new MenuVO(menuName)
				: menuMap.get(menuName);
		menuMap.put(menuName, menuVO);
		return menuVO;
	}
}
