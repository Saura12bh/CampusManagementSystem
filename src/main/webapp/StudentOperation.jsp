<%@ page import="java.util.*, model.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Student Operation Dashboard</title>
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
			<span class="navbar-brand">Student Operation Dashboard</span> <span>
				<marquee class="text-white"> Welcome Admin Into Student
					Operation Section </marquee>
			</span> <a href="AdminDashboard.html" class="btn btn-outline-light btn-sm">
				Back to Admin Page </a>
		</div>
	</nav>

	<div class="container mt-4">

		<!-- Operation Buttons -->
		<div class="text-center mb-4">
			<button class="btn btn-primary m-2" onclick="showSection('add')">
				Add Student</button>
			<button class="btn btn-success m-2" onclick="showSection('search')">
				Search by Email</button>
			<button class="btn btn-warning m-2" onclick="showSection('dept')">
				List by Department</button>
			<button class="btn btn-info m-2" onclick="showSection('all')">
				List All Students</button>
			<a href="StudentPdfServlet" class="btn btn-info m-2"> Download
				Pdf </a>
		</div>

		<!-- ================= ADD STUDENT ================= -->
		<div id="add" class="operation-section">

			<div id="messageBox"></div>

			<h4>Add Student</h4>

			<form action="AddStdudent" method="post">
				<input type="text" class="form-control mb-2" name="sname"
					placeholder="Student Name" required /> <input type="email"
					class="form-control mb-2" name="email" placeholder="Email" required />
				<input type="text" class="form-control mb-2" name="department"
					placeholder="Department" required /> <input type="text"
					class="form-control mb-2" name="mobile" placeholder="Mobile Number"
					required /> <input type="password" class="form-control mb-2"
					name="password" placeholder="Password" required />
				<button class="btn btn-primary">Add Student</button>
			</form>
		</div>

		<!-- ================= SEARCH ================= -->
		<div id="search" class="operation-section">
			<form action="StudentByEmailServlet" method="post">
				<input type="text" name="email" class="form-control mb-2"
					placeholder="Enter Student Email " required />
				<button class="btn btn-warning">List Students</button>
			</form>

			<%
			List<Student> list1 = (List<Student>) request.getAttribute("emailStudents");

			if (list1 != null && !list1.isEmpty()) {
			%>

			<table class="table table-bordered mt-3">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Department</th>
						<th>Mobile Number</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Student s : list1) {
					%>
					<tr>
						<td><%=s.getSid()%></td>
						<td><%=s.getSname()%></td>
						<td><%=s.getEmail()%></td>
						<td><%=s.getDepartment()%></td>
						<td><%=s.getMobile()%></td>
						<td><%=s.getPassword()%></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<%
			} else if (list1 != null) {
			%>

			<div class="alert alert-danger mt-3">No students found for this
				department</div>

			<%
			}
			%>


		</div>

		<!-- ================= DEPARTMENT ================= -->
		<div id="dept" class="operation-section">
			<h4>Students by Department</h4>

			<form action="StudentByDeptServlet" method="post">
				<input type="text" name="department" class="form-control mb-2"
					placeholder="Enter Department Name" required />
				<button class="btn btn-warning">List Students</button>
			</form>

			<%
			List<Student> list = (List<Student>) request.getAttribute("deptStudents");

			if (list != null && !list.isEmpty()) {
			%>

			<table class="table table-bordered mt-3">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Department</th>
						<th>Mobile Number</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Student s : list) {
					%>
					<tr>
						<td><%=s.getSid()%></td>
						<td><%=s.getSname()%></td>
						<td><%=s.getEmail()%></td>
						<td><%=s.getDepartment()%></td>
						<td><%=s.getMobile()%></td>
						<td><%=s.getPassword()%></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<%
			} else if (list != null) {
			%>

			<div class="alert alert-danger mt-3">No students found for this
				department</div>

			<%
			}
			%>
		</div>

		<!-- ================= ALL STUDENTS ================= -->
		<div id="all" class="operation-section">
			<h4>All Students</h4>

			<form action="ListAllStudentsServlet" method="get">
				<button class="btn btn-info mb-3">Load All Students</button>
			</form>

			<%
			List<Student> allList = (List<Student>) request.getAttribute("allStudents");

			if (allList != null) {
			%>
			<table class="table table-bordered">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Department</th>
						<th>Mobile Number</th>
						<th>Password</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Student s : allList) {
					%>
					<tr>
						<td><%=s.getSid()%></td>
						<td><%=s.getSname()%></td>
						<td><%=s.getEmail()%></td>
						<td><%=s.getDepartment()%></td>
						<td><%=s.getMobile()%></td>
						<td><%=s.getPassword()%></td>
							<td><a href="UpdateStudentServlet?studentId=<%=s.getSid()%>"
							class="btn btn-success btn-sm"> Update </a> <a
							href="DeleteStudentServlet?studentId=<%=s.getSid()%>"
							class="btn btn-danger btn-sm"> Delete </a></td>
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

const params = new URLSearchParams(window.location.search);
const status = params.get("status");

if (status === "success") {
  document.getElementById("messageBox").innerHTML =
    `<div class="alert alert-success text-center">
       Student added successfully!
     </div>`;
  showSection("add");
}

if (status === "updated") {
  document.getElementById("messageBox").innerHTML =
    `<div class="alert alert-success text-center">
       Student updated successfully!
     </div>`;
  showSection("all");
}

if (status === "deleted") {
  document.getElementById("messageBox").innerHTML =
    `<div class="alert alert-success text-center">
       Student deleted successfully!
     </div>`;
  showSection("all");
}

if (status === "error") {
  document.getElementById("messageBox").innerHTML =
    `<div class="alert alert-danger text-center">
       Operation failed!
     </div>`;
  showSection("add");
}

<% if (request.getAttribute("deptStudents") != null) { %>
  showSection("dept");
<% } %>

<% if (request.getAttribute("allStudents") != null) { %>
  showSection("all");
<% } %>
</script>


</body>
</html>
