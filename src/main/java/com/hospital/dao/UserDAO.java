package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.database.DbConnector;
import com.hospital.database.MySqlDbConnectorImpl;
import com.hospital.model.User;
public class UserDAO {
	
public static boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO user(userName,passWord,employeeId) VALUES (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		ps.setInt(3, user.getEmployeeId());
		
		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static User  getSpecificUser(int userId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM user WHERE userId = ? ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, userId);
		
		ResultSet rs = ps.executeQuery();
		User user = new User();
		
		if(rs.next()) {
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPassWord(rs.getString("passWord"));
			user.setEmployeeId(rs.getInt("employeeId"));
		}
		ps.close();
		connection.close();	
		return user;
	}
	
	public static List<User> getAllUser() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM user";
		
		ResultSet rs = st.executeQuery(query);
		List<User> roles = new ArrayList<User>();
		
		while(rs.next()) {
			User user = new User();
			
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPassWord(rs.getString("passWord"));
			user.setEmployeeId(rs.getInt("employeeId"));
			
			roles.add(user);
		}
		st.close();
		connection.close();
		return roles;		
	}
		
	public static boolean updateUser(User user) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE user SET userName = ?, passWord = ?, employeeId = ? WHERE userId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		ps.setInt(3, user.getEmployeeId());
		ps.setInt(4, user.getUserId());		
		Boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean deleteUser(int userId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM user WHERE userId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, userId);
		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}

}
