package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Document;

public interface DocumentRepositoryInterface {
	
	
	public boolean addNew(Document document);
public Document updateDocumentDetails(Document document);
	
	public boolean delete(int documentId);
	
	public Document getDocumentByDocumentId(int documentId);
	 public List<Document> getAllDocument();

}
