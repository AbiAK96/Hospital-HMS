package com.hospital.model;

public class Patient {
	
	private int patientId;
	private String patientName;
	private String patientNIC;
	private String patientAge;
	private String patientGender;
	private String patientAddress;
	private String patientTel;
	private String patientStatus;
	private String admitDate;
	private String dischargeDate;
	private int branchId;
	private int doctorId;
	private int wardId;
	
	

	public Patient(int patientId, String patientName, String patientNIC, String patientAge, String patientGender,
			String patientAddress, String patientTel, String patientStatus, String admitDate, String dischargeDate,
			int branchId, int doctorId, int wardId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientNIC = patientNIC;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientAddress = patientAddress;
		this.patientTel = patientTel;
		this.patientStatus = patientStatus;
		this.admitDate = admitDate;
		this.dischargeDate = dischargeDate;
		this.branchId = branchId;
		this.doctorId = doctorId;
		this.wardId = wardId;
	}

	public Patient() {
		
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientTel() {
		return patientTel;
	}

	public void setPatientTel(String patientTel) {
		this.patientTel = patientTel;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getPatientNIC() {
		return patientNIC;
	}

	public void setPatientNIC(String patientNIC) {
		this.patientNIC = patientNIC;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientNIC=" + patientNIC
				+ ", patientAge=" + patientAge + ", patientGender=" + patientGender + ", patientAddress="
				+ patientAddress + ", patientTel=" + patientTel + ", patientStatus=" + patientStatus + ", admitDate="
				+ admitDate + ", dischargeDate=" + dischargeDate + ", branchId=" + branchId + ", doctorId=" + doctorId
				+ ", wardId=" + wardId + "]";
	}
	
	

}
