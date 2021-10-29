package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.SmsClient;
import com.hospital.model.Appointment;


public class AppointmentService {
	
	public boolean addAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		SmsClient.getInstance().SendSms(appointment.getContact(), "Your appointment with ABC Hospital is confimed!");
		return AppointmentDAO.addAppointment(appointment);
	}
	
	public Appointment getSpecificAppointment(int appointmentId) throws ClassNotFoundException, SQLException {
		return AppointmentDAO.getSpecificAppointment(appointmentId);
	}
	
	public List<Appointment> getAllAppointment() throws ClassNotFoundException, SQLException {
		return AppointmentDAO.getAllAppointment();
	}
	
	public boolean updateAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		return AppointmentDAO.updateAppointment(appointment);
	}
	
	public boolean deleteAppointment(int appointmentId) throws ClassNotFoundException, SQLException {
		return AppointmentDAO.deleteAppointment(appointmentId);
	}

}
