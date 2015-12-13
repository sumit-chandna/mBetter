package com.mbetter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbetter.model.RoleVO;
import com.mbetter.util.RoleUtil;

@Controller
@RequestMapping("/manageRoles")
public class ManageRoleController extends BaseController {

	@RequestMapping(method = { RequestMethod.GET })
	public String createRole(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "menu") long menu,
			@RequestParam(value = "submenu") long submenu,
			@RequestParam(value = "option") String option) {
		String viewJsp = "";
		if ("add".equalsIgnoreCase(option)) {
			model.addAttribute("availableRoles", getAddRoles());
			model.addAttribute("role", createRole());
			viewJsp = "manageroles/addRole";
		} else if ("view".equalsIgnoreCase(option)) {
			model.addAttribute("allRoles", getViewRoles());
			viewJsp = "manageroles/viewRole";
		} else if ("update".equalsIgnoreCase(option)) {
			model.addAttribute("availableRoles", getRoleService()
					.getDistinctRoles());
			viewJsp = "manageroles/updateRole";
		}
		return viewJsp;
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/getRoleDetails")
	public String getRoleDetails(HttpServletRequest request,
			@RequestParam("userRole") String userRole, ModelMap model) {
		model.addAttribute("availableRoles", getRoleService()
				.getDistinctRoles());
		model.addAttribute("selectedRole", userRole);
		model.addAttribute("role", getRoleService()
				.getRoleMenuesForUpdateByDepartment(userRole));
		return "manageroles/updateRole";
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/updateRole")
	public String updateRole(HttpServletRequest request, RoleVO roleVO) {
		getRoleService().updateRoleData(roleVO);
		return "redirect:/";
	}

	@RequestMapping("mockRoleCreate")
	public String roleCreate(@ModelAttribute RoleVO roleVO) {
		getRoleService().saveRoleData(roleVO);
		return "redirect:/";
	}

	private RoleVO createRole() {
		RoleVO roleVO = new RoleVO();
		roleVO.setMenus(getMenuService().getAllMenus());
		return roleVO;
	}

	private List<String> getAddRoles() {
		List<String> allRoles = RoleUtil.getRoles();
		List<String> rolesIndb = getRoleService().getDistinctRoles();
		for (String role : rolesIndb) {
			if (allRoles.contains(role)) {
				allRoles.remove(role);
			}
		}
		return allRoles;
	}

	private List<RoleVO> getViewRoles() {
		List<String> rolesIndb = getRoleService().getDistinctRoles();
		List<RoleVO> allRoles = new ArrayList<RoleVO>();
		for (String role : rolesIndb) {
			allRoles.add(getRoleService().getRoleMenuesForDepartment(role));
		}
		return allRoles;
	}
}
