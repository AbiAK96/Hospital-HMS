package com.hospital.model;

public class Transfer {
	
	private int transferId;
	private String patientName;
	private int branchId;
	private String transferDate;
	
	public Transfer(int transferId, String patientName, int branchId, String transferDate) {
		
		this.transferId = transferId;
		this.patientName = patientName;
		this.branchId = branchId;
		this.transferDate = transferDate;
	}

	public Transfer() {
		
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	
}
