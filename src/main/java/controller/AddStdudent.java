package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddStdudent")
public class AddStdudent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sname = request.getParameter("sname");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        Student s = new Student();
        s.setSname(sname);
        s.setEmail(email);
        s.setDepartment(department);
        s.setMobile(mobile);
        s.setPassword(password);

        StudentService ss = new StudentServiceImpl();
        boolean result = ss.addStudent(s);

        if (result) {
            response.sendRedirect("StudentOperation.jsp?status=success");
        } else {
            response.sendRedirect("StudentOperation.jsp?status=error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
