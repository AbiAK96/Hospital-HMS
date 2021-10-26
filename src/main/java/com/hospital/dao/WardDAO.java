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
import com.hospital.model.Ward;


public class WardDAO {
	
	public static boolean addWard(Ward ward) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO ward(wardType,branchId) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, ward.getWardType());
		ps.setInt(2, ward.getBranchId());

		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static Ward  getSpecificWard(int wardId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM ward WHERE wardId = ? ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, wardId);
		
		ResultSet rs = ps.executeQuery();
		Ward ward = new Ward();
		
		if(rs.next()) {
			ward.setWardId(rs.getInt("wardId"));
			ward.setWardType(rs.getString("wardType"));
			ward.setBranchId(rs.getInt("branchId"));
		}
		ps.close();
		connection.close();	
		return ward;
	}
	
	public static List<Ward> getAllWard() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM ward";
		
		ResultSet rs = st.executeQuery(query);
		List<Ward> wards = new ArrayList<Ward>();
		
		while(rs.next()) {
			Ward ward = new Ward();
			
			ward.setWardId(rs.getInt("wardId"));
			ward.setWardType(rs.getString("wardType"));
			ward.setBranchId(rs.getInt("branchId"));
			
			wards.add(ward);
		}
		st.close();
		connection.close();
		return wards;		
	}
		
	public static boolean updateWard(Ward ward) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		 
		String query = "UPDATE ward SET wardType = ?, branchId = ? WHERE wardId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, ward.getWardType());
		ps.setInt(2, ward.getBranchId());
		ps.setInt(3, ward.getWardId());
	
		Boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean deleteWard(int wardId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM ward WHERE wardId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, wardId);
		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}

}
