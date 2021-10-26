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

import com.hospital.model.DoctorDetail;
import com.hospital.model.Employee;
import com.hospital.service.DoctorDetailService;
import com.hospital.service.EmployeeService;

public class DoctorDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null && action.equals("add")) {
			this.loadAddDoctorView(request, response);
		}
		if (action != null && action.equals("all")) {
			getAllDoctorDetail(request, response);
		} else {
			searchTheDoctorDetail(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("delete")) {
			deleteDoctorDetail(request, response);
		} else if (action.equals("add")) {
			addDoctorDetail(request, response);
		} else if (action.equals("update")) {
			updateDoctorDetail(request, response);
		}

	}

	private void getAllDoctorDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDetailService doctorDetailService = new DoctorDetailService();
		List<DoctorDetail> doctorDetailList = new ArrayList<DoctorDetail>();

		String message = "";

		try {

			doctorDetailList = doctorDetailService.getAllDoctorDetail();
			if (doctorDetailList.isEmpty()) {
				message = "Sorry at the moment we don't have Branch";
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}

		request.setAttribute("doctorDetailList", doctorDetailList);
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("doctor-all.jsp");
		rd.forward(request, response);
	}

	private void deleteDoctorDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DoctorDetailService doctorDetailService = new DoctorDetailService();
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		String message = "";

		try {
			boolean result = doctorDetailService.deleteDoctorDetail(doctorId);

			if (result) {
				message = "The Doctor Id : " + doctorId + " has been successfully deleted!";
			} else {
				message = "Failed to delete the Doctor. Doctor Id : " + doctorId;
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);

		response.sendRedirect("DoctorDetail?action=all");
	}

	private void addDoctorDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDetailService doctorDetailService = new DoctorDetailService();
		DoctorDetail doctorDetail = new DoctorDetail();

		doctorDetail.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		doctorDetail.setSpecialist(request.getParameter("specialist"));

		String message = "";

		try {
			boolean result = doctorDetailService.addDoctorDetail(doctorDetail);
			if (result) {
				message = "Successfully added the doctor : " + doctorDetail.getSpecialist();
			} else {
				message = "Failed to add the doctor: " + doctorDetail.getSpecialist();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("doctor-add.jsp");
		rd.forward(request, response);
	}

	private void searchTheDoctorDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDetailService doctorDetailService = new DoctorDetailService();
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));

		DoctorDetail doctorDetail = new DoctorDetail();
		String message = "";

		try {
			doctorDetail = doctorDetailService.getSpecificDoctorDetail(doctorId);

			if (doctorDetail == null) {
				message = "The requested branch is not found! Doctor ID = " + doctorId;
				doctorDetail = new DoctorDetail();
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("doctorDetail", doctorDetail);
		request.setAttribute("searchFeedBack", message);

		RequestDispatcher rd = request.getRequestDispatcher("doctor-manage.jsp");
		rd.forward(request, response);
	}

	private void updateDoctorDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDetailService doctorDetailService = new DoctorDetailService();

		DoctorDetail doctorDetail = new DoctorDetail();
		doctorDetail.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		doctorDetail.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		doctorDetail.setSpecialist(request.getParameter("specialist"));

		String message = "";

		try {
			boolean result = doctorDetailService.updateTheDoctorDetail(doctorDetail);
			if (result) {
				message = "Doctor has been successfully updated! Doctor ID: " + doctorDetail.getDoctorId();
			} else {
				message = "Failed to update the doctor! Doctor ID: " + doctorDetail.getDoctorId();
			}
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("doctor-manage.jsp");
		rd.forward(request, response);
	}

	public void loadAddDoctorView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = null;
		try {
			employeeList = employeeService.getAllEmployee();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("employeeList", employeeList);
		request.setAttribute("message", "");

		RequestDispatcher rd = request.getRequestDispatcher("doctor-add.jsp");
		rd.forward(request, response);
	}

}
