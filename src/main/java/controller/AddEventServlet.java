package controller;
import model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import service.*;

@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String name = request.getParameter("ename");
	        String date = request.getParameter("edate");
	        String venue = request.getParameter("venue");
	        int capacity = Integer.parseInt(request.getParameter("capacity"));
	        Event e=new Event();
	        e.setName(name);
	        e.setEdate(Date.valueOf(date));
	        e.setVenue(venue);
	        e.setCapacity(capacity);
	        EventService es=new EventServiceImpl();
	        boolean b=es.isAddEvent(e);
	        if (b) {
	            response.sendRedirect("EventOperationDashboard.jsp?status=success");
	        } else {
	            response.sendRedirect("EventOperationDashboard.jsp?status=error");
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
