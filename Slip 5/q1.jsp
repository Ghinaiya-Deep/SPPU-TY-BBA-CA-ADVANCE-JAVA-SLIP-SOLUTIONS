<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <form method="post">
        Enter a number: <input type="text" name="number" />
        <input type="submit" value="Calculate" />
    </form>

<%
    String numStr = request.getParameter("number");
    if (numStr != null && !numStr.isEmpty()) {
        try {
            int number = Integer.parseInt(numStr);
            int lastDigit = number % 10;
            int firstDigit = number;

            // Extract first digit
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }

            int sum = firstDigit + lastDigit;
%>
            <p style="color: red; font-size: 18px;">
                Sum of first and last digit: <%= sum %>
            </p>
<%
        } catch (NumberFormatException e) {
%>
            <p style="color: red;">Please enter a valid number.</p>
<%
        }
    }
%>
</body>
</html>
