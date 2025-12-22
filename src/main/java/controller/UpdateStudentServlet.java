package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.*;
import service.*;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   StudentService ss = new StudentServiceImpl();

	        if (request.getParameter("sid") != null) {

	            int sid = Integer.parseInt(request.getParameter("sid"));
	            String sname = request.getParameter("sname");
	            String email = request.getParameter("email");
	            String password = request.getParameter("password");
	            String department = request.getParameter("department");
	            String mobile = request.getParameter("mobile");

	            Student s = new Student(sid, sname, email, password, department, mobile);
	            ss.updateStudent(s);
	            response.sendRedirect("StudentOperation.jsp?status=updated");
	        }
	        else {
	            int studentId = Integer.parseInt(request.getParameter("studentId"));
	            Student student = ss.getStudentById(studentId);

	            request.setAttribute("student", student);
	            request.getRequestDispatcher("EditStudent.jsp").forward(request, response);
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
