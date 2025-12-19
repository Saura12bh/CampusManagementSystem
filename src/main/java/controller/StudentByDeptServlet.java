package controller;
import model.*;
import service.StudentService;
import service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/StudentByDeptServlet")
public class StudentByDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department = request.getParameter("department");

        List<Student> students = new ArrayList<>();
        StudentService ss = new StudentServiceImpl();
        students=ss.searchByDept(department);
        request.setAttribute("deptStudents", students);
        request.getRequestDispatcher("StudentOperation.jsp")
               .forward(request, response);
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
