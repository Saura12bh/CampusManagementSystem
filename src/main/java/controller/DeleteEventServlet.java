package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.*;
@WebServlet("/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int eventId = Integer.parseInt(request.getParameter("eventId"));

	        EventService es = new EventServiceImpl();
	        es.isDeleteEvent(eventId);

	        response.sendRedirect("EventOperationDashboard.jsp?status=deleted");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
