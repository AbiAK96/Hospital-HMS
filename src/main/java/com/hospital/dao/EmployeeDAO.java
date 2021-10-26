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
import com.hospital.model.Employee;

public class EmployeeDAO {
	
	public static boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		
		//02. load the driver and register 03. creating the connection
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		//04. prepare/create the statement
		String query = "INSERT INTO employee(employeeName,employeeAddress,employeeEmail,employeeTel,roleId,branchId) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, employee.getEmployeeName());
		ps.setString(2, employee.getEmployeeAddress());
		ps.setString(3, employee.getEmployeeEmail());
		ps.setString(4, employee.getEmployeeTel());
		ps.setInt(5, employee.getRoleId());
		ps.setInt(6, employee.getBranchId());
		
		//05. execute the statement
		//06. process the response form the db end
		boolean result = ps.executeUpdate() > 0;
				
		//07. close the connection 
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static Employee getSpecificEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM employee WHERE employeeId = ?";
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setInt(1, employeeId);
		
		ResultSet rs = ps.executeQuery();
		Employee employee = new Employee();
		if(rs.next()) {
			employee.setEmployeeId(rs.getInt("employeeId"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setEmployeeAddress(rs.getString("employeeAddress"));
			employee.setEmployeeEmail(rs.getString("employeeEmail"));
			employee.setEmployeeTel(rs.getString("employeeTel"));
			employee.setRoleId(rs.getInt("roleId"));
			employee.setBranchId(rs.getInt("branchId"));

		}		
		ps.close();
		connection.close();
		return employee;
		
	}
	
	public static List<Employee> getAllEmployee()throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		Statement st = connection.createStatement();
		String query = "SELECT * FROM employee";
		
		ResultSet rs =st.executeQuery(query);
		List<Employee> employees = new ArrayList<Employee>();
		
		while(rs.next()) {
			Employee employee = new Employee();

			employee.setEmployeeId(rs.getInt("employeeId"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setEmployeeAddress(rs.getString("employeeAddress"));
			employee.setEmployeeEmail(rs.getString("employeeEmail"));
			employee.setEmployeeTel(rs.getString("employeeTel"));
			employee.setRoleId(rs.getInt("roleId"));
			employee.setBranchId(rs.getInt("branchId"));
			
			employees.add(employee);
		}
		st.close();
		connection.close();
		return employees;
	}
	
	public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE employee SET employeeName=?,employeeAddress=?, employeeEmail=?,employeeTel=?,roleId=?,branchId=? WHERE employeeId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, employee.getEmployeeName());
		ps.setString(2, employee.getEmployeeAddress());
		ps.setString(3, employee.getEmployeeEmail());
		ps.setString(4, employee.getEmployeeTel());
		ps.setInt(5, employee.getRoleId());
		ps.setInt(6, employee.getBranchId());
		ps.setInt(7, employee.getEmployeeId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteEmployee(int employeeId)throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new MySqlDbConnectorImpl();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM employee WHERE employeeId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, employeeId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
