package controller;

import jakarta.servlet.ServletException;
import service.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EventRegService;
import service.EventRegServiceImpl;

import java.io.IOException;

@WebServlet("/ApplyForEventServlet")
public class ApplyForEventServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Session check
				HttpSession session = request.getSession(false);

				if (session == null || session.getAttribute("studentId") == null) {
					response.sendRedirect("Register.html");
					return;
				}

				// 2. Get data
				int studentId = (int) session.getAttribute("studentId");
				int eventId = Integer.parseInt(request.getParameter("eventId"));

				// 3. Service call
				StudentEventRegService ser=new StudentEventRegServiceImpl();
				boolean status=ser.registerStudentForEvent(studentId, eventId);

				// 4. Redirect with message
				if (status) {
					response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=success");
				} else {
					response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=already");
				}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
