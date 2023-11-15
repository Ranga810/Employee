package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.EmployeeDetails;


public interface EmployeeServiceInterface  {
	  public boolean addNewEmployee (EmployeeDetails employeeDetails );
	   
	   public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails);
	   
	   public boolean deleteEmployee(int employeeId);
	   
	   public EmployeeDetails getEmployeeByEmployeeId(int employeeId);
	   
	   public List<EmployeeDetails> getAllEmployees();
	   
	   

	  // public EmployeeDetails getLoginDetailsByEmployeeId(EmployeeDetails employeeDetails);
	   
	   public EmployeeDetails login(EmployeeDetails employeeDetails);
	   
}
