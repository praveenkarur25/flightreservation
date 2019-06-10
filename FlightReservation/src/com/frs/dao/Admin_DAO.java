package com.frs.dao;
import java.sql.*;

import com.frs.util.DBUtil;

public class Admin_DAO {
	public static void main(String[] args) {
		String query = "select * from resrvation";
		try {
			Connection connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			query = "insert into mohan values(?, ?)";
			statement.executeUpdate(query);
			System.out.println("data updated");
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			String name[] = {"srini","praveen","mohan"};
//			String password [] = {"23324","345435","4354"};
//			for(int i=0; i<name.length; i++) {
//				preparedStatement.setString(1, name[i]);
//				preparedStatement.setString(2, password[i]);
//				preparedStatement.executeUpdate();
//				System.out.println(i +"row updated");
//			}
			
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//			while(rs.next())
//			System.out.println(rs.getString(1) + rs.getString(2));
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
