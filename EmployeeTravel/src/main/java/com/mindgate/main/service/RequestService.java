package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.TravelRequest;
import com.mindgate.main.repository.TravelRequestRepositoryInterface;
@Service
public class RequestService implements RequestServiceInterface{
	@Autowired
	private TravelRequestRepositoryInterface travelRequestRepositoryInterface;

	@Override
	public boolean addnewrequest(TravelRequest travelRequest) {
		return travelRequestRepositoryInterface.addnewrequest(travelRequest);
	}

	@Override
	public TravelRequest updaterequest(TravelRequest travelRequest) {
		return travelRequestRepositoryInterface.updaterequest(travelRequest);
	}

	@Override
	public boolean deleterequest(int requestId) {
		return travelRequestRepositoryInterface.deleterequest(requestId);
	}

	

	@Override
	public List<TravelRequest> getallrequests() {
		return  travelRequestRepositoryInterface.getallrequests();
	}

	@Override
	public TravelRequest getrequestByrequestId(int requestId) {
		return  travelRequestRepositoryInterface.getrequestByrequestId(requestId);
	}

	@Override
	public List<TravelRequest> getrequestByemployeeId(int employeeId) {
		return  travelRequestRepositoryInterface.getrequestByemployeeId(employeeId);
	}

	/*@Override
	public TravelRequest getrequestByemployeeId(int employeeId) {
		return  travelRequestRepositoryInterface.getrequestByemployeeId(employeeId);
	}
	*/
	
	

}
