package com.mbetter.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mbetter.domain.RoleMaster;

public interface RoleRepository extends JpaRepository<RoleMaster, Serializable> {
	List<RoleMaster> getAllRolesByDepartment(
			@Param("department") String department);
}
