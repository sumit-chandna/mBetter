package com.mbetter.service;

import java.util.List;

import com.mbetter.model.MenuVO;
import com.mbetter.model.RoleVO;

public interface MenuService {
	List<MenuVO> getAllMenus();

	void saveRoleData(RoleVO roleVO);

	RoleVO getRoleMenuesForDepartment(String department);
}
