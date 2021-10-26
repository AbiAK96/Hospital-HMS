package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.UserDAO;
import com.hospital.model.User;


public class UserService {
	
	public boolean addUser(User user) throws ClassNotFoundException, SQLException {
		return UserDAO.addUser(user);
	}
	
	public User getSpecificUser(int userId) throws ClassNotFoundException, SQLException {
		return UserDAO.getSpecificUser(userId);
	}
	
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		return UserDAO.getAllUser();
	}
	
	public boolean updateTheUser(User user) throws ClassNotFoundException, SQLException {
		return UserDAO.updateUser(user);
	}
	
	public boolean deleteUser(int userId) throws ClassNotFoundException, SQLException {
		return UserDAO.deleteUser(userId);
	}

}
