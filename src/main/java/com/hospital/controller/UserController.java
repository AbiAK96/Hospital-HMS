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

import com.hospital.model.Employee;
import com.hospital.model.User;
import com.hospital.service.EmployeeService;
import com.hospital.service.UserService;



public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("add")){
			this.loadAddUserView(request,response);
		}
		if(action != null && action.equals("all")) {
			getAllUser(request, response);
		}else {
			searchTheUser(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deleteUser(request, response);
		}
		else if(action.equals("add")) {
			addUser(request, response);
		}
		else if(action.equals("update")) {
			updateUser(request, response);
		}
		
	}
	
	
	private void getAllUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		UserService userservice = new UserService();
			List<User> userList = new ArrayList<User>();
			
			String message = "";
			
			try {
				
				userList = userservice.getAllUser();
				if(userList.isEmpty()) {
					message = "Sorry at the moment we don't have User";
				}
				
			} catch (ClassNotFoundException | SQLException e) {

				message = e.getMessage();
			}
			
			request.setAttribute("userList", userList);
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("user-all.jsp");
			rd.forward(request, response);
		}

	private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		UserService userService = new UserService();
		int userId = Integer.parseInt(request.getParameter("userId"));
		String message = "";
		
		try {
			boolean result =  userService.deleteUser(userId);
			
			if(result) {
				message = "The user Id : " + userId + " has been successfully deleted!";
			}else {
				message = "Failed to delete the User. User Id : " + userId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("getAllUser?action=all");
	}
		
	private void addUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
			UserService userService = new UserService();
			User user = new User();
			
			user.setUserName(request.getParameter("userName"));
			user.setPassWord(request.getParameter("passWord"));
			user.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			
			String message = "";
			
			try {
				boolean result = userService.addUser(user);
				if(result) {
					message = "Successfully added the user : " + user.getUserName();
				} 
				else {
					message = "Failed to add the user: " + user.getPassWord();
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("user-add.jsp");
			rd.forward(request, response);
		}
		
	private void searchTheUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UserService userService = new UserService();
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			User user = new User();
			String message = "";
			
			try {
				user = userService.getSpecificUser(userId);
				
				if(user == null) {
					message = "The requested bill is not found! user ID = " + userId;
					user = new User();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("user", user);
			request.setAttribute("searchFeedBack", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("user-manage.jsp");
			rd.forward(request, response);
		}
		
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UserService userService = new UserService();
			
			User user = new User();
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			user.setUserName(request.getParameter("userName"));
			user.setPassWord(request.getParameter("passWord"));
			user.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));

			
			String message = "";
			
			try {
				boolean result =  userService.updateTheUser(user);
				if(result) {
					message = "User has been successfully updated! User Name: " + user.getUserName();
				}
				else {
					message = "Failed to update the user! User Name: " + user.getUserName();
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("updateMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("user-manage.jsp");
			rd.forward(request, response);
		}
	
	public void loadAddUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = null;
		try {
			employeeList = employeeService.getAllEmployee();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("employeeList",employeeList);
		request.setAttribute("message", "");
		
		RequestDispatcher rd = request.getRequestDispatcher("user-add.jsp");
		rd.forward(request, response);
	}
}
