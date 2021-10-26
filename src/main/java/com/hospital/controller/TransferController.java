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
import com.hospital.model.Patient;
import com.hospital.model.Transfer;
import com.hospital.service.BranchService;
import com.hospital.service.PatientService;
import com.hospital.service.TransferService;


public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("add")){
			this.loadAddTransferView(request,response);
		}
		if(action != null && action.equals("all")) {
			getAllTransfer(request, response);
		}else {
			searchTheTransfer(request, response);
		}
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deleteTransfer(request, response);
		}
		else if(action.equals("add")) {
			addTransfer(request, response);
		}
		else if(action.equals("update")) {
			updateTransfer(request, response);
		}
		
		
	}
	
	private void getAllTransfer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
			TransferService transferService = new TransferService();
			List<Transfer> transferList = new ArrayList<Transfer>();
			
			String message = "";
			
			try {
				
				transferList = transferService.getAllTransfer();
				if(transferList.isEmpty()) {
					message = "Sorry at the moment we don't have transfer details";
				}
				
			} catch (ClassNotFoundException | SQLException e) {

				message = e.getMessage();
			}
			
			request.setAttribute("transferList", transferList);
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("transfer-all.jsp");
			rd.forward(request, response);
		}

	private void deleteTransfer(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		TransferService transferService = new TransferService();
		int transferId = Integer.parseInt(request.getParameter("transferId"));
		String message = "";
		
		try {
			boolean result =  transferService.deleteTransfer(transferId);
			
			if(result) {
				message = "The transfer Id : " + transferId + " has been successfully deleted!";
			}else {
				message = "Failed to delete the transfer details. transfer Id : " + transferId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("Transfer?action=all");
	}
		
		private void addTransfer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
			TransferService transferService = new TransferService();
			Transfer transfer = new Transfer();
			
			transfer.setPatientName(request.getParameter("patientName"));
			transfer.setBranchId(Integer.parseInt(request.getParameter("branchId")));
			transfer.setTransferDate(request.getParameter("transferDate"));
			
			String message = "";
			
			try {
				boolean result = transferService.addTransfer(transfer);
				if(result) {
					message = "Successfully added the Transfer Details : " + transfer.getPatientName();
				} 
				else {
					message = "Failed to add the Transfer: " + transfer.getPatientName();
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("transfer-add.jsp");
			rd.forward(request, response);
		}
		
		private void searchTheTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			TransferService transferService = new TransferService();
			int transferId = Integer.parseInt(request.getParameter("transferId"));
			
			Transfer transfer = new Transfer();
			String message = "";
			
			try {
				transfer = transferService.getSpecificTransfer(transferId);
				
				if(transfer == null) {
					message = "The requested transfer deatails is not found! transfer ID = " + transferId;
					transfer = new Transfer();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("transfer", transfer);
			request.setAttribute("searchFeedBack", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("transfer-manage.jsp");
			rd.forward(request, response);
		}
		
		private void updateTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			TransferService transferService = new TransferService();
			
			Transfer transfer = new Transfer();
			transfer.setTransferId(Integer.parseInt(request.getParameter("transferId")));
			transfer.setPatientName(request.getParameter("patientName"));
			transfer.setBranchId(Integer.parseInt(request.getParameter("branchId")));
			transfer.setTransferDate(request.getParameter("transferDate"));
			
			String message = "";
			
			try {
				boolean result =  transferService.updateTransfer(transfer);
				if(result) {
					message = "Transfer detail has been successfully updated! Transfer ID: " + transfer.getTransferId();
				}
				else {
					message = "Failed to update the Transfer detail! Transfer ID: " + transfer.getTransferId();
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("updateMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("transfer-manage.jsp");
			rd.forward(request, response);
		}
		
		public void loadAddTransferView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			PatientService patientService = new PatientService();
			BranchService branchService = new BranchService();
			List<Branch> branchList = null;
			List<Patient> patientList = null;
			try {
				patientList = patientService.getAllPatient();
				branchList = branchService.getAllBranch();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("patientList",patientList);
			request.setAttribute("branchList",branchList);
			request.setAttribute("message", "");
			
			RequestDispatcher rd = request.getRequestDispatcher("transfer-add.jsp");
			rd.forward(request, response);
		}

}
