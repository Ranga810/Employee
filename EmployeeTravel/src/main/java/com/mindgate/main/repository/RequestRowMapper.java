package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Document;
import com.mindgate.main.domain.EmployeeDetails;

import com.mindgate.main.domain.TravelRequest;

public class RequestRowMapper implements RowMapper<TravelRequest> {

	@Override
	public TravelRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		EmployeeRowMapper employeeRowMapper=new EmployeeRowMapper();
		EmployeeDetails employeeDetails = employeeRowMapper.mapRow(rs, rowNum);
		
		
		DocumentRowMapper documentRowMapper = new DocumentRowMapper();
		Document document = documentRowMapper.mapRow(rs, rowNum);
			
			int equestId =rs.getInt("travel_request_id");
			int EmployeeId=rs.getInt("Employee_Id");
			 String travelMedium=rs.getString("travel_medium");
			 String travelStartDate=rs.getString("travel_start_date");
			 String travelEndDate=rs.getString("travel_end_date");
			 String travelpurpose=rs.getString("travel_purpose");
			 String PMAuthorisation=rs.getString("pm_authorization_status");
			 String TMAuthorisation=rs.getString("tm_authorization_status");
			 String DirectorAuthorisation=rs.getString("d_authorization_status");
      		 int documentId=rs.getInt("document_id");
			 
			 
			 TravelRequest travelRequest =new TravelRequest(equestId, EmployeeId, travelMedium, travelStartDate, travelEndDate, travelpurpose, PMAuthorisation, TMAuthorisation, DirectorAuthorisation, documentId, document, employeeDetails);
			
		 return travelRequest;
	}

}
