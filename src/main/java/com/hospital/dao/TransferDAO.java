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
import com.hospital.model.Transfer;

public class TransferDAO {
	
	public static boolean addTransfer(Transfer transfer) throws ClassNotFoundException, SQLException {
		
		//02. load the driver and register 03. creating the connection
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		//04. prepare/create the statement
		String query = "INSERT INTO transfer(patientName,branchId,transferDate) VALUES (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, transfer.getPatientName());
		ps.setInt(2, transfer.getBranchId());
		ps.setString(3, transfer.getTransferDate());
		
		//05. execute the statement
		//06. process the response form the db end
		boolean result = ps.executeUpdate() > 0;
				
		//07. close the connection 
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static Transfer getSpecificTransfer(int transferId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM transfer WHERE transferId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, transferId);
		
		ResultSet rs = ps.executeQuery();
		Transfer transfer = new Transfer();
		if(rs.next()) {
			transfer.setTransferId(rs.getInt("transferId"));
			transfer.setPatientName(rs.getString("patientName"));
			transfer.setBranchId(rs.getInt("branchId"));
			transfer.setTransferDate(rs.getString("transferDate"));
		}		
		ps.close();
		connection.close();
		return transfer;
		
	}
	
	public static List<Transfer> getAllTransfer()throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM transfer";
		
		ResultSet rs =st.executeQuery(query);
		List<Transfer> transfers = new ArrayList<Transfer>();
		
		while(rs.next()) {
			Transfer transfer = new Transfer();

			transfer.setTransferId(rs.getInt("transferId"));
			transfer.setPatientName(rs.getString("patientName"));
			transfer.setBranchId(rs.getInt("branchId"));
			transfer.setTransferDate(rs.getString("transferDate"));	
			
			transfers.add(transfer);
		}
		st.close();
		connection.close();
		return transfers;
	}
	
	public static boolean updateTransfer(Transfer transfer) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE transfer SET patientName=?,branchId=?,transferDate=? WHERE transferId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, transfer.getPatientName());
		ps.setInt(2, transfer.getBranchId());
		ps.setString(3, transfer.getTransferDate());
		ps.setInt(4, transfer.getTransferId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteTransfer(int transferId)throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM transfer WHERE transferId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, transferId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
