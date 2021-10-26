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

import com.hospital.model.Branch;
import com.hospital.model.DoctorDetail;
import com.hospital.model.Patient;
import com.hospital.model.Ward;
import com.hospital.service.BranchService;
import com.hospital.service.DoctorDetailService;
import com.hospital.service.PatientService;
import com.hospital.service.WardService;


public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("add")){
			this.loadAddPatientView(request,response);
		}
		if(action != null && action.equals("all")) {
			getAllPatient(request, response);
		}else {
			searchThePatient(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deletePatient(request, response);
		}
		else if(action.equals("add")) {
			addPatient(request, response);
		}
		else if(action.equals("update")) {
			updatePatient(request, response);
		}
		
	}
	
	private void addPatient(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		PatientService patientService = new PatientService();
		Patient patient = new Patient();
		
		patient.setPatientName(request.getParameter("patientName"));
		patient.setPatientNIC(request.getParameter("patientNIC"));
		patient.setPatientAge(request.getParameter("patientAge"));
		patient.setPatientGender(request.getParameter("patientGender"));
		patient.setPatientAddress(request.getParameter("patientAddress"));
		patient.setPatientTel(request.getParameter("patientTel"));
		patient.setPatientStatus(request.getParameter("patientStatus"));
		patient.setAdmitDate(request.getParameter("admitDate"));
		patient.setDischargeDate(request.getParameter("dischargeDate"));
		patient.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		patient.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		patient.setWardId(Integer.parseInt(request.getParameter("wardId")));
		
		String message = "";
		
		try {
			boolean result = patientService.addPatient(patient);
			if(result) {
				message = "Successfully added the patient : " + patient.getPatientName();
			} 
			else {
				message = "Failed to add the patient: " + patient.getPatientName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("patient-add.jsp");
		rd.forward(request, response);
	}
	
	private void searchThePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientService patientService = new PatientService();
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		
		Patient patient = new Patient();
		String message = "";
		
		try {
			patient = patientService.getSpecificPatient(patientId);
			
			if(patient == null) {
				message = "The requested patient is not found! patient ID = " + patientId;
				patient = new Patient();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("patient", patient);
		request.setAttribute("searchFeedBack", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("patient-manage.jsp");
		rd.forward(request, response);
	}
	
	private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientService patientService = new PatientService();
		
		Patient patient = new Patient();
		
		patient.setPatientId(Integer.parseInt(request.getParameter("patientId")));
		patient.setPatientName(request.getParameter("patientName"));
		patient.setPatientNIC(request.getParameter("patientNIC"));
		patient.setPatientAge(request.getParameter("patientAge"));
		patient.setPatientGender(request.getParameter("patientGender"));
		patient.setPatientAddress(request.getParameter("patientAddress"));
		patient.setPatientTel(request.getParameter("patientTel"));
		patient.setPatientStatus(request.getParameter("patientStatus"));
		patient.setAdmitDate(request.getParameter("admitDate"));
		patient.setDischargeDate(request.getParameter("dischargeDate"));
		patient.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		patient.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		patient.setWardId(Integer.parseInt(request.getParameter("wardId")));
		
		
		String message = "";
		
		try {
			boolean result =  patientService.updatePatient(patient);
			if(result) {
				message = "Patient has been successfully updated! Patient ID: " + patient.getPatientName();
			}
			else {
				message = "Failed to update the Patient! Patient ID: " + patient.getPatientName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("patient-manage.jsp");
		rd.forward(request, response);
	}
	
	private void getAllPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientService patientService = new PatientService();
		List<Patient> patientList = new ArrayList<Patient>();
		String message = "";
		try {
			patientList = patientService.getAllPatient();
			if(patientList.isEmpty()) {
				message = "sorry we don't have any Patient details.";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("patientList", patientList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("patient-all.jsp");
		rd.forward(request, response);
	}
	
	private void deletePatient(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PatientService patientservice = new PatientService();
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		String message = "";
		
		try {
			boolean result =  patientservice.deletePatient(patientId);
			
			if(result) {
				message = "The Patient Id : " + patientId + " has been successfully deleted!";
			}else {
				message = "Failed to delete the Patient. Patient Id : " + patientId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("Patient?action=all");
	}
	
	public void loadAddPatientView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BranchService branchService = new BranchService();
		DoctorDetailService doctorDetailService = new DoctorDetailService();
		WardService wardservice = new WardService();
		
		List<Branch> branchList = null;
		List<DoctorDetail> doctorDetailList = null;
		List<Ward> wardList = null;
		
		try {
			branchList = branchService.getAllBranch();
			doctorDetailList = doctorDetailService.getAllDoctorDetail();
			wardList = wardservice.getAllWard();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("branchList", branchList);
		request.setAttribute("doctorDetailList", doctorDetailList);
		request.setAttribute("wardList", wardList);
		request.setAttribute("message", "");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("patient-add.jsp");
		rd.forward(request, response);
		
	}

}
