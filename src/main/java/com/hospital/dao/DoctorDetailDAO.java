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
import com.hospital.model.DoctorDetail;

public class DoctorDetailDAO {
	
public static boolean addDoctorDetail(DoctorDetail doctorDetail) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO doctor(employeeId,specialist) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, doctorDetail.getEmployeeId());
		ps.setString(2, doctorDetail.getSpecialist());

		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static DoctorDetail getSpecificDoctorDetail(int doctorId) throws ClassNotFoundException, SQLException {
		 
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM doctor WHERE doctorId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, doctorId);
		
		ResultSet rs = ps.executeQuery();
		DoctorDetail doctorDetail = new DoctorDetail();
		if(rs.next()) {
			doctorDetail.setDoctorId(rs.getInt("doctorId"));
			doctorDetail.setEmployeeId(rs.getInt("employeeId"));
			doctorDetail.setSpecialist(rs.getString("specialist"));

		}	
		ps.close();
		connection.close();
		return doctorDetail;
	}
	
	public static List<DoctorDetail> getAllDoctorDetail() throws SQLException, ClassNotFoundException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM doctor";
		
		ResultSet rs =st.executeQuery(query);
		List<DoctorDetail> doctorDetails = new ArrayList<DoctorDetail>();
		
		while(rs.next()) {
			DoctorDetail doctorDetail = new DoctorDetail();
			
			doctorDetail.setDoctorId(rs.getInt("doctorId"));
			doctorDetail.setEmployeeId(rs.getInt("employeeId"));
			doctorDetail.setSpecialist(rs.getString("specialist"));			
			doctorDetails.add(doctorDetail);
		}
		st.close();
		connection.close();
		return doctorDetails;	
	}
	
	public static boolean updateDoctorDetail(DoctorDetail doctorDetail) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE doctor SET employeeId=?,specialist=? WHERE doctorId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, doctorDetail.getEmployeeId());
		ps.setString(2, doctorDetail.getSpecialist());
		ps.setInt(3, doctorDetail.getDoctorId());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteDoctorDetail(int doctorId) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM doctor WHERE doctorId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, doctorId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;	
	}

}
