package com.mbetter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbetter.domain.UserData;
import com.mbetter.model.RoleVO;
import com.mbetter.service.MenuService;
import com.mbetter.service.UserContext;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Autowired
	private UserContext userContext;

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	@ModelAttribute("department")
	public String department() {
		return getUserDepartmentInContext();
	}

	@ModelAttribute("rolemenus")
	public RoleVO prepareRoles() {
		String department = getUserDepartmentInContext();
		if ("".equalsIgnoreCase(department)) {
			return null;
		} else
			return menuService.getRoleMenuesForDepartment(department);
	}

	private String getUserDepartmentInContext() {
		UserData user = userContext.getCurrentUser();
		String department = "";
		if (user != null) {
			String email = user.getEmail();
			if (email.contains("admin")) {
				department = "admin";
			} else if (email.contains("doctor")) {
				department = "doctor";
			} else if (email.contains("reception")) {
				department = "reception";
			} else if (email.contains("lab")) {
				department = "lab";
			} else if (email.contains("pharmacy")) {
				department = "pharmacy";
			}
		}
		return department;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String homePage(HttpServletRequest request, ModelMap model) {
		return "index";
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "manageRoles")
	public String createRole(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "menu") long menu,
			@RequestParam(value = "submenu") long submenu) {
		String options = menuService.getOptionsForMenuAndSubMenu(menu, submenu,
				getUserDepartmentInContext());
		if (options != null) {
			for (String option : options.split(",")) {
				if ("add".equalsIgnoreCase(option)) {
					model.addAttribute("add", true);
				} else if ("delete".equalsIgnoreCase(option)) {
					model.addAttribute("delete", true);
				} else if ("view".equalsIgnoreCase(option)) {
					model.addAttribute("view", true);
				}
			}
		}
		model.addAttribute("role", createRole());
		return "home";
	}

	@RequestMapping("default")
	public String defaultAfterLogin(HttpServletRequest request) {
		return "redirect:/";
	}

	@RequestMapping("login/form")
	public String login() {
		return "login";
	}

	@RequestMapping("/errors/403")
	public String error403() {
		return "/errors/403";
	}

	private RoleVO createRole() {
		RoleVO roleVO = new RoleVO();
		roleVO.setMenus(menuService.getAllMenus());
		return roleVO;
	}

	@RequestMapping("mockRoleCreate")
	public String mockRoleCreate(@ModelAttribute RoleVO roleVO) {
		menuService.saveRoleData(roleVO);
		return "redirect:/";
	}
}
