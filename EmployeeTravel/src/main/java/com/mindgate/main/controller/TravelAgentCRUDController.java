package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.TravelAgent;
import com.mindgate.main.service.TravelAgentServiceInterface;

@RestController
@RequestMapping("Travelapi")
public class TravelAgentCRUDController {
	

	@Autowired
	private TravelAgentServiceInterface travelAgentServiceInterface;

	@RequestMapping(value="alltraveldetails",method=RequestMethod.GET)
	public List<TravelAgent> getAllDetails() {

		return travelAgentServiceInterface.getAllDetails();
	}
	
	@RequestMapping(value="addnew",method =RequestMethod.POST)
	public boolean addNewDetails(@RequestBody TravelAgent travelAgent) {
		
		return travelAgentServiceInterface.addNewDetails(travelAgent);
	}
	
	@RequestMapping(value="selectone/{agentId}",method =RequestMethod.GET)
	public TravelAgent getDetailsByAgentId(@PathVariable int agentId) {
		return travelAgentServiceInterface.getDetailsByAgentId(agentId);
		
	}
	
	@RequestMapping(value="updatedetails/update",method = RequestMethod.PUT)
	public TravelAgent updateDetails(@RequestBody TravelAgent travelAgent ) {
		return travelAgentServiceInterface.updateDetails(travelAgent);
		
	}
	@RequestMapping(value = "deletedetails/{agentId}",method = RequestMethod.DELETE)
	public boolean deleteDetails(@PathVariable int agentId) {
		return travelAgentServiceInterface.deleteDetails(agentId);
		
	}
	@RequestMapping(value ="validation",method = RequestMethod.GET)
	public TravelAgent agentLogin(@RequestBody TravelAgent travelAgent) {
		return travelAgentServiceInterface.logIn(travelAgent);
	}


}
