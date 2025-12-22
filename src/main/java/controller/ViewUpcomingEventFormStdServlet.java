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
import java.util.List;

@WebServlet("/ViewUpcomingEventFormStdServlet")
public class ViewUpcomingEventFormStdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventService es = new EventServiceImpl();
        List<Event> events = es.getUpComingEvents();

        request.setAttribute("upcomingEvents", events);

        request.getRequestDispatcher("StudentDashboard.jsp?view=upcoming")
               .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
