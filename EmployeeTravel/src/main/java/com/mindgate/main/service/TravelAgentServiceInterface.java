package com.mindgate.main.service;

import java.util.List;


import com.mindgate.main.domain.TravelAgent;

public interface TravelAgentServiceInterface {
	
	public boolean addNewDetails(TravelAgent travelAgent);
	public TravelAgent updateDetails(TravelAgent travelAgent);
	public boolean deleteDetails(int agentId);
	public TravelAgent getDetailsByAgentId(int agentId);
	public List<TravelAgent> getAllDetails();
	public TravelAgent logIn(TravelAgent travelAgent);

}
