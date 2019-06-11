package com.frs.xyz.service;

import com.frs.xyz.bean.XYZ_User_Bean;
import com.frs.xyz.dao.UserDAO;

public class Admin_User_Service {

	public static String isValidDetails(String user_Name, String password) {

		UserDAO userDAO = new UserDAO();
		int admin = userDAO.isValidAdmin(user_Name, password);
		if (admin == 1) {
			return "Admin";
		} else {
			int user = userDAO.isValidUser(user_Name, password);
			if (user == 1)
				return "User";
			else
				return "invalid";
		}

	}

	public static boolean insertUser(XYZ_User_Bean xyz_User_Bean) {
		UserDAO userDAO = new UserDAO();
		int insert = userDAO.insertUserDetails(xyz_User_Bean);
		if (insert == 1)
			return true;
		else
			return false;
	}

}
