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
import com.hospital.model.Role;

public class RoleDAO {
	
	public static boolean addRole(Role role) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO role(roleName) VALUES (?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, role.getRoleName());
		
		boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}
	
	public static Role  getSpecificRole(int roleId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM role WHERE roleId = ? ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, roleId);
		
		ResultSet rs = ps.executeQuery();
		Role role = new Role();
		
		if(rs.next()) {
			role.setRoleId(rs.getInt("roleId"));
			role.setRoleName(rs.getString("roleName"));
		}
		ps.close();
		connection.close();	
		return role;
	}
	
	public static List<Role> getAllRole() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM role";
		
		ResultSet rs = st.executeQuery(query);
		List<Role> roles = new ArrayList<Role>();
		
		while(rs.next()) {
			Role role = new Role();
			
			role.setRoleId(rs.getInt("roleId"));
			role.setRoleName(rs.getString("roleName"));
			
			roles.add(role);
		}
		st.close();
		connection.close();
		return roles;		
	}
		
	public static boolean updateRole(Role role) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE role SET roleName = ? WHERE roleId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, role.getRoleName());
		ps.setInt(2, role.getRoleId());
		
		Boolean result = ps.executeUpdate() > 0;
		
		ps.close();
		connection.close();
		return result;
	}

	public static boolean deleteRole(int roleId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM role WHERE roleId = ?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, roleId);
		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();
		return result;
	}

}
