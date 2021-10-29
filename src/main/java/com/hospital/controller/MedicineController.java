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

import com.hospital.model.Medicine;
import com.hospital.service.MedicineService;


public class MedicineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action != null && action.equals("all")) {
			getAllMedicine(request, response);
		} else {
			searchTheMedicine(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equals("delete")) {
			deleteMedicine(request, response);
		} else if (action.equals("add")) {
			addMedicine(request, response);
		} else if (action.equals("update")) {
			updateMedicine(request, response);
		}
		
	}
	
	private void addMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MedicineService medicineService = new MedicineService();
		Medicine medicine = new Medicine();

		medicine.setMedicineName(request.getParameter("medicineName"));
		medicine.setMedicineDescription(request.getParameter("medicineDescription"));
		medicine.setManufacturingDate(request.getParameter("manufacturingDate"));
		medicine.setExpiryDate(request.getParameter("expiryDate"));
		medicine.setQty(Integer.parseInt(request.getParameter("qty")));

		String message = "";

		try {
			boolean result = medicineService.addMedicine(medicine);
			if (result) {
				message = "Successfully added the Medicine : " + medicine.getMedicineName();
			} else {
				message = "Failed to add the Medicine: " + medicine.getMedicineName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("medicine-add.jsp");
		rd.forward(request, response);
	}
	
	private void getAllMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MedicineService medicineService = new MedicineService();
		List<Medicine> medicineList = new ArrayList<Medicine>();
		String message = "";
		try {
			medicineList = medicineService.getAllMedicine();
			if (medicineList.isEmpty()) {
				message = "Sorry at the moment we don't have Medicine";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("medicineList", medicineList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("medicine-all.jsp");
		rd.forward(request, response);
	}
	
	private void deleteMedicine(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MedicineService medicineService = new MedicineService();
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		String message = "";

		try {
			boolean result = medicineService.deleteMedicine(medicineId);

			if (result) {
				message = "The medicine Id : " + medicineId + " has been successfully deleted!";
			} else {
				message = "Failed to delete the medicine. medicine Id : " + medicineId;
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);

		response.sendRedirect("Medicine?action=all");
	}
	
	private void searchTheMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MedicineService medicineService = new MedicineService();
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));

		Medicine medicine = new Medicine();
		String message = "";

		try {
			medicine = medicineService.getSpecificMedicine(medicineId);

			if (medicine == null) {
				message = "The requested branch is not found! medicine ID = " + medicineId;
				medicine = new Medicine();
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("medicine", medicine);
		request.setAttribute("searchFeedBack", message);

		RequestDispatcher rd = request.getRequestDispatcher("medicine-manage.jsp");
		rd.forward(request, response);
	}
	
	private void updateMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MedicineService medicineService = new MedicineService();

		Medicine medicine = new Medicine();

		medicine.setMedicineId(Integer.parseInt(request.getParameter("medicineId")));
		medicine.setMedicineName(request.getParameter("medicineName"));
		medicine.setMedicineDescription(request.getParameter("medicineDescription"));
		medicine.setManufacturingDate(request.getParameter("manufacturingDate"));
		medicine.setExpiryDate(request.getParameter("expiryDate"));
		medicine.setQty(Integer.parseInt(request.getParameter("qty")));

		String message = "";

		try {
			boolean result = medicineService.updateTheMedicine(medicine);
			if (result) {
				message = "Medicine has been successfully updated! Medicine Name: " + medicine.getMedicineName();
			} else {
				message = "Failed to update the Medicine! Medicine Name: " + medicine.getMedicineName();
			}
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("medicine-manage.jsp");
		rd.forward(request, response);
	}
}
