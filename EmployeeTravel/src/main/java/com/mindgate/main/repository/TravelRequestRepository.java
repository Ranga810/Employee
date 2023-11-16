package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.TravelRequest;
@Repository
public class TravelRequestRepository implements TravelRequestRepositoryInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final  static String INSERT_NEW_REQUEST="insert into travel_request values (travel_request_id.nextVal,?,?,?,?,?,?,?,?,?)";
	
	private final static String UPDATE_EXISTING_REQUEST="update travel_request  set employee_id=?,travel_medium=?,travel_start_date=?,travel_end_date=?,travel_purpose=?,PM_authorization_status=?,TM_authorization_status=?,d_authorization_status=?,document_id=? where travel_request_id=?";
			
	
    private final static String SELECT_ALL_REQUESTS="select * from travel_request r,document d ,employee_details e ,slab s where r.DOCUMENT_ID=d.DOCUMENT_ID and r.EMPLOYEE_ID=e.EMPLOYEE_ID and s.slab_id=e.slab_id";
    private final static String SELECT_ONE_REQUEST=" select * from travel_request r, document d,employee_details e,slab s where r.DOCUMENT_ID=d.DOCUMENT_ID and r.EMPLOYEE_ID=e.EMPLOYEE_ID and s.slab_id=e.slab_id  and  travel_request_id=?";
    	

	private final static String DELETE_EXISTING_REQUEST="delete from travel_request where travel_request_id =?";
	
	private final static String SELECT_REQUEST_EMPLOYEEID="select * from travel_request r, document d,employee_details e,slab s where r.DOCUMENT_ID=d.DOCUMENT_ID and r.EMPLOYEE_ID=e.EMPLOYEE_ID and s.slab_id=e.slab_id  and  r.employee_id=?";
			

	@Override
	public boolean addnewrequest(TravelRequest travelRequest) {
		 Object[] parameters = { 
				 travelRequest.getRequestId(),
				 travelRequest.getEmployeeId(),
				 travelRequest.getTravelMedium(),
				 travelRequest.getTravelStartDate(),
				 travelRequest.getTravelEndDate(),
				 travelRequest.getTravelpurpose(),
				 travelRequest.getpMAuthorisation(),
				 travelRequest.getTMAuthorisation(),
				 travelRequest.getDirectorAuthorisation(),
				 travelRequest.getDocumentId()};
		 jdbcTemplate.update(INSERT_NEW_REQUEST, parameters);
			return true;
	
	}
	@Override
	public TravelRequest updaterequest(TravelRequest travelRequest) {
Object [] parameters = { 
		travelRequest.getEmployeeId(),
		travelRequest.getTravelMedium(),
		travelRequest.getTravelStartDate(),
		travelRequest.getTravelEndDate(),
		travelRequest.getTravelpurpose(),
		travelRequest.getpMAuthorisation(),
		travelRequest.getTMAuthorisation(),
		travelRequest.getDirectorAuthorisation(),
		travelRequest.getDocument(),
		travelRequest.getRequestId() };
//set employee_id=?,travel_medium=?,travel_start_date=?,travel_end_date=?,travel_purpose=?,PM_authorization_status=?,TM_authorization_status=?,d_authorization_status=?,document_id=? where travel_request_id=?		
    	int rowcount = jdbcTemplate.update(UPDATE_EXISTING_REQUEST, parameters);
    	if(rowcount >0){
    		return getrequestByrequestId(travelRequest.getRequestId());
    	}
    	return null;
	
	}
	

	@Override
	public boolean deleterequest(int requestId) {
		
			jdbcTemplate.update(DELETE_EXISTING_REQUEST,requestId);
		       return true;
		}
	

	@Override
	public TravelRequest getrequestByrequestId(int requestId) {
		RequestRowMapper requestRowMapper = new RequestRowMapper();
    	TravelRequest travelRequest =jdbcTemplate.queryForObject(SELECT_ONE_REQUEST, requestRowMapper,requestId);
    	return travelRequest;
	}

	@Override
	public List<TravelRequest> getallrequests() {
		RequestRowMapper requestRowMapper = new RequestRowMapper();
    	return jdbcTemplate.query(SELECT_ALL_REQUESTS,requestRowMapper);
	}
	/*@Override
	public TravelRequest getrequestByemployeeId(int employeeId) {
		RequestRowMapper requestRowMapper = new RequestRowMapper();
		TravelRequest travelRequest =jdbcTemplate.queryForObject(SELECT_REQUEST_EMPLOYEEID, requestRowMapper,employeeId);
    	
		return travelRequest;
	}
	*/
	@Override
	public List<TravelRequest> getrequestByemployeeId(int employeeId) {
		RequestRowMapper requestRowMapper = new RequestRowMapper();
		return jdbcTemplate.query(SELECT_REQUEST_EMPLOYEEID,requestRowMapper,employeeId);
		
	}
	
}
