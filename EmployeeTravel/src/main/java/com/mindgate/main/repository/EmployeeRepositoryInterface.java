package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.EmployeeDetails;
//import com.mindgate.main.domain.LoginDetailsSB;

public interface EmployeeRepositoryInterface {
   public boolean addNewEmployee (EmployeeDetails employeeDetails );
   
   public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails);
   
   public boolean deleteEmployee(int employeeId);
   
   public EmployeeDetails getEmployeeByEmployeeId(int employeeId);
   
   public List<EmployeeDetails> getAllEmployees();
   
   public EmployeeDetails getLoginDetailsByEmployeeId(EmployeeDetails employeeDetails);
   
   //public LoginDetailsSB getLoginDetailsByLoginId(LoginDetailsSB loginDetails);
   
   
   
	
}
