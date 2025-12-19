package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import service.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin al=new Admin();
		al.setPassword(password);
		al.setUsername(username);
		ValidateAdmin va=new ValidateAdminImpl();
		boolean b=va.verifyAdminLogin(al);
		if(b==true)
		{
			RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
        	r.forward(request, response);
		}
		else {
			RequestDispatcher r=request.getRequestDispatcher("Login.html");
        	r.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
