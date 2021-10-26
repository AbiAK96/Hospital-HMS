package com.hospital.model;

public class DoctorDetail {
	
	private int doctorId;
	private int employeeId;
	private String specialist;
	
	public DoctorDetail(int doctorId, int employeeId, String specialist) {
		super();
		this.doctorId = doctorId;
		this.employeeId = employeeId;
		this.specialist = specialist;
	}

	public DoctorDetail() {
		super();
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	
}
