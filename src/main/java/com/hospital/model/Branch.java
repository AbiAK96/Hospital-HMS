package com.hospital.model;

public class Branch {
	
	private int branchId;
	private String branchName;
	private String branchAddress;
	private String branchEmail;
	private String branchTel;
	
	
	public Branch(int branchId, String branchName, String branchAddress, String branchEmail, String branchTel) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchEmail = branchEmail;
		this.branchTel = branchTel;
	}


	public Branch() {
		
	}


	public int getBranchId() {
		return branchId;
	}


	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getBranchAddress() {
		return branchAddress;
	}


	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}


	public String getBranchEmail() {
		return branchEmail;
	}


	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}


	public String getBranchTel() {
		return branchTel;
	}


	public void setBranchTel(String branchTel) {
		this.branchTel = branchTel;
	}
}
