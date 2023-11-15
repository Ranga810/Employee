package com.mindgate.main.domain;

public class TravelAgent {

	private int agentId;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String email;
	private long contactNumber;

	public TravelAgent() {
		// TODO Auto-generated constructor stub
	}

	public TravelAgent(int agentId, String firstName, String lastName, String loginId, String password, String email,
			long contactNumber) {
		super();
		this.agentId = agentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "EmployeeTravel [agentId=" + agentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", loginId=" + loginId + ", password=" + password + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}

}
