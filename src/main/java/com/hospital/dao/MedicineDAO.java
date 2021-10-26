package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hospital.database.DbConnector;
import com.hospital.database.MySqlDbConnectorImpl;
import com.hospital.model.Medicine;

public class MedicineDAO {
	
	public static boolean addMedicine(Medicine medicine) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO store(medicineName,medicineDescription,manufacturingDate,expiryDate,qty) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, medicine.getMedicineName());
		ps.setString(2, medicine.getMedicineDescription());
		ps.setString(3, medicine.getManufacturingDate());
		ps.setString(4, medicine.getExpiryDate());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static Medicine getSpecificMedicine(int medicineId) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM store WHERE medicineId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, medicineId);
		
		ResultSet rs = ps.executeQuery();
		Medicine medicine = new Medicine();
		if(rs.next()) {
			medicine.setMedicineId(rs.getInt("medicineId"));
			medicine.setMedicineName(rs.getString("medicineName"));
			medicine.setMedicineDescription(rs.getString("medicineDescription"));
			medicine.setManufacturingDate(rs.getString("manufacturingDate"));
			medicine.setExpiryDate(rs.getString("expiryDate"));
			medicine.setQty(rs.getInt("qty"));	
		}		
		ps.close();
		connection.close();
		return medicine;
		
	}
	public static List<Medicine> getAllMedicine(){
		return null;
		
	}
	public static boolean updateMedicine(Medicine medicine) {
		return false;
		
	}
	public static boolean deleteMedicine(int medicineId) {
		return false;
		
	}

}
