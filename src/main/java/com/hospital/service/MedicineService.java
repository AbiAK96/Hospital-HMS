package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.MedicineDAO;
import com.hospital.model.Medicine;

public class MedicineService {
	
	public boolean addMedicine(Medicine medicine) throws ClassNotFoundException, SQLException {
		return MedicineDAO.addMedicine(medicine);
	}
	
	public Medicine getSpecificMedicine(int medicineId) throws ClassNotFoundException, SQLException {
		return MedicineDAO.getSpecificMedicine(medicineId);
	}
	
	public List<Medicine> getAllMedicine() throws ClassNotFoundException, SQLException {
		return MedicineDAO.getAllMedicine();
	}
	
	public boolean updateTheMedicine(Medicine medicine) throws ClassNotFoundException, SQLException {
		return MedicineDAO.updateMedicine(medicine);
	}
	
	public boolean deleteMedicine(int medicineId) throws ClassNotFoundException, SQLException {
		return MedicineDAO.deleteMedicine(medicineId);
	}

}
