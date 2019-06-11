package com.frs.xyz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frs.xyz.service.Admin_User_Service;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		String details = Admin_User_Service.isValidDetails(userName, password);
		if (details.equals("Admin")) {
			response.sendRedirect("AdminPage.jsp");
		} else if (details.equals("User")) {
			response.sendRedirect("User.jsp");

		} else {
			PrintWriter out = response.getWriter();

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username or password is incorrect');");
			out.println("</script>");

			RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
			rs.include(request, response);
		}

	}

}
