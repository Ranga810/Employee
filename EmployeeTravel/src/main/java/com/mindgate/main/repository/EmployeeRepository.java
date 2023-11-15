package com.mindgate.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.EmployeeDetails;
//import com.mindgate.main.domain.LoginDetailsSB;
import com.mindgate.main.domain.Slab;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String SELECT_ALL_EMPLOYEES = "select * from employee_details e,SLAB s where e.SLAB_ID=s.SLAB_ID";
	private final static String SELECT_ONE_EMPLOYEE = "select *  from employee_details,SLAB where employee_details.SLAB_ID=SLAB.SLAB_ID  and employee_details.EMPLOYEE_ID=?";
	private final static String INSERT_NEW_EMPLOYEE = "insert into employee_details values(EMPLOYEE_ID.nextVal,?,?,?,?,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_EMPLOYEE = "update employee_details set FIRST_NAME=?,LAST_NAME=?,LOGIN_ID=?,PASSWORD=?,Role=?,EMAIL=?,CONTACT_NUMBER=?,Manager_id=? where EMPLOYEE_ID=?";
	private final static String DELETE_EXISTING_EMPLOYEE = "delete from employee_details where EMPLOYEE_ID=?";
	private final static String SELECT_ONE_LOGIN_DETAILS = "select *  from employee_details,SLAB where employee_details.SLAB_ID=SLAB.SLAB_ID  and employee_details.EMPLOYEE_ID=?";

	public void testConnection() {
		if (jdbcTemplate != null) {
			System.out.println("Connected Successfully !!");
		} else {
			System.out.println(" Not Connected !!");
		}
	}

	@Override
	public boolean addNewEmployee(EmployeeDetails employeeDetails) {
		Object parameters[] = { employeeDetails.getFirstName(), employeeDetails.getLastName(),
				employeeDetails.getLoginId(), employeeDetails.getPassword(), employeeDetails.getRole(),
				employeeDetails.getEmail(), employeeDetails.getContactNo(), employeeDetails.getManagerId(),
				employeeDetails.getSlab().getSlabId() };
		int rowcount = jdbcTemplate.update(INSERT_NEW_EMPLOYEE, parameters);
		if (rowcount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
		Object[] parameters = { employeeDetails.getFirstName(), employeeDetails.getLastName(),
				employeeDetails.getLoginId(), employeeDetails.getPassword(), employeeDetails.getRole(),
				employeeDetails.getEmail(), employeeDetails.getContactNo(), employeeDetails.getManagerId(),
				employeeDetails.getEmployeeId() };

		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_EMPLOYEE, parameters);
		System.out.println(rowCount);
		if (rowCount > 0) {
			return employeeDetails;
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_EMPLOYEE, employeeId);
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EmployeeDetails getEmployeeByEmployeeId(int employeeId) {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, employeeRowMapper,
				employeeId);
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEES, employeeRowMapper);
	}

	@Override
	public EmployeeDetails getLoginDetailsByEmployeeId(EmployeeDetails employeeDetails) {

		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		EmployeeDetails existingLogin = jdbcTemplate.queryForObject(SELECT_ONE_LOGIN_DETAILS, employeeRowMapper,employeeDetails.getEmployeeId());
		if (existingLogin != null)
			return existingLogin;
		else
			return null;
	}
}
