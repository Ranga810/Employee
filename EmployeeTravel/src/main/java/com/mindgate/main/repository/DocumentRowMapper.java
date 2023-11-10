package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Document;

public class DocumentRowMapper  implements RowMapper<Document>{

	@Override
	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {

		int documentId=rs.getInt("document_id");
		String idProof=rs.getString("id_proof");
		 String  aadharCard=rs.getString("aadharcard");
		String panCard =rs.getString("panCard");
		String passport =rs.getString("passport");
		Document document= new Document(documentId, idProof, aadharCard, panCard, passport);
		
		
		return document;
	}
	

}
