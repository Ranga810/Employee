package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Document;

public interface DocumentServiceInterface {
	public Document getDocumentByDocumentId(int documentId);
	public boolean addNew(Document document);
	public Document updateDocumentDetails(Document document);
	public boolean delete(int documentId);
	public List<Document> getAllDocument();

}
