package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.database.DatabaseConnection;
import com.hospital.model.Role;

public class RoleDAO {

	static Connection con = DatabaseConnection.getConnection();
	
	public static boolean addRole(Role role) throws ClassNotFoundException, SQLException {
		
		String query = "INSERT INTO role(roleName) VALUES (?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, role.getRoleName());
		boolean result = ps.executeUpdate() > 0;
		return result;
	}
	
	public static Role  getSpecificRole(int roleId) throws ClassNotFoundException, SQLException {
		
		
		String query = "SELECT * FROM role WHERE roleId = ? ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, roleId);
		ResultSet rs = ps.executeQuery();
		Role role = new Role();
		if(rs.next()) {
			role.setRoleId(rs.getInt("roleId"));
			role.setRoleName(rs.getString("roleName"));
		}	
		return role;
	}
	
	public static List<Role> getAllRole() throws ClassNotFoundException, SQLException{
		
		Statement st = con.createStatement();
		String query = "SELECT * FROM role";
		ResultSet rs = st.executeQuery(query);
		List<Role> roles = new ArrayList<Role>();
		
		while(rs.next()) {
			Role role = new Role();
			role.setRoleId(rs.getInt("roleId"));
			role.setRoleName(rs.getString("roleName"));
			roles.add(role);
		}
		return roles;		
	}
		
	public static boolean updateRole(Role role) throws ClassNotFoundException, SQLException {
		
		String query = "UPDATE role SET roleName = ? WHERE roleId = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, role.getRoleName());
		ps.setInt(2, role.getRoleId());
		Boolean result = ps.executeUpdate() > 0;
		return result;
	}

	public static boolean deleteRole(int roleId) throws ClassNotFoundException, SQLException {
		
		String query = "DELETE FROM role WHERE roleId = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, roleId);
		boolean result = ps.executeUpdate() > 0;

		return result;
	}

}
