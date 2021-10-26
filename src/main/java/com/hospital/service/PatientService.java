package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;


public class PatientService {
	
	public boolean addPatient(Patient patient) throws ClassNotFoundException, SQLException {
		return PatientDAO.addPatient(patient);
	}
	
	public Patient getSpecificPatient(int patientId) throws ClassNotFoundException, SQLException {
		return PatientDAO.getSpecificPatient(patientId);
	}
	
	public List<Patient> getAllPatient() throws ClassNotFoundException, SQLException {
		List<Patient> patients = PatientDAO.getAllPatient();
		
		for(Patient patient : patients) {
			System.out.println(patient.getPatientId());
		}
		
		return PatientDAO.getAllPatient();
	}
	
	public boolean updatePatient(Patient patient) throws ClassNotFoundException, SQLException {
		return PatientDAO.updatePatient(patient);
	}
	
	public boolean deletePatient(int patientId) throws ClassNotFoundException, SQLException {
		return PatientDAO.deletePatient(patientId);
	}

}
