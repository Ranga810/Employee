package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.TravelRequest;
import com.mindgate.main.service.RequestServiceInterface;

@RestController
@RequestMapping("requestapi")
public class RequestCrudController {
	@Autowired
	private RequestServiceInterface requestServiceInterface;
	@RequestMapping(value="request/{requestId}",method = RequestMethod.DELETE)
	public boolean deleteterequest(@PathVariable int requestId) {
		return requestServiceInterface.deleterequest(requestId);
	}
	
	//http://localhost:8085/requestapi/requests
	@RequestMapping(value="requests",method = RequestMethod.GET)
	public List<TravelRequest> getallrequests(){
		return requestServiceInterface.getallrequests();
	}
	@RequestMapping(value="request/{requestId}",method = RequestMethod.GET)
	public TravelRequest selectonerequest(@PathVariable int requestId) {
		return requestServiceInterface.getrequestByrequestId(requestId);
	}
	@RequestMapping(value="requests/request",method = RequestMethod.POST)
		public boolean addnewrequest(@RequestBody TravelRequest travelRequest) {
			return requestServiceInterface.addnewrequest(travelRequest);
		}
	@RequestMapping(value="requests/request",method = RequestMethod.PUT)
	public TravelRequest updaterequest(@RequestBody TravelRequest  travelRequest ) {
		return requestServiceInterface.updaterequest(travelRequest);
	}

}
