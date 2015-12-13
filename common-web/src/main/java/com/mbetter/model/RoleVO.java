package com.mbetter.model;

import java.util.ArrayList;
import java.util.List;

public class RoleVO {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String userRole;
	private List<MenuVO> menus = new ArrayList<MenuVO>();

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

}
