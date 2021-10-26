package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hospital.model.User;
import com.hospital.database.*;

public class LoginDAO {
	
	public boolean validate(User user) throws ClassNotFoundException, SQLException {
        boolean status = false;

	        DbConnector connector = new MySqlDbConnectorImpl();
			Connection connection = connector.getConnection();
            // Step 2:Create a statement using connection object
			String query = "select * from user where userName = ? and passWord = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

            return status;
    }

//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
    }

