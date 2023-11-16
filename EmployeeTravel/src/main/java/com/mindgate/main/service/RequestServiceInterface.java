package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.TravelRequest;

public interface RequestServiceInterface {
	public boolean addnewrequest(TravelRequest travelRequest );
	 public TravelRequest  updaterequest(TravelRequest travelRequest);
	public boolean deleterequest(int requestId);
	public  TravelRequest getrequestByrequestId(int requestId);
	public List<TravelRequest>getallrequests();
	// public  TravelRequest getrequestByemployeeId(int employeeId);
	public List<TravelRequest> getrequestByemployeeId(int employeeId);
}
