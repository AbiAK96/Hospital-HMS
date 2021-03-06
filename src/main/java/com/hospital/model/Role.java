package com.hospital.model;

public class Role {
	
	private int roleId;
	private String roleName;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id"+this.roleId+" -- Role Name"+this.roleName;
	}
	
	public Role() {
		
	}
	
	

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

	
}
