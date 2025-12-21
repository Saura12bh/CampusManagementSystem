<%
if (session.getAttribute("StudentEmail") == null) {
    response.sendRedirect("Register.html");
}
%>

<h2>Welcome, <%= session.getAttribute("StudentName") %></h2>
<h2>Welcome, <%= session.getAttribute("StudentEmail") %></h2>
<h2>Welcome, <%= session.getAttribute("StudentId") %></h2>

<a href="LogoutServlet">Logout</a>
