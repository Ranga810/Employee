package com.mindgate.main.domain;

public class Document {
	
	private int documentId;
	private String idProof;
	private String aadharCard;
	private String panCard;
	private String passport;
	public Document(int documentId, String idProof, String aadharCard, String panCard, String passport) {
		super();
		this.documentId = documentId;
		this.idProof = idProof;
		this.aadharCard = aadharCard;
		this.panCard = panCard;
		this.passport = passport;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", idProof=" + idProof + ", aadharCard=" + aadharCard
				+ ", panCard=" + panCard + ", passport=" + passport + "]";
	}
	
	
	
	
	
	
}
