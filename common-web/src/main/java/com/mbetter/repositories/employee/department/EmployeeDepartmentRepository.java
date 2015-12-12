package com.mbetter.repositories.employee.department;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.employee.department.EmployeeDepartment;

@Repository
public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Serializable> {
	
	public List<EmployeeDepartment> getAllDepartments();

}
