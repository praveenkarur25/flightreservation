package com.frs.xyz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frs.xyz.bean.XYZ_User_Bean;
import com.frs.xyz.service.Admin_User_Service;

@WebServlet("/register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String first_Name = request.getParameter("firstname");
		String last_Name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phonenumber");
		String user_Name = first_Name + " " + last_Name;
		XYZ_User_Bean userBean = new XYZ_User_Bean();
		userBean.setUser_First_Name(first_Name);
		userBean.setUser_Last_Name(last_Name);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setPhoneNumber(phoneNumber);
		userBean.setUserName(user_Name);

		Admin_User_Service insertDetails = new Admin_User_Service();
		boolean insert = insertDetails.insertUser(userBean);

		if (insert == true) {
			System.out.println("Registered successfully");
			PrintWriter out = response.getWriter();

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registered Successfully and login with your mail ID');");

			out.println("</script>");

			RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
			rs.include(request, response);
		}

	}

}
