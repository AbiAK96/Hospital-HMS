package com.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Medicine;
import com.hospital.service.MedicineService;

public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equals("delete")) {
			//deleteBranch(request, response);
		} else if (action.equals("add")) {
			addMedicine(request, response);
		} else if (action.equals("update")) {
			//updateBranch(request, response);
		}
		
	}
	
	private void addMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MedicineService medicineService = new MedicineService();
		Medicine medicine = new Medicine();

		medicine.setMedicineName(request.getParameter("medicineName"));
		medicine.setMedicineDescription(request.getParameter("medicineDescription"));
		medicine.setManufacturingDate(request.getParameter("manufacturingDate"));
		medicine.setExpiryDate(request.getParameter("expiryDate"));

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

}
