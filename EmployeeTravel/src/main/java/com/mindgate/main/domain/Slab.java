package com.mindgate.main.domain;

import org.springframework.stereotype.Component;

@Component
public class Slab {
	private int slabId;
	private String role;
	private String internationalTravel;
	private int slab_Amount;
	private String internationalForex;

	public Slab() {
		// TODO Auto-generated constructor stub
	}

	public Slab(int slabId, String role, String internationalTravel, int slab_Amount, String internationalForex) {
		super();
		this.slabId = slabId;
		this.role = role;
		this.internationalTravel = internationalTravel;
		this.slab_Amount = slab_Amount;
		this.internationalForex = internationalForex;
	}

	public int getSlabId() {
		return slabId;
	}

	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getInternationalTravel() {
		return internationalTravel;
	}

	public void setInternationalTravel(String internationalTravel) {
		this.internationalTravel = internationalTravel;
	}

	public int getSlab_Amount() {
		return slab_Amount;
	}

	public void setSlab_Amount(int slab_Amount) {
		this.slab_Amount = slab_Amount;
	}

	public String getInternationalForex() {
		return internationalForex;
	}

	public void setInternationalForex(String internationalForex) {
		this.internationalForex = internationalForex;
	}

	@Override
	public String toString() {
		return "Slab [slabId=" + slabId + ", role=" + role + ", internationalTravel=" + internationalTravel
				+ ", slab_Amount=" + slab_Amount + ", internationalForex=" + internationalForex + "]";
	}

}
