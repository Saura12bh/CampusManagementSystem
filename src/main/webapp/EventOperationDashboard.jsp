<%@ page import="java.util.*, model.Event"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Event Operation Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

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

	<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<span class="navbar-brand">Event Operation Dashboard</span> <span><marquee
					style="color: #f8f9fa" class="navbar-brand" behavior="scroll"
					direction="left"> Welcome Admin Into Event
					Section </marquee></span> <a href="AdminDashboard.html"
				class="btn btn-outline-light btn-sm"> Back to Admin Page </a>
		</div>
	</nav>

	<div class="container mt-4">

		<!-- Buttons -->
		<div class="text-center mb-4">
			<button class="btn btn-primary m-2" onclick="showSection('add')">
				Add Event</button>
			<button class="btn btn-info m-2" onclick="showSection('all')">
				View All Events</button>
			<button class="btn btn-success m-2" onclick="showSection('upcoming')">
				Upcoming Events</button>
		</div>

		<!-- ================= ADD EVENT ================= -->
		<div id="add" class="operation-section">
			<div id="messageBox"></div>

			<h4>Add New Event</h4>

			<form action="AddEventServlet" method="post">
				<input type="text" name="ename" class="form-control mb-2"
					placeholder="Event Name" required /> <input type="date"
					name="edate" class="form-control mb-2" required /> <input
					type="text" name="venue" class="form-control mb-2"
					placeholder="Venue" required /> <input type="number"
					name="capacity" class="form-control mb-2" placeholder="Capacity"
					required />

				<button class="btn btn-primary">Add Event</button>
			</form>
		</div>

		<!-- ================= ALL EVENTS ================= -->
		<div id="all" class="operation-section">
			<h4>All Events</h4>

			<form action="ListAllEventsServlet" method="get">
				<button class="btn btn-info mb-3">Load All Events</button>
			</form>

			<%
			List<Event> allEvents = (List<Event>) request.getAttribute("allEvents");

			if (allEvents != null && !allEvents.isEmpty()) {
			%>

			<table class="table table-bordered">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Venue</th>
						<th>Capacity</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Event e : allEvents) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td><%=e.getVenue()%></td>
						<td><%=e.getCapacity()%></td>
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

		<!-- ================= UPCOMING EVENTS ================= -->
		<div id="upcoming" class="operation-section">
			<h4>Upcoming Events</h4>

			<form action="UpcomingEventsServlet" method="get">
				<button class="btn btn-success mb-3">Load Upcoming Events</button>
			</form>

			<%
			List<Event> upcoming = (List<Event>) request.getAttribute("upcomingEvents");

			if (upcoming != null && !upcoming.isEmpty()) {
			%>

			<table class="table table-bordered">
				<thead class="table-success">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Venue</th>
						<th>Capacity</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Event e : upcoming) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td><%=e.getVenue()%></td>
						<td><%=e.getCapacity()%></td>
					</tr>
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

	</div>

	<script>
function showSection(id) {
  document.querySelectorAll(".operation-section")
    .forEach(sec => sec.style.display = "none");
  document.getElementById(id).style.display = "block";
}

function showSection(id) {
	  document.querySelectorAll(".operation-section")
	    .forEach(sec => sec.style.display = "none");
	  document.getElementById(id).style.display = "block";
	}

	const params = new URLSearchParams(window.location.search);
	const status = params.get("status");

	if (status === "success") {
	  document.getElementById("messageBox").innerHTML =
	    `<div class="alert alert-success text-center">
	       Event added successfully!
	     </div>`;
	  showSection("add");
	}

	if (status === "error") {
	  document.getElementById("messageBox").innerHTML =
	    `<div class="alert alert-danger text-center">
	       Event not added!
	     </div>`;
	  showSection("add");
	}

/* auto open section */
<%if (request.getAttribute("allEvents") != null) {%>
  showSection("all");
<%}%>

<%if (request.getAttribute("upcomingEvents") != null) {%>
  showSection("upcoming");
<%}%>
</script>

</body>
</html>
