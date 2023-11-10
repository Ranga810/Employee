package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TravelRequest;

public interface TravelRequestRepositoryInterface {
	public boolean addnewrequest(TravelRequest TravelRequest);

	public  TravelRequest updaterequest(TravelRequest TravelRequest);
	public boolean deleterequest(int requestId);
	public TravelRequest getrequestByrequestId(int requestId);

	public List<TravelRequest> getallrequests();
}
