package com.mbetter.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mbetter.domain.MenuMaster;
import com.mbetter.domain.RoleMaster;
import com.mbetter.domain.SubMenuMaster;

public interface RoleRepository extends JpaRepository<RoleMaster, Serializable> {
	List<RoleMaster> getAllRolesByDepartment(
			@Param("department") String department);

	RoleMaster getRoleMasterForMenuAndSubMenu(@Param("menu") MenuMaster menu,
			@Param("submenu") SubMenuMaster subMenu,
			@Param("department") String department);

	RoleMaster getRoleMasterForMenuAndNoSubMenu(@Param("menu") MenuMaster menu,
			@Param("department") String department);

	List<String> getDistinctRoles();
}
