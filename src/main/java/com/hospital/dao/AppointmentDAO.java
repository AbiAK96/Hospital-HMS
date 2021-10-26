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
import com.hospital.model.Appointment;

public class AppointmentDAO {
	
	public static boolean addAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO appointment(patientName,contact,doctor,date,time) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, appointment.getPatientName());
		ps.setString(2, appointment.getContact());
		ps.setString(3, appointment.getDoctor());
		ps.setString(4, appointment.getDate());
		ps.setString(5, appointment.getTime());

		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static Appointment getSpecificAppointment(int appointmentId) throws ClassNotFoundException, SQLException {
		 
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM appointment WHERE appointmentId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, appointmentId);
		
		ResultSet rs = ps.executeQuery();
		Appointment appointment = new Appointment();
		if(rs.next()) {
			appointment.setAppointmentId(rs.getInt("appointmentId"));
			appointment.setPatientName(rs.getString("patientName"));
			appointment.setContact(rs.getString("contact"));
			appointment.setDoctor(rs.getString("doctor"));
			appointment.setDate(rs.getString("date"));
			appointment.setTime(rs.getString("time"));
			

		}	
		ps.close();
		connection.close();
		return appointment;
	}
	
	public static List<Appointment> getAllAppointment() throws SQLException, ClassNotFoundException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM appointment";
		
		ResultSet rs =st.executeQuery(query);
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		while(rs.next()) {
			Appointment appointment = new Appointment();
			
			appointment.setAppointmentId(rs.getInt("appointmentId"));
			appointment.setPatientName(rs.getString("patientName"));
			appointment.setContact(rs.getString("contact"));
			appointment.setDoctor(rs.getString("doctor"));
			appointment.setDate(rs.getString("date"));
			appointment.setTime(rs.getString("time"));
			
			appointments.add(appointment);
		}
		st.close();
		connection.close();
		return appointments;	
	}
	
	public static boolean updateAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE appointment SET patientName=?,contact=?,doctor=?,date=?,time=? WHERE appointmentId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, appointment.getPatientName());
		ps.setString(2, appointment.getContact());
		ps.setString(3, appointment.getDoctor());
		ps.setString(4, appointment.getDate());
		ps.setString(5, appointment.getTime());
		ps.setInt(6, appointment.getAppointmentId());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteAppointment(int appointmentId) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM appointment WHERE appointmentId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, appointmentId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;	
	}

}
