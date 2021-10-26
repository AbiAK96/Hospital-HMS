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
import com.hospital.service.BranchService;

public class BranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null && action.equals("all")) {
			getAllBranch(request, response);
		} else {
			searchTheBranch(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("delete")) {
			deleteBranch(request, response);
		} else if (action.equals("add")) {
			addBranch(request, response);
		} else if (action.equals("update")) {
			updateBranch(request, response);
		}

	}

	private void getAllBranch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BranchService service = new BranchService();
		List<Branch> branchList = new ArrayList<Branch>();
		String message = "";
		try {
			branchList = service.getAllBranch();
			if (branchList.isEmpty()) {
				message = "Sorry at the moment we don't have Branch";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("branchList", branchList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("branch-all.jsp");
		rd.forward(request, response);
	}

	private void deleteBranch(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BranchService branchService = new BranchService();
		int BranchId = Integer.parseInt(request.getParameter("branchId"));
		String message = "";

		try {
			boolean result = branchService.deleteBranch(BranchId);

			if (result) {
				message = "The Branch Id : " + BranchId + " has been successfully deleted!";
			} else {
				message = "Failed to delete the Branch. Branch Id : " + BranchId;
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);

		response.sendRedirect("Branch?action=all");
	}

	private void addBranch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BranchService branchService = new BranchService();
		Branch branch = new Branch();

		branch.setBranchName(request.getParameter("branchName"));
		branch.setBranchAddress(request.getParameter("branchAddress"));
		branch.setBranchEmail(request.getParameter("branchEmail"));
		branch.setBranchTel(request.getParameter("branchTel"));

		String message = "";

		try {
			boolean result = branchService.addBranch(branch);
			if (result) {
				message = "Successfully added the Branch : " + branch.getBranchName();
			} else {
				message = "Failed to add the Branch: " + branch.getBranchName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("branch-add.jsp");
		rd.forward(request, response);
	}

	private void searchTheBranch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BranchService branchService = new BranchService();
		int branchId = Integer.parseInt(request.getParameter("branchId"));

		Branch branch = new Branch();
		String message = "";

		try {
			branch = branchService.getSpecificBranch(branchId);

			if (branch == null) {
				message = "The requested branch is not found! Branch ID = " + branchId;
				branch = new Branch();
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("branch", branch);
		request.setAttribute("searchFeedBack", message);

		RequestDispatcher rd = request.getRequestDispatcher("branch-manage.jsp");
		rd.forward(request, response);
	}

	private void updateBranch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BranchService branchService = new BranchService();

		Branch branch = new Branch();

		branch.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		branch.setBranchName(request.getParameter("branchName"));
		branch.setBranchAddress(request.getParameter("branchAddress"));
		branch.setBranchEmail(request.getParameter("branchEmail"));
		branch.setBranchTel(request.getParameter("branchTel"));

		String message = "";

		try {
			boolean result = branchService.updateTheBranch(branch);
			if (result) {
				message = "Branch has been successfully updated! Branch ID: " + branch.getBranchId();
			} else {
				message = "Failed to update the branch! Branch ID: " + branch.getBranchId();
			}
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("branch-manage.jsp");
		rd.forward(request, response);
	}

}
