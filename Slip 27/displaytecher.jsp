<%@ page language="java" contentType="text/html" %>
<html>
<head>
    <title>Teacher Details</title>
</head>
<body>
    <h2>Teacher Details Submitted</h2>
    <p><strong>Teacher ID:</strong> <%= request.getParameter("tid") %></p>
    <p><strong>Name:</strong> <%= request.getParameter("tname") %></p>
    <p><strong>Salary:</strong> <%= request.getParameter("salary") %></p>
    <p><strong>Subject:</strong> <%= request.getParameter("subject") %></p>
</body>
</html>
