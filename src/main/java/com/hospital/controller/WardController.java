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
import com.hospital.model.Ward;
import com.hospital.service.BranchService;
import com.hospital.service.WardService;


public class WardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("add")){
			
			this.loadAddBranchView(request,response);
		}
		if(action != null && action.equals("all")) {
			getAllWard(request, response);
		}else {
			searchTheWard(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deleteWard(request, response);
		}
		else if(action.equals("add")) {
			addWard(request, response);
		}
		else if(action.equals("update")) {
			updateWard(request, response);
		}
		
	}
	
	private void getAllWard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WardService wardservice = new WardService();
		List<Ward> wardList = new ArrayList<Ward>();
		String message = "";
		try {
			wardList = wardservice.getAllWard();
			if(wardList.isEmpty()) {
				message = "sorry we don't have any ward details.";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("wardList", wardList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("ward-all.jsp");
		rd.forward(request, response);
	}
	
	private void deleteWard(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		WardService wardService = new WardService();
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		String message = "";
		
		try {
			boolean result =  wardService.deleteWard(wardId);
			
			if(result) {
				message = "The Ward Id : " + wardId + " has been successfully deleted!";
			}else {
				message = "Failed to delete the Ward. Ward Id : " + wardId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("Ward?action=all");
	}
	
	private void addWard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		WardService wardService = new WardService();
		Ward ward = new Ward();
		
		ward.setWardType(request.getParameter("wardType"));
		ward.setBranchId(Integer.parseInt(request.getParameter("branchId")));

		
		String message = "";
		
		try {
			boolean result = wardService.addWard(ward);
			if(result) {
				message = "Successfully added the ward : " + ward.getWardType();
			} 
			else {
				message = "Failed to add the ward: " + ward.getWardType();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("ward-add.jsp");
		rd.forward(request, response);
	}
	
	private void searchTheWard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WardService wardService = new WardService();
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		
		Ward ward = new Ward();
		String message = "";
		
		try {
			ward = wardService.getSpecificward(wardId);
			
			if(ward == null) {
				message = "The requested ward is not found! ward ID = " + wardId;
				ward = new Ward();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("ward", ward);
		request.setAttribute("searchFeedBack", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("ward-manage.jsp");
		rd.forward(request, response);
	}
	
	private void updateWard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WardService wardService = new WardService();
		
		Ward ward = new Ward();
		
		ward.setWardId(Integer.parseInt(request.getParameter("wardId")));
		ward.setWardType(request.getParameter("wardType"));
		ward.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		
		String message = "";
		
		try {
			boolean result =  wardService.updateWard(ward);
			if(result) {
				message = "Ward has been successfully updated! ward ID: " + ward.getWardId();
			}
			else {
				message = "Failed to update the ward! ward ID: " + ward.getWardId();
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("ward-manage.jsp");
		rd.forward(request, response);

	}
	
	public void loadAddBranchView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BranchService branchService = new BranchService();
		List<Branch> branchList = null;
		try {
			branchList = branchService.getAllBranch();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("branchList", branchList);
		request.setAttribute("message", "");
		
		RequestDispatcher rd = request.getRequestDispatcher("ward-add.jsp");
		rd.forward(request, response);
	}
}
