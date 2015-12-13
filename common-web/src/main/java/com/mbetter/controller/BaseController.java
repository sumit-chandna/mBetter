package com.mbetter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mbetter.model.RoleVO;
import com.mbetter.service.MenuService;
import com.mbetter.service.RoleService;
import com.mbetter.service.UserContext;

@Controller
public abstract class BaseController {
	@Autowired
	private UserContext userContext;

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	@Autowired
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Autowired
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@ModelAttribute("department")
	public String department() {
		return userContext.getUserDepartmentInContext();
	}

	@ModelAttribute("rolemenus")
	public RoleVO prepareRoles() {
		String department = userContext.getUserDepartmentInContext();
		if ("".equalsIgnoreCase(department)) {
			return null;
		} else
			return getRoleService().getRoleMenuesForDepartment(department);
	}
}
