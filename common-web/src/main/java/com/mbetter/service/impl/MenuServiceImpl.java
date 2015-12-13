package com.mbetter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbetter.domain.MenuMaster;
import com.mbetter.domain.RoleMaster;
import com.mbetter.domain.SubMenuMaster;
import com.mbetter.model.MenuVO;
import com.mbetter.model.SubMenuVO;
import com.mbetter.repositories.MenuRepository;
import com.mbetter.repositories.RoleRepository;
import com.mbetter.repositories.SubMenuRepository;
import com.mbetter.service.MenuService;
import com.mbetter.util.RoleUtil;

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
		return populateMenus(menuRepository.getAllActiveMenu());
	}

	private List<MenuVO> populateMenus(List<MenuMaster> menus) {
		List<MenuVO> menuVoList = new ArrayList<MenuVO>();
		for (MenuMaster master : menus) {
			MenuVO menuVO = new MenuVO();
			RoleUtil.populateMenuVO(menuVO, master);
			List<SubMenuVO> subMenuVOs = new ArrayList<SubMenuVO>();
			for (SubMenuMaster subMenuMaster : master.getSubMenus()) {
				SubMenuVO subMenuVO = new SubMenuVO();
				RoleUtil.populateSubMenuVO(subMenuVO, subMenuMaster);
				subMenuVOs.add(subMenuVO);
			}
			menuVO.setSubMenus(subMenuVOs);
			menuVoList.add(menuVO);
		}
		return menuVoList;
	}

	@Override
	public String getOptionsForMenuAndSubMenu(long menu, long submenu,
			String department) {
		RoleMaster roleMaster = roleRepository.getRoleMasterForMenuAndSubMenu(
				menuRepository.findOne(menu),
				subMenuRepository.findOne(submenu), department);
		return roleMaster.getOptions();
	}
}
