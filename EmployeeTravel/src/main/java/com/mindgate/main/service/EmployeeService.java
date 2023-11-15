package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.EmployeeDetails;
//import com.mindgate.main.domain.LoginDetailsSB;
import com.mindgate.main.repository.EmployeeRepositoryInterface;

@Service
@Scope("prototype")
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepositoryInterface employeeRepositoryInterface;

	@Override
	public boolean addNewEmployee(EmployeeDetails employeeDetails) {
		return employeeRepositoryInterface.addNewEmployee(employeeDetails);
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
		return employeeRepositoryInterface.updateEmployee(employeeDetails);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeRepositoryInterface.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDetails getEmployeeByEmployeeId(int employeeId) {
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepositoryInterface.getAllEmployees();
	}

	@Override
	public EmployeeDetails login(EmployeeDetails employeeDetails) {
		String loginId = employeeDetails.getLoginId();
		String password = employeeDetails.getPassword();
		int employeeId = employeeDetails.getEmployeeId();
		EmployeeDetails oldEmployee = employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);

		if (oldEmployee.getEmployeeId()==employeeId) {
			if (oldEmployee.getPassword().equals(password)) {
				return oldEmployee;
			}
		}
		return null;
	}

}
