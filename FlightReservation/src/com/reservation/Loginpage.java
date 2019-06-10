package com.reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginpage
 */
@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Loginpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String name = request.getParameter("username");
		
		String password = request.getParameter("pwd");
		
		if(name.equals("PraveenKumar") || name.equals("Mohan")) {
			RequestDispatcher reqdis = request.getRequestDispatcher("Playboy.html");
			reqdis.forward(request, response);
			
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<h1> Username is incorrect</h1>");
			
			RequestDispatcher reqdis = request.getRequestDispatcher("table.html");
			reqdis.include(request, response);
			
		}
	}

}
