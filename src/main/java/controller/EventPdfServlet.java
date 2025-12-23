package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdfdownload.StudentPdfDownload;

import java.io.IOException;
import java.sql.*;

@WebServlet("/EventPdfServlet")
public class EventPdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cmpevent","root","Saurabh2003");

			PreparedStatement psmt =
				con.prepareStatement("SELECT * FROM event");
			ResultSet rs = psmt.executeQuery();

			String path = System.getProperty("user.home")
				+ "\\Downloads\\events.pdf";

			StudentPdfDownload.generateStudentPdf(rs, path);
			
			response.sendRedirect("EventOperationDashboard.jsp");
			

		} catch (Exception e) {
			System.out.println("Error is " + e);
		}
	        }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
