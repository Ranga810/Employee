package com.mindgate.main.repository;
//package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TravelAgent;

//import com.mindgate.main.domain.Employee;
//import com.mindgate.main.domain.EmployeeTravel;

public interface TravelAgentRepositoryInterface {

	public boolean addNewDetails(TravelAgent travelAgent);

	public TravelAgent updateDetails(TravelAgent trave);

	public boolean deleteDetails(int agentId);

	public TravelAgent getDetailsByAgentId(int agentId);

	List<TravelAgent> getAllDetails();

//		public Employee updateEmployeeSalary(Employee employee);

}
