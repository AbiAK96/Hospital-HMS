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
import com.hospital.model.Branch;

public class BranchDAO {
	
	public static boolean addBranch(Branch branch) throws ClassNotFoundException, SQLException {
		
		//02. load the driver and register 03. creating the connection
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		//04. prepare/create the statement
		String query = "INSERT INTO branch(branchName,branchAddress,branchEmail,branchTel) VALUES (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, branch.getBranchName());
		ps.setString(2, branch.getBranchAddress());
		ps.setString(3, branch.getBranchEmail());
		ps.setString(4, branch.getBranchTel());
		
		//05. execute the statement
		//06. process the response form the db end
		boolean result = ps.executeUpdate() > 0;
				
		//07. close the connection 
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static Branch getSpecificBranch(int branchId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM branch WHERE branchId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, branchId);
		
		ResultSet rs = ps.executeQuery();
		Branch branch = new Branch();
		if(rs.next()) {
			branch.setBranchId(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			branch.setBranchEmail(rs.getString("branchEmail"));
			branch.setBranchTel(rs.getString("branchTel"));	
		}		
		ps.close();
		connection.close();
		return branch;
		
	}
	
	public static List<Branch> getAllBranch()throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM branch";
		
		ResultSet rs =st.executeQuery(query);
		List<Branch> branches = new ArrayList<Branch>();
		
		while(rs.next()) {
			Branch branch = new Branch();

			branch.setBranchId(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			branch.setBranchEmail(rs.getString("branchEmail"));
			branch.setBranchTel(rs.getString("branchTel"));	
			
			branches.add(branch);
		}
		st.close();
		connection.close();
		return branches;
	}
	
	public static boolean updateBranch(Branch branch) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE branch SET branchName=?,branchAddress=?,branchEmail=?,branchTel=? WHERE branchId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, branch.getBranchName());
		ps.setString(2, branch.getBranchAddress());
		ps.setString(3, branch.getBranchEmail());
		ps.setString(4, branch.getBranchTel());
		ps.setInt(5, branch.getBranchId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteBranch(int branchId)throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM branch WHERE branchId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, branchId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
