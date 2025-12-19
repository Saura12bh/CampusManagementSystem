package controller;
import java.util.*;
import model.*;
import service.StudentService;
import service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ListAllStudentsServlet")
public class ListAllStudentsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();
		 StudentService ss = new StudentServiceImpl();
	        students=ss.allStudent();
		
		 request.setAttribute("allStudents", students);
	        request.getRequestDispatcher("StudentOperation.jsp")
	               .forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
