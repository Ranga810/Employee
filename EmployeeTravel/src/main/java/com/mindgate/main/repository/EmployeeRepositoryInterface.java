package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.EmployeeDetails;

public interface EmployeeRepositoryInterface {
   public boolean addNewEmployee (EmployeeDetails employeeDetails );
   
   public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails);
   
   public boolean deleteEmployee(int employeeId);
   
   public EmployeeDetails getEmployeeByEmployeeId(int employeeId);
   
   public List<EmployeeDetails> getAllEmployees();
   
	
}
