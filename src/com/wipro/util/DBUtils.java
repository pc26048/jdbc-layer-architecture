package com.wipro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	
	private static final String URI="jdbc:oracle:thin:@localhost:9501/XE";
	private static final String USER_NAME="system";
	private static final String PASS="rps@123";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con =DriverManager.getConnection(URI, USER_NAME, PASS);
		return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
