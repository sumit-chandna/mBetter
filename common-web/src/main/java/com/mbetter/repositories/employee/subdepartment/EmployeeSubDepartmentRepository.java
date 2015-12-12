package com.mbetter.repositories.employee.subdepartment;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.employee.department.EmployeeDepartment;
import com.mbetter.domain.employee.subdepartment.EmployeeSubDepartment;

@Repository
public interface EmployeeSubDepartmentRepository extends JpaRepository<EmployeeSubDepartment, Serializable> {
	
	public List<EmployeeSubDepartment> getAllSubDepartments(@Param("departmentId") int departmentId);

}
