package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdfdownload.StudentPdfDownload;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/StudentPdfServlet")
public class StudentPdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cmpevent","root","Saurabh2003");

			PreparedStatement psmt =
				con.prepareStatement("SELECT * FROM student");
			ResultSet rs = psmt.executeQuery();

			String path = System.getProperty("user.home")
				+ "\\Downloads\\students.pdf";

			StudentPdfDownload.generateStudentPdf(rs, path);
			
			response.sendRedirect("StudentOperation.jsp");
			

		} catch (Exception e) {
			System.out.println("Error is " + e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
