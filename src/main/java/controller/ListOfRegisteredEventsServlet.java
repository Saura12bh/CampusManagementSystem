package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Event;
import service.EventRegService;
import service.EventRegServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/ListOfRegisteredEventsServlet")
public class ListOfRegisteredEventsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	// eith false pass kel mhanje jo ek global session cha object create kela ye ha pan tya la ch point kar to
		HttpSession session = request.getSession(false);
// session madhe jar student cha id nasla tar te login chya ch page la redirect kar t
		
		if (session == null || session.getAttribute("studentId") == null) {
			response.sendRedirect("login.html");
			return;
		}

		// ha jo id aahe to jo student login kar nar ye tya cha id ye String to int cast kar garje ch ye 
		int studentId = (int) session.getAttribute("studentId");
        // 3️⃣ Service call
        EventRegService ers = new EventRegServiceImpl();
        List<Event> regEvent = ers.getAllRegEvent(studentId);

request.setAttribute("registeredEvents", regEvent);
		
		request.setAttribute("view", "registered");

		// if details correct then move to studentDashboard page 
		request.getRequestDispatcher("StudentDashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
