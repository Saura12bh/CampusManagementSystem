package controller;
import model.*;
import service.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EventService es = new EventServiceImpl();

        if (request.getParameter("eid") != null) {

            int eid = Integer.parseInt(request.getParameter("eid"));
            String name = request.getParameter("name");
            String d = request.getParameter("date");
            String venue = request.getParameter("venue");
            int capacity = Integer.parseInt(request.getParameter("capacity"));
            Date date=Date.valueOf(d);
            Event e = new Event(eid, name, date, venue, capacity);
            es.isUpdateEvent(e);

            response.sendRedirect("EventOperationDashboard.jsp?status=updated");

        } 
        else {

            int eventId = Integer.parseInt(request.getParameter("eventId"));
            Event event = es.getEventById(eventId);

            request.setAttribute("event", event);
            request.getRequestDispatcher("EditEvent.jsp").forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
