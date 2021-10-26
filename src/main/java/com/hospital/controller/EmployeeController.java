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
import com.hospital.model.Employee;
import com.hospital.model.Role;
import com.hospital.service.BranchService;
import com.hospital.service.EmployeeService;
import com.hospital.service.RoleService;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if(action != null && action.equals("add")){
			
			this.loadAddRoleView(request,response);
		}
		if(action != null && action.equals("all")) {
			getAllEmployee(request, response);
		}else {
			searchTheEmployee(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deleteEmployee(request, response);
		}
		else if(action.equals("add")) {
			try {
				addEmployee(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		else if(action.equals("update")) {
			updateEmployee(request, response);
		}
		
	}
	
	private void getAllEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = new ArrayList<Employee>();
		
		String message = "";
		
		try {
			
			employeeList = employeeService.getAllEmployee();
			if(employeeList.isEmpty()) {
				message = "Sorry at the moment we don't have Employee";
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}

		request.setAttribute("employeeList", employeeList);
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("employee-all.jsp");
		rd.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request,HttpServletResponse response) throws IOException {
	
		EmployeeService employeeService = new EmployeeService();
	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	String message = "";
	
	try {
		boolean result =  employeeService.deleteEmployee(employeeId);
		
		if(result) {
			message = "The Employee Id : " + employeeId + " has been successfully deleted!";
		}else {
			message = "Failed to delete the Employee. Employee Id : " + employeeId;
		}
		
	} catch (ClassNotFoundException | SQLException e) {

		message = e.getMessage();
	}
	HttpSession session = request.getSession();
	session.setAttribute("deleteMessage", message);
	
	response.sendRedirect("Employee?action=all");
}
	
	private void addEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EmployeeService employeeService = new EmployeeService();
		Employee employee = new Employee();
		
		employee.setEmployeeName(request.getParameter("employeeName"));
		employee.setEmployeeAddress(request.getParameter("employeeAddress"));
		employee.setEmployeeEmail(request.getParameter("employeeEmail"));
		employee.setEmployeeTel(request.getParameter("employeeTel"));
		employee.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		employee.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		
		String message = "";
		
		try {
			boolean result = employeeService.addEmployee(employee);
			if(result) {
				message = "Successfully added the employee : " + employee.getEmployeeName();
			} 
			else {
				message = "Failed to add the employee: " + employee.getEmployeeName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("employee-add.jsp");
		rd.forward(request, response);
	}
	
	private void searchTheEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		
		Employee employee = new Employee();
		String message = "";
		
		try {
			employee = employeeService.getSpecificEmployee(employeeId);
			
			if(employee == null) {
				message = "The requested Employee is not found! Employee ID = " + employeeId;
				employee = new Employee();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("employee", employee);
		request.setAttribute("searchFeedBack", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("employee-manage.jsp");
		rd.forward(request, response);
	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		
		Employee employee = new Employee();
		employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		employee.setEmployeeName(request.getParameter("employeeName"));
		employee.setEmployeeAddress(request.getParameter("employeeAddress"));
		employee.setEmployeeEmail(request.getParameter("employeeEmail"));
		employee.setEmployeeTel(request.getParameter("employeeTel"));
		employee.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		employee.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		
		String message = "";
		
		try {
			boolean result =  employeeService.updateTheEmployee(employee);
			if(result) {
				message = "Employee has been successfully updated! Employee ID: " + employee.getEmployeeId();
			}
			else {
				message = "Failed to update the employee! Employee ID: " + employee.getEmployeeId();
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		request.setAttribute("updateMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("employee-manage.jsp");
		rd.forward(request, response);
	}
	
		public void loadAddRoleView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			RoleService roleSerivice = new RoleService();
			BranchService branchService = new BranchService();
			List<Role> roleList = null;
			List<Branch> branchList = null;
			try {
				branchList = branchService.getAllBranch();
				roleList = roleSerivice.getAllRole();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("roleList", roleList);
			request.setAttribute("branchList", branchList);
			request.setAttribute("message", "");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("employee-add.jsp");
			rd.forward(request, response);
			
		}
		

}
