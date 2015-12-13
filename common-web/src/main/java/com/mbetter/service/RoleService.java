package com.mbetter.service;

import java.util.List;

import com.mbetter.model.RoleVO;

public interface RoleService {

	List<String> getDistinctRoles();

	void saveRoleData(RoleVO roleVO);

	void updateRoleData(RoleVO roleVO);

	RoleVO getRoleMenuesForDepartment(String department);

	RoleVO getRoleMenuesForUpdateByDepartment(String department);

}
