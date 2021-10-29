package com.hospital.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnectorImpl implements DbConnector {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/hospital";
		String userName = "root";
		String password = "";
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		return connection;
	}

}
