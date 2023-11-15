package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.TravelAgent;
import com.mindgate.main.repository.TravelAgentRepositoryInterface;




@Service
public class TravelAgentService implements TravelAgentServiceInterface {
	
	@Autowired
	private TravelAgentRepositoryInterface travelAgentRepositoryInterface;

	@Override
	public boolean addNewDetails(TravelAgent travelAgent) {
		
		return travelAgentRepositoryInterface.addNewDetails(travelAgent);
	}

	@Override
	public TravelAgent updateDetails(TravelAgent travelAgent) {
		
		return travelAgentRepositoryInterface.updateDetails(travelAgent);
	}

	@Override
	public boolean deleteDetails(int agentId) {
		
		return travelAgentRepositoryInterface.deleteDetails(agentId);
	}

	@Override
	public TravelAgent getDetailsByAgentId(int agentId) {
	
		return travelAgentRepositoryInterface.getDetailsByAgentId(agentId);
	}

	@Override
	public List<TravelAgent> getAllDetails() {
		
		return travelAgentRepositoryInterface.getAllDetails();
	}
	
	public TravelAgent logIn(TravelAgent travelAgent) {
	
		
		String loginId = travelAgent.getLoginId();
		String password = travelAgent.getPassword();
		int agentId = travelAgent.getAgentId();
		
		
		TravelAgent existingTravelAgent = travelAgentRepositoryInterface.getDetailsByAgentId(agentId);
	
		if(existingTravelAgent.getLoginId()==travelAgent.getLoginId() && 
				existingTravelAgent.getPassword().equals(existingTravelAgent.getPassword())) {
			
			return existingTravelAgent;
		}
		
		return travelAgent;
		
	}
	

}
