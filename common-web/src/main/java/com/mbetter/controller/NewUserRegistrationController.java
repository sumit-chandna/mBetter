package com.mbetter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbetter.domain.employee.department.EmployeeDepartment;
import com.mbetter.forms.RegisterForm;
import com.mbetter.repositories.dropdown.DropDownRepository;
import com.mbetter.repositories.employee.department.EmployeeDepartmentRepository;
import com.mbetter.repositories.employee.subdepartment.EmployeeSubDepartmentRepository;

/**
 * Controller for New User Login Form
 * @author manikmalhotra
 *
 */

@Controller
@RequestMapping("/login")
public class NewUserRegistrationController {

	@Autowired
	private DropDownRepository dropDownRepo;

	@Autowired
	private EmployeeDepartmentRepository empDeptRepo;

	@Autowired
	private EmployeeSubDepartmentRepository empSubDeptRepo;

	public DropDownRepository getDropDownRepo() {
		return dropDownRepo;
	}

	public void setDropDownRepo(DropDownRepository dropDownRepo) {
		this.dropDownRepo = dropDownRepo;
	}

	public EmployeeDepartmentRepository getEmpDeptRepo() {
		return empDeptRepo;
	}

	public void setEmpDeptRepo(EmployeeDepartmentRepository empDeptRepo) {
		this.empDeptRepo = empDeptRepo;
	}

	public EmployeeSubDepartmentRepository getEmpSubDeptRepo() {
		return empSubDeptRepo;
	}

	public void setEmpSubDeptRepo(EmployeeSubDepartmentRepository empSubDeptRepo) {
		this.empSubDeptRepo = empSubDeptRepo;
	}

	@RequestMapping("/createUser")
	public String createNewUser(final Model model) {
		model.addAttribute("RegisterForm", new RegisterForm());
		model.addAttribute("employeeType",
				dropDownRepo.getAllDropDownValues("employeeType"));
		model.addAttribute("employeeDepartment",
				empDeptRepo.getAllDepartments());
		model.addAttribute("employeeSubDepartment",
				empSubDeptRepo.getAllSubDepartments(1));

		return "/users/newUserRegistration";
	}

}