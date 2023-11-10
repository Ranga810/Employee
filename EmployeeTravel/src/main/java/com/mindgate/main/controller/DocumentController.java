package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Document;
import com.mindgate.main.repository.DocumentRowMapper;
import com.mindgate.main.service.DocumentServiceInterface;

@RestController
@RequestMapping("Documentapi")
public class DocumentController {
	
	@Autowired
	DocumentServiceInterface documentServiceInterface;
	
	@RequestMapping(value = "document/{documentId}", method = RequestMethod.GET)
	public Document getDocumentByDocumentId(@PathVariable int documentId) {
    
		
		return documentServiceInterface.getDocumentByDocumentId(documentId);
		
	}
	
	@RequestMapping(value="document/{documentId}",method = RequestMethod.DELETE)
	public boolean delete(@PathVariable int documentId) {

		return documentServiceInterface.delete(documentId);
	}
	
	@RequestMapping(value="document/ad",method = RequestMethod.POST)
	public boolean addNew(@RequestBody  Document document) {
		return documentServiceInterface.addNew(document);
	}

	@RequestMapping(value="document/up",method = RequestMethod.PUT)
	public Document updateDocumentDetails(@RequestBody   Document document) {

		return documentServiceInterface.updateDocumentDetails(document);
	}
	
	
	
	
	
	@RequestMapping(value = "document/sa", method = RequestMethod.GET)
	
	public List<Document> getAEmployees() {
		return documentServiceInterface.getAllDocument();
	}

	
	
	
	

	

}
