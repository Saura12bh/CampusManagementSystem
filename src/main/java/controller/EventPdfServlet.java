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
		 response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=events.pdf");
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/cmpevent","root","Saurabh2003"
	            );

	            String query = "SELECT * FROM event";
	            PreparedStatement ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            StudentPdfDownload.generateEventPdf(rs, "events.pdf");

	        } catch (Exception e) {
	        	   e.printStackTrace();
	        }
	        }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
