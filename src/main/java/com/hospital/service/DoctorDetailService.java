package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.DoctorDetailDAO;
import com.hospital.model.DoctorDetail;


public class DoctorDetailService {
	
	public boolean addDoctorDetail(DoctorDetail doctorDetail) throws ClassNotFoundException, SQLException {
		return DoctorDetailDAO.addDoctorDetail(doctorDetail);
	}
	
	public DoctorDetail getSpecificDoctorDetail(int doctorId) throws ClassNotFoundException, SQLException {
		return DoctorDetailDAO.getSpecificDoctorDetail(doctorId);
	}
	
	public List<DoctorDetail> getAllDoctorDetail() throws ClassNotFoundException, SQLException {
		List<DoctorDetail> doctorDetails = DoctorDetailDAO.getAllDoctorDetail();
		
		for(DoctorDetail doctorDetail : doctorDetails) {
			System.out.println(doctorDetail.getDoctorId());
		}
		
		return DoctorDetailDAO.getAllDoctorDetail();
	}
	
	public boolean updateTheDoctorDetail(DoctorDetail doctorDetail) throws ClassNotFoundException, SQLException {
		return DoctorDetailDAO.updateDoctorDetail(doctorDetail);
	}
	
	public boolean deleteDoctorDetail(int doctorId) throws ClassNotFoundException, SQLException {
		return DoctorDetailDAO.deleteDoctorDetail(doctorId);
	}


}
