package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.RoleDAO;
import com.hospital.model.Role;

public class RoleService {
	
	public boolean addRole(Role role) throws ClassNotFoundException, SQLException {
		return RoleDAO.addRole(role);
	}
	
	public Role getSpecificRole(int roleId) throws ClassNotFoundException, SQLException {
		return RoleDAO.getSpecificRole(roleId);
	}
	
	public List<Role> getAllRole() throws ClassNotFoundException, SQLException {
		
		List<Role> roles = RoleDAO.getAllRole();
		
		for(Role role : roles) {
			System.out.println(role.getRoleId());
		}
		
		return RoleDAO.getAllRole();
	}
	
	public boolean updateTheRole(Role role) throws ClassNotFoundException, SQLException {
		return RoleDAO.updateRole(role);
	}
	
	public boolean deleteRole(int roleId) throws ClassNotFoundException, SQLException {
		return RoleDAO.deleteRole(roleId);
	}

}
