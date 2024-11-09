<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="confirm.css">
</head>
<body>
	<h1 align="center">Train Reservation</h1>
	<h>Tickets Confirmed</h2>
	<%
		HttpSession se =  request.getSession(false);
		String reservationID = (String) se.getAttribute("reservationId");
		Integer trainNumber = (Integer)se.getAttribute("trainNumber");
		String date = (String)se.getAttribute("date");
		String source = (String) se.getAttribute("source");
		String destination = (String) se.getAttribute("destination");
		Integer seats = (Integer)se.getAttribute("seats");
		String name = (String) se.getAttribute("name");
		/* PrintWriter p = response.getWriter(); */
	%>
	<table border="2px solid">
		<tr>
			<td>Name</td>
			<td>Reservation ID:</td>
			<td>Train Number</td>
			<td>Date</td>
			<td>source</td>
			<td>destination</td>
			<td>No of seats</td>
		</tr>
		<tr>
			<td><% out.println(name);%> </td>
			<td><% out.println(reservationID); %> </td>
			<td><% out.println(trainNumber ); %></td>
			<td><% out.println(date);%></td>
			<td><% out.println(source);%></td>
			<td><% out.println(destination );%></td>
			<td><% out.println(seats); %></td>
		</tr>
	</table>
	
	<% session.invalidate();%>
</body>
</html>