package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Document;
import com.mindgate.main.repository.DocumentRepositoryInterface;
@Service
public class DocumentService implements DocumentServiceInterface {
	
@Autowired	
	DocumentRepositoryInterface documentRepositoryInterface;

	@Override
	public Document getDocumentByDocumentId(int documentId) {
		// TODO Auto-generated method stub
		return documentRepositoryInterface.getDocumentByDocumentId(documentId);
	}

	@Override
	public boolean addNew(Document document) {
		return documentRepositoryInterface.addNew(document);
	}

	@Override
	public Document updateDocumentDetails(Document document) {

		return documentRepositoryInterface.updateDocumentDetails(document);
	}

	@Override
	public boolean delete(int documentId) {

		return documentRepositoryInterface.delete(documentId);
	}

	@Override
	public List<Document> getAllDocument() {
		return documentRepositoryInterface.getAllDocument();
	}

}
