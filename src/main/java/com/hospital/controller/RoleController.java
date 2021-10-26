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

import com.hospital.model.Role;
import com.hospital.service.RoleService;

/**
 * Servlet implementation class RoleController
 */
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("all")) {
			getAllRole(request, response);
		}else {
			searchTheRole(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("delete")) {
			deleteRole(request, response);
		}
		else if(action.equals("add")) {
			addRole(request, response);
		}
		else if(action.equals("update")) {
			updateRole(request, response);
		}
		
	}
	
	private void getAllRole(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
			RoleService roleservice = new RoleService();
			List<Role> roleList = new ArrayList<Role>();
			
			String message = "";
			
			try {
				
				roleList = roleservice.getAllRole();
				if(roleList.isEmpty()) {
					message = "Sorry at the moment we don't have Role";
				}
				
			} catch (Exception e) {

				message = e.getMessage();
			}
			
			request.setAttribute("roleList", roleList);
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("role-all.jsp");
			rd.forward(request, response);
		}

	private void deleteRole(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		RoleService roleService = new RoleService();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String message = "";
		
		try {
			boolean result =  roleService.deleteRole(roleId);
			
			if(result) {
				message = "The roleId Id : " + roleId + " has been successfully deleted!";
			}else {
				message = "Failed to delete the role Id. role Id : " + roleId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("getAllRole?action=all");
	}
		
	private void addRole(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
			RoleService roleService = new RoleService();
			Role role = new Role();
			
			role.setRoleName(request.getParameter("roleName"));

			String message = "";
			
			try {
				boolean result = roleService.addRole(role);
				if(result) {
					message = "Successfully added the role name : " + role.getRoleName();
				} 
				else {
					message = "Failed to add the role: " + role.getRoleName();
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("role-add.jsp");
			rd.forward(request, response);
		}
		
	private void searchTheRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RoleService roleService = new RoleService();
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			//String roleName  = request.getParameter("roleName");
			
			Role role = new Role();
			String message = "";
			
			try {
				role = roleService.getSpecificRole(roleId);
				
				if(role == null) {
					message = "The requested role is not found! role name = " + roleId;
					role = new Role();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("role", role);
			request.setAttribute("searchFeedBack", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("role-manage.jsp");
			rd.forward(request, response);
		}
		
	private void updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RoleService roleService = new RoleService();
			
			Role role = new Role();
			role.setRoleId(Integer.parseInt(request.getParameter("roleId")));
			role.setRoleName(request.getParameter("roleName"));
			
			String message = "";
			
			try {
				boolean result =  roleService.updateTheRole(role);
				if(result) {
					message = "Role has been successfully updated! Role ID: " + role.getRoleId();
				}
				else {
					message = "Failed to update the role! Role ID: " + role.getRoleId();
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			request.setAttribute("updateMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("role-manage.jsp");
			rd.forward(request, response);
		}

}
