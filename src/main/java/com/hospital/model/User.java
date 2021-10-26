package com.hospital.model;

public class User {
	
	private int userId;
	private String userName;
	private String passWord;
	private int employeeId;
	
	public User(int userId, String userName, String passWord, int employeeId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.employeeId = employeeId;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	

}
