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
		response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=students.pdf");

        try {
            // DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cmpevent","root","Saurabh2003"
            );

            String query = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // PDF generate
            StudentPdfDownload.generateStudentPdf(rs, "students.pdf");

            // PDF Browser मध्ये show करायचं असल्यास FileOutputStream नाही तर
            // directly response.getOutputStream() वापरू शकतो (Advanced)

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
