package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import service.EventRegService;
import service.EventRegServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/EventDetailsServlet")
public class EventDetailsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eid = Integer.parseInt(request.getParameter("eventId"));
		EventRegService ers=new EventRegServiceImpl();
		Event events=new Event();
		events=ers.getEventCapacityDetails(eid);
		request.setAttribute("event",events);
		 request.getRequestDispatcher("StudentEventReg.jsp")
         .forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
