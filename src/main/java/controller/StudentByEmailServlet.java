package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StudentByEmailServlet")
public class StudentByEmailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<Student> students = new ArrayList<>();
        StudentService ss = new StudentServiceImpl();
        students=ss.searchByEmail(email);
        request.setAttribute("emailStudents", students);
        request.getRequestDispatcher("StudentOperation.jsp")
               .forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
