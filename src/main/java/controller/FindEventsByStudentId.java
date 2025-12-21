package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import service.*;

@WebServlet("/FindEventsByStudentId")
public class FindEventsByStudentId extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("studentId"));
		EventRegService ers=new EventRegServiceImpl();
		List<Event> events = new ArrayList<>();
		events=ers.getAllRegEvent(sid);
		request.setAttribute("studentEvents",events);
		 request.getRequestDispatcher("StudentEventReg.jsp")
         .forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
