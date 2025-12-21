package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import database.*;
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/cmpevent",
	                    "root",
	                    "Saurabh2003"
	            );

	            PreparedStatement ps = con.prepareStatement(
	                    "SELECT * FROM student WHERE email=? AND password=?"
	            );
	            ps.setString(1, email);
	            ps.setString(2, password);

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	
	            	int sid=rs.getInt("sid");
	            	String name=rs.getString("sname");
	                HttpSession session = request.getSession();
	                session.setAttribute("StudentEmail",email);
	                session.setAttribute("StudentName",name);
	                session.setAttribute("StudentId",sid);
	                response.sendRedirect("StudentDashboard.jsp");
	            } else {
	                response.sendRedirect("Register.html");
	            }
	        }
	        catch(Exception e)
	        {
	        	  e.printStackTrace();
	        }

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
