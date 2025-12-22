package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Event;
import service.EventService;
import service.EventServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewAllEventFormStdServlet")
public class ViewAllEventFormStdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Event> events = new ArrayList<>();
		EventService es=new EventServiceImpl();
		events=es.getAllEvents();
		 request.setAttribute("allEvents", events);
	        request.getRequestDispatcher("StudentDashboard.jsp").forward(request, response);

	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
