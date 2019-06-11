package com.frs.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.frs.xyz.bean.XYZ_User_Bean;
import com.frs.xyz.util.DBUtil;

public class UserDAO {
	// To check Admin or not.
	public int isValidAdmin(String userName, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int flag = 0;
		String query = "select * from frs_admin_table"; // Query for selecting values from frs_admin_table.
		try {
			connection = DBUtil.getConnection(); // Get connection

			preparedStatement = connection.prepareStatement(query); // preparing statement.
			resultSet = preparedStatement.executeQuery(); // Executing query and stored values in resultset.
			while (resultSet.next()) {
				if (userName.equals(resultSet.getString(1)) && (password.equals(resultSet.getString(2)))) {
					flag = 1;
					break;

				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	// To check user or not.

	public int isValidUser(String userName, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int flag = 0;
		String query = "select email,password from frs_user_table"; // Query for selecting values from frs_admin_table.
		try {
			connection = DBUtil.getConnection(); // Get connection

			preparedStatement = connection.prepareStatement(query); // preparing statement.
			resultSet = preparedStatement.executeQuery(); // Executing query and stored values in resultset.
			while (resultSet.next()) {
				if (userName.equals(resultSet.getString(1)) && (password.equals(resultSet.getString(2)))) {
					flag = 1;
					break;

				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public int insertUserDetails(XYZ_User_Bean xyz_User_Bean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int flag = 0;
		String query = "insert into frs_user_table values(?,?,?,?,?,?)";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, xyz_User_Bean.getUser_First_Name());
			preparedStatement.setString(2, xyz_User_Bean.getUser_Last_Name());
			preparedStatement.setString(3, xyz_User_Bean.getUserName());
			preparedStatement.setString(4, xyz_User_Bean.getEmail());
			preparedStatement.setString(5, xyz_User_Bean.getPassword());
			preparedStatement.setString(6, xyz_User_Bean.getPhoneNumber());
			preparedStatement.executeUpdate();
			flag = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}

		return flag;
	}

}
