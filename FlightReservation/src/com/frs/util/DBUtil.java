package com.frs.util;
import java.sql.*;

public class DBUtil {
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.209.61.33:1521:orcl","team7","team7");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		
	}

}
