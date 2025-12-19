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
@WebServlet("/ListAllEventsServlet")
public class ListAllEventsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Event> events = new ArrayList<>();
		EventService es=new EventServiceImpl();
		events=es.getAllEvents();
		 request.setAttribute("allEvents", events);
	        request.getRequestDispatcher("EventOperationDashboard.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
