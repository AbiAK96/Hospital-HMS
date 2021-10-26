package com.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.model.Appointment;
import com.hospital.model.DoctorDetail;
import com.hospital.service.AppointmentService;
import com.hospital.service.DoctorDetailService;

public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null && action.equals("add")) {
			this.loadAddAppointmentView(request, response);
		}
		if (action != null && action.equals("all")) {
			getAllAppointment(request, response);
		} else {
			searchTheAppointment(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("delete")) {
			deleteAppointment(request, response);
		} else if (action.equals("add")) {
			addAppointment(request, response);
		} else if (action.equals("update")) {
			updateAppointment(request, response);
		}

	}

	private void getAllAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AppointmentService appointmentservice = new AppointmentService();
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		String message = "";
		try {
			appointmentList = appointmentservice.getAllAppointment();
			if (appointmentList.isEmpty()) {
				message = "sorry we don't have any appointment details.";
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("appointmentList", appointmentList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("appointment-all.jsp");
		rd.forward(request, response);
	}

	private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {

		AppointmentService appointmentservice = new AppointmentService();
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		String message = "";

		try {
			boolean result = appointmentservice.deleteAppointment(appointmentId);

			if (result) {
				message = "The Appointment Id : " + appointmentId + " has been successfully deleted!";
			} else {
				message = "Failed to delete the Appointment. Appointment Id : " + appointmentId;
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);

		response.sendRedirect("Appointment?action=all");
	}

	private void addAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AppointmentService appointmentService = new AppointmentService();
		Appointment appointment = new Appointment();

		appointment.setPatientName(request.getParameter("patientName"));
		appointment.setContact(request.getParameter("contact"));
		appointment.setDoctor(request.getParameter("doctor"));
		appointment.setDate(request.getParameter("date"));
		appointment.setTime(request.getParameter("time"));

		String message = "";

		try {
			boolean result = appointmentService.addAppointment(appointment);
			if (result) {
				message = "Successfully added the Appointment : " + appointment.getPatientName();
			} else {
				message = "Failed to add the Appointment: " + appointment.getPatientName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("appointment-add.jsp");
		rd.forward(request, response);
	}

	private void searchTheAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AppointmentService appointmentService = new AppointmentService();
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

		Appointment appointment = new Appointment();
		String message = "";

		try {
			appointment = appointmentService.getSpecificAppointment(appointmentId);

			if (appointment == null) {
				message = "The requested appointment is not found! appointment ID = " + appointmentId;
				appointment = new Appointment();
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("appointment", appointment);
		request.setAttribute("searchFeedBack", message);

		RequestDispatcher rd = request.getRequestDispatcher("appointment-manage.jsp");
		rd.forward(request, response);
	}

	private void updateAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AppointmentService appointmentService = new AppointmentService();

		Appointment appointment = new Appointment();

		appointment.setAppointmentId(Integer.parseInt(request.getParameter("appointmentId")));
		appointment.setPatientName(request.getParameter("patientName"));
		appointment.setContact(request.getParameter("contact"));
		appointment.setDoctor(request.getParameter("doctor"));
		appointment.setDate(request.getParameter("date"));
		appointment.setTime(request.getParameter("time"));

		String message = "";

		try {
			boolean result = appointmentService.updateAppointment(appointment);
			if (result) {
				message = "appointment has been successfully updated! appointment ID: "
						+ appointment.getAppointmentId();
			} else {
				message = "Failed to update the appointment! appointment ID: " + appointment.getAppointmentId();
			}
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("appointment-manage.jsp");
		rd.forward(request, response);

	}

	public void loadAddAppointmentView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorDetailService doctorDetailService = new DoctorDetailService();
		List<DoctorDetail> doctorDetailList = null;
		try {
			doctorDetailList = doctorDetailService.getAllDoctorDetail();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("doctorDetailList", doctorDetailList);
		request.setAttribute("message", "");

		RequestDispatcher rd = request.getRequestDispatcher("appointment-add.jsp");
		rd.forward(request, response);
	}

}
