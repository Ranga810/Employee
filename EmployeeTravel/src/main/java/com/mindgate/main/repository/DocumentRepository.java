package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindgate.main.domain.Document;

@Repository
public class DocumentRepository  implements DocumentRepositoryInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String SELECT_One_Document
	="select * from document where Document_Id=?";
	private final static String INSERT_NEW_Document
	= "insert into document values(document_id.nextVal,?,?,?,?)";
	private final static String UPDATE_DOCUMENT
	="update document  set id_proof = ? ,aadharcard=?,pancard=?,passport=? where Document_Id=?";

	private final static String  DELETE_EXISTING_Document
	="delete from document where Document_Id=?";
	
	private final static String SELECT_ALL_DOCUMENT="select * from document";
	

	@Override
	public Document getDocumentByDocumentId( int documentId) {

		DocumentRowMapper documentRowMapper = new DocumentRowMapper();
		return jdbcTemplate.queryForObject(SELECT_One_Document, documentRowMapper,documentId);
	}


	@Override
	public boolean addNew(Document document) {
		
		Object [] parameters = {document.getIdProof(),document.getAadharCard(),document.getPanCard(),document.getPassport()};
		jdbcTemplate.update(INSERT_NEW_Document,parameters);
		System.out.println("added succsess fully");
		return true;
	}


	@Override
//	public Document updateDocumentDetails(Document document) {
	public Document updateDocumentDetails(Document document) {
		
	
		Object [] parameters = {document.getIdProof(),document.getAadharCard(),document.getPanCard(),document.getPassport(),document.getDocumentId()};
		int rowCount =jdbcTemplate.update(UPDATE_DOCUMENT,parameters);
		if (rowCount>0){
			 
			 System.out.println("Update Success fulll");
			 return getDocumentByDocumentId(document.getDocumentId());
		}
		
		return null;
	}


	@Override
	public boolean delete(int documentId) {


		
		int rowCount=jdbcTemplate.update(DELETE_EXISTING_Document,documentId);
		if(rowCount>0) {
			System.out.println("deleted successs fully");
			System.out.println("check your table");
			return true;
		}
		return false;
	}



	public List<Document> getAllDocument() {
	
		DocumentRowMapper documentRowMapper = new DocumentRowMapper();
		return jdbcTemplate.query(SELECT_ALL_DOCUMENT,documentRowMapper);
		
	}

}
