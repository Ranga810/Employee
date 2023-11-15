package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.mindgate.main.domain.TravelAgent;

public class TravelAgentRowmapper implements RowMapper<TravelAgent> {

	@Override
	public TravelAgent mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int agentId=rs.getInt("agent_id");
		String firstName=rs.getString("first_name");
		String lastName=rs.getString("last_name");
		String loginId=rs.getString("login_id");
		String password=rs.getString("password");
		String email=rs.getString("email");
		long contactNumber=rs.getLong("contact_number");
		
		TravelAgent employeeTravel= new TravelAgent(agentId, firstName, lastName, loginId, password, email, contactNumber);
		return employeeTravel;
	}

}

