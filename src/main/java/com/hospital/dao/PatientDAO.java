package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.database.DbConnector;
import com.hospital.database.MySqlDbConnectorImpl;
import com.hospital.model.Patient;

public class PatientDAO {
	
	public static boolean addPatient(Patient patient) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO patient(patientName,patientNIC,patientAge,patientGender,patientAddress,patientTel,patientStatus,admitDate,dischargeDate,branchId,doctorId,wardId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, patient.getPatientName());
		ps.setString(2, patient.getPatientNIC());
		ps.setString(3, patient.getPatientAge());
		ps.setString(4, patient.getPatientGender());
		ps.setString(5, patient.getPatientAddress());
		ps.setString(6, patient.getPatientTel());
		ps.setString(7, patient.getPatientStatus());
		ps.setString(8, patient.getAdmitDate());
		ps.setString(9, patient.getDischargeDate());
		ps.setInt(10, patient.getBranchId());
		ps.setInt(11, patient.getDoctorId());
		ps.setInt(12, patient.getWardId());
			
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();		
		return result;
	}
	
	public static boolean deletePatient(int patientId) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM patient WHERE patientId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, patientId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

	public static Patient getSpecificPatient(int patientId) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM patient WHERE patientId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, patientId);
		
		ResultSet rs = ps.executeQuery();
		Patient patient = new Patient();
		if(rs.next()) {
			patient.setPatientId(rs.getInt("patientId"));
			patient.setPatientName(rs.getString("patientName"));
			patient.setPatientNIC(rs.getString("patientNIC"));
			patient.setPatientAge(rs.getString("patientAge"));
			patient.setPatientGender(rs.getString("patientGender"));
			patient.setPatientAddress(rs.getString("patientAddress"));
			patient.setPatientTel(rs.getString("patientTel"));
			patient.setPatientStatus(rs.getString("patientStatus"));
			patient.setAdmitDate(rs.getString("admitDate"));
			patient.setDischargeDate(rs.getString("dischargeDate"));
			patient.setBranchId(rs.getInt("branchId"));
			patient.setDoctorId(rs.getInt("doctorId"));
			patient.setWardId(rs.getInt("wardId"));
		}		
		ps.close();
		connection.close();
		return patient;
	}

	public static List<Patient> getAllPatient() throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM patient";
		
		ResultSet rs =st.executeQuery(query);
		List<Patient> patients = new ArrayList<Patient>();
		
		while(rs.next()) {
			Patient patient = new Patient();

			patient.setPatientId(rs.getInt("patientId"));
			patient.setPatientName(rs.getString("patientName"));
			patient.setPatientNIC(rs.getString("patientNIC"));
			patient.setPatientAge(rs.getString("patientAge"));
			patient.setPatientGender(rs.getString("patientGender"));
			patient.setPatientAddress(rs.getString("patientAddress"));
			patient.setPatientTel(rs.getString("patientTel"));
			patient.setPatientStatus(rs.getString("patientStatus"));
			patient.setAdmitDate(rs.getString("admitDate"));
			patient.setDischargeDate(rs.getString("dischargeDate"));
			patient.setBranchId(rs.getInt("branchId"));
			patient.setDoctorId(rs.getInt("doctorId"));
			patient.setWardId(rs.getInt("wardId"));
			
			patients.add(patient);
		}
		st.close();
		connection.close();
		return patients;
	}

	public static boolean updatePatient(Patient patient) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE patient SET patientName=?,patientNIC=?,patientAge=?,patientGender=?,patientAddress=?,patientTel=?,patientStatus=?,admitDate=?,dischargeDate=?,branchId=?,doctorId=?,wardId=? WHERE patientId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, patient.getPatientName());
		ps.setString(2, patient.getPatientNIC());
		ps.setString(3, patient.getPatientAge());
		ps.setString(4, patient.getPatientGender());
		ps.setString(5, patient.getPatientAddress());
		ps.setString(6, patient.getPatientTel());
		ps.setString(7, patient.getPatientStatus());
		ps.setString(8, patient.getAdmitDate());
		ps.setString(9, patient.getDischargeDate());
		ps.setInt(10, patient.getBranchId());
		ps.setInt(11, patient.getDoctorId());
		ps.setInt(12, patient.getWardId());
		ps.setInt(13, patient.getPatientId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
