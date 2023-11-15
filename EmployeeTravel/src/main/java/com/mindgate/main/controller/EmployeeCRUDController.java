package com.mindgate.main.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.EmployeeDetails;
//import com.mindgate.main.domain.LoginDetailsSB;
import com.mindgate.main.domain.Slab;
import com.mindgate.main.service.EmployeeServiceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("employeetravel")
public class EmployeeCRUDController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	// http://localhost:8088/employeetravel/employees
	@RequestMapping(value = "employees", method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployees() {
		return employeeServiceInterface.getAllEmployees();
	}

	// http://localhost:8088/employeetravel/getoneemp/{EMPLOYEE_ID}
	@RequestMapping(value = "getoneemp/{EMPLOYEE_ID}", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeByEmployeeId(@PathVariable int EMPLOYEE_ID) {
		EmployeeDetails employeeDetails = employeeServiceInterface.getEmployeeByEmployeeId(EMPLOYEE_ID);
		return employeeDetails;
	}

	// http://localhost:8088/employeetravel/addnewemp
	@RequestMapping(value = "addnewemp", method = RequestMethod.POST)
	public boolean addNewEmployee(@RequestBody EmployeeDetails employeeDetails) {
		return employeeServiceInterface.addNewEmployee(employeeDetails);
	}

	// http://localhost:8088/employeetravel/updateemp
	@RequestMapping(value = "updateemp", method = RequestMethod.PUT)
	public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails employeeDetails) {
		System.out.println(employeeDetails);
		return employeeServiceInterface.updateEmployee(employeeDetails);
	}

	// http://localhost:8088/employeetravel/deleteemp/{EMPLOYEE_ID}
	@RequestMapping(value = "deleteemp/{EMPLOYEE_ID}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int EMPLOYEE_ID) {
		return employeeServiceInterface.deleteEmployee(EMPLOYEE_ID);
	}

	@RequestMapping(value = "loginId/employeeDetails", method = RequestMethod.PUT)
	public EmployeeDetails login(@RequestBody EmployeeDetails employeeDetails) {
		return employeeServiceInterface.login(employeeDetails);
	}

}