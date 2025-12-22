<%@ page import="model.Student" %>
<%
Student s = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<form action="UpdateStudentServlet" method="post">
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-5">

      <div class="card shadow-sm">
        <div class="card-body">

          <h4 class="text-center mb-4">Update Student</h4>

          <input type="hidden" name="sid" value="<%=s.getSid()%>">

          <input type="text" name="sname"
                 value="<%=s.getSname()%>"
                 class="form-control mb-3"
                 placeholder="Student Name"
                 required>

          <input type="email" name="email"
                 value="<%=s.getEmail()%>"
                 class="form-control mb-3"
                 placeholder="Email"
                 required>

          <input type="text" name="password"
                 value="<%=s.getPassword()%>"
                 class="form-control mb-3"
                 placeholder="Password"
                 required>

          <input type="text" name="department"
                 value="<%=s.getDepartment()%>"
                 class="form-control mb-3"
                 placeholder="Department"
                 required>

          <input type="text" name="mobile"
                 value="<%=s.getMobile()%>"
                 class="form-control mb-3"
                 placeholder="Mobile Number"
                 required>

          <button class="btn btn-success w-100">
            Update Student
          </button>

        </div>
      </div>

    </div>
  </div>
</div>
</form>
</body>
</html>

