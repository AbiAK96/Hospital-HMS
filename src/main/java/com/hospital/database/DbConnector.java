package com.hospital.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
	
	public Connection getConnection()throws ClassNotFoundException, SQLException;
	//public Connection getConnectionOracle()throws ClassNotFoundException, SQLException; 

}
