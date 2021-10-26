package com.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.LoginDAO;
import com.hospital.model.User;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;

    public void init() {
    	loginDao = new LoginDAO();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);

        try {
            if (loginDao.validate(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("home.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
