package com.hospital.service;

import java.sql.SQLException;
import java.util.List;
import com.hospital.dao.WardDAO;
import com.hospital.model.Ward;

public class WardService {
	
	public boolean addWard (Ward ward) throws ClassNotFoundException, SQLException {
		return WardDAO.addWard(ward);
	}
	
	public Ward getSpecificward (int wardId) throws ClassNotFoundException, SQLException {
		return WardDAO.getSpecificWard(wardId);
	}
	
	public List<Ward> getAllWard() throws ClassNotFoundException, SQLException{
		List<Ward> wards = WardDAO.getAllWard();
		
		for(Ward ward : wards) {
			System.out.println(ward.getWardId());
		}
		
		return WardDAO.getAllWard();
	}
	
	public boolean updateWard(Ward ward) throws ClassNotFoundException, SQLException {
		return WardDAO.updateWard(ward);
	}
	
	public boolean deleteWard(int wardId) throws ClassNotFoundException, SQLException {
		return WardDAO.deleteWard(wardId);
		
	}

}
