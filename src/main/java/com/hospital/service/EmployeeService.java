package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.EmployeeDAO;
import com.hospital.model.Employee;

public class EmployeeService {
	
	public boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		return EmployeeDAO.addEmployee(employee);
	}
	
	public Employee getSpecificEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		return EmployeeDAO.getSpecificEmployee(employeeId);
	}
	
	public List<Employee> getAllEmployee() throws ClassNotFoundException, SQLException {
		List<Employee> employees = EmployeeDAO.getAllEmployee();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeId());
		}
		
		return EmployeeDAO.getAllEmployee();
	}
	
	public boolean updateTheEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		return EmployeeDAO.updateEmployee(employee);
	}
	
	public boolean deleteEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		return EmployeeDAO.deleteEmployee(employeeId);
	}

}
