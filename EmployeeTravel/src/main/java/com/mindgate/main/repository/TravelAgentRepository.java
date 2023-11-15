package com.mindgate.main.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.TravelAgent;

@Repository
public class TravelAgentRepository implements TravelAgentRepositoryInterface {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String SELECT_ALL_DETAILS="select * from travel_agent";
	private final static String SELECT_ONE_DETAILS="select * from travel_agent where AGENT_ID=?";
	private final static String INSERT_NEW_DETAILS="INSERT INTO TRAVEL_AGENT VALUES(?,?,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_DETAILS="update  travel_agent set first_name=?,last_name=?,login_id=?,password=?,email=?,contact_number=? where agent_id=?";
	private final static String DELETE_EXISTING_DETAILS="delete from travel_agent where agent_id=? ";

	

	@Override
	public boolean addNewDetails(TravelAgent travelAgent) {
		
		Object[] parameter = { travelAgent.getAgentId(), travelAgent.getFirstName(),travelAgent.getLastName(),
				travelAgent.getLoginId(),travelAgent.getPassword(),travelAgent.getEmail(),travelAgent.getContactNumber()};
		jdbcTemplate.update(INSERT_NEW_DETAILS, parameter);
		System.out.println("added succsess fully");
		return true;
	}
	
	@Override
	public TravelAgent updateDetails(TravelAgent employeeTravel) {
		Object[] parameter2 = {
				 
				employeeTravel.getFirstName(),
				employeeTravel.getLastName(),
				employeeTravel.getLoginId(),
				employeeTravel.getPassword(),
				employeeTravel.getEmail(),
				employeeTravel.getContactNumber(),
				employeeTravel.getAgentId()};
		
		int rowCount=jdbcTemplate.update(UPDATE_EXISTING_DETAILS, parameter2);
		
		if(rowCount>0) {
			
		//	return getDetailsByAgentId(employeeTravel.getAgentId());
			return getDetailsByAgentId(employeeTravel.getAgentId());
			
		}
			return null;
	}
		

	@Override
	public boolean deleteDetails(int agentId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_DETAILS, agentId	);

		if (rowCount > 0) {
			System.out.println("deleted successs fully");
			System.out.println("check your table");
			return true;

		} else {
			return false;

		}
	}

	@Override
	public TravelAgent getDetailsByAgentId(int agentId) {
		
		TravelAgentRowmapper  employeeTravelRowMapper= new TravelAgentRowmapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_DETAILS, employeeTravelRowMapper, agentId);
	}

	public List<TravelAgent> getAllDetails() {
		
		TravelAgentRowmapper employeeTravelRowMapper=new TravelAgentRowmapper();
		
		return jdbcTemplate.query(SELECT_ALL_DETAILS, employeeTravelRowMapper);
	}
	
	
	
	
	
	
	

	

}
