package com.hospital.model;

public class Ward {
	
	private int wardId;
	private String wardType;
	private int branchId;
	
	
	public Ward() {
	}


	public Ward(int wardId, String wardType, int branchId) {
		super();
		this.wardId = wardId;
		this.wardType = wardType;
		this.branchId = branchId;
	}


	public int getWardId() {
		return wardId;
	}


	public void setWardId(int wardId) {
		this.wardId = wardId;
	}


	public String getWardType() {
		return wardType;
	}


	public void setWardType(String wardType) {
		this.wardType = wardType;
	}


	public int getBranchId() {
		return branchId;
	}


	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}


	
}
