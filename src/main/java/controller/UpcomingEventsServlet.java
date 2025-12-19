package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import model.*;
import service.*;
@WebServlet("/UpcomingEventsServlet")
public class UpcomingEventsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<Event> events = new ArrayList<>();
	        EventService es=new EventServiceImpl();
	        events=es.getUpComingEvents();
	        request.setAttribute("upcomingEvents", events);
	        request.getRequestDispatcher("EventOperationDashboard.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
