<%@ page import="java.util.*" %>
<%@ page import="model.Event, model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Student Event Registration Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />

<style>
body {
	background-color: #f8f9fa;
}
.operation-section {
	display: none;
}
</style>
</head>

<body>

<nav class="navbar navbar-dark bg-dark">
	<div class="container">
		<span class="navbar-brand">Student Event Registration Dashboard</span>
		<span>		<marquee class="text-white">Welcome Admin Into Student Event Registration Section</marquee></span>
		<a href="AdminDashboard.html" class="btn btn-outline-light btn-sm">Back to Admin Page</a>
	</div>
</nav>

<div class="container mt-4">

	<!-- Operation Buttons -->
	<div class="text-center mb-4">
		<button class="btn btn-primary m-2" onclick="showSection('studentEvents')">
			Events Registered by Student
		</button>

		<button class="btn btn-success m-2" onclick="showSection('allStudents')">
			Students Registered for Event
		</button>

		<button class="btn btn-info m-2" onclick="showSection('eventDetails')">
			Event Details
		</button>
	</div>

	<div id="studentEvents" class="operation-section">
		<h4>Events Registered by Student</h4>

		<form action="FindEventsByStudentId" method="get">
			<input type="number" name="studentId" class="form-control mb-3"
				placeholder="Enter Student ID" required />
			<button class="btn btn-primary" type="submit">Search</button>
		</form>

		<%
		List<Event> studentEvents = (List<Event>) request.getAttribute("studentEvents");
		if (studentEvents != null) {
		%>

		<table class="table table-bordered mt-3">
			<thead class="table-dark">
				<tr>
					<th>Event ID</th>
					<th>Event Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Capacity</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Event e : studentEvents) {
				%>
				<tr>
					<td><%= e.getEid() %></td>
					<td><%= e.getName() %></td>
					<td><%= e.getEdate() %></td>
					<td><%= e.getVenue() %></td>
					<td><%= e.getCapacity() %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>

	<!-- 2️⃣ STUDENTS REGISTERED FOR A SPECIFIC EVENT -->
	<div id="allStudents" class="operation-section">
		<h4>Students Registered for Event</h4>
		<form action="FindStudentByEventId" method="get">
			<input type="number" name="eventId" class="form-control mb-3"
				placeholder="Enter Event ID" required />
			<button class="btn btn-success" type="submit">Search</button>
		</form>

		<%
		List<Student> eventStudents = (List<Student>) request.getAttribute("eventStudents");
		if (eventStudents != null) {
		%>

		<table class="table table-bordered table-striped mt-3">
			<thead class="table-success">
				<tr>
					<th>Student ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Mobile No</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Student s : eventStudents) {
				%>
				<tr>
					<td><%= s.getSid() %></td>
					<td><%= s.getSname() %></td>
					<td><%= s.getEmail() %></td>
					<td><%= s.getDepartment() %></td>
					<td><%= s.getMobile() %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>

	<!-- 3️⃣ EVENT DETAILS -->
	<div id="eventDetails" class="operation-section">
		<h4>Event Details</h4>

		<form action="EventDetailsServlet" method="get">
			<input type="number" name="eventId" class="form-control mb-3"
				placeholder="Enter Event ID" required />
			<button class="btn btn-info" type="submit">Search</button>
		</form>

		<%
		Event event = (Event) request.getAttribute("event");
		if (event != null) {
		%>

		<table class="table table-bordered mt-3">
			<thead class="table-info">
				<tr>
					<th>Event Name</th>
					<th>Total Capacity</th>
					<th>Allocated Seats</th>
					<th>Remaining Seats</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%= event.getName() %></td>
					<td><%= event.getCapacity() %></td>
					<td><%= event.getAvailable() %></td>
					<td><%= event.getCapacity() - event.getAvailable() %></td>
				</tr>
			</tbody>
		</table>
		<%
		}
		%>
	</div>

</div>

<!-- JS -->
<script>
function showSection(sectionId) {
	document.querySelectorAll(".operation-section")
		.forEach(sec => sec.style.display = "none");

	document.getElementById(sectionId).style.display = "block";
}

<% if (request.getAttribute("studentEvents") != null) { %>
	showSection("studentEvents");
<% } else if (request.getAttribute("eventStudents") != null) { %>
	showSection("allStudents");
<% } else if (request.getAttribute("event") != null) { %>
	showSection("eventDetails");
<% } %>
</script>

</body>
</html>
