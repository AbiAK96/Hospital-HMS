package com.hospital.model;

public class Appointment {
	
	private int appointmentId;
	private String patientName;
	private String contact;
	private String doctor;
	private String date;
	private String time;
	
	public Appointment(int appointmentId, String patientName, String contact, String doctor, String date, String time) {
		
		this.appointmentId = appointmentId;
		this.patientName = patientName;
		this.contact = contact;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
	}

	public Appointment() {
		
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
