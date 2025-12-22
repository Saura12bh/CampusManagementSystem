<%@ page import="model.Event" %>

<%
Event e = (Event) request.getAttribute("event");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h3>Edit Event</h3>

<form action="UpdateEventServlet" method="post">

    <input type="hidden" name="eid" value="<%=e.getEid()%>">

    <div class="mb-3">
        <label>Event Name</label>
        <input type="text" name="name" value="<%=e.getName()%>" class="form-control">
    </div>

    <div class="mb-3">
        <label>Date</label>
        <input type="date" name="date" value="<%=e.getEdate()%>" class="form-control">
    </div>

    <div class="mb-3">
        <label>Venue</label>
        <input type="text" name="venue" value="<%=e.getVenue()%>" class="form-control">
    </div>

    <div class="mb-3">
        <label>Capacity</label>
        <input type="number" name="capacity" value="<%=e.getCapacity()%>" class="form-control">
    </div>

    <button class="btn btn-success">Update Event</button>
</form>

</body>
</html>
