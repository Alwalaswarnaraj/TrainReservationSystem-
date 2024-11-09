<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Train Reservation</title>
<link rel="stylesheet" href="styles.css">
<style>
/* Basic styles for the table and button */
table {
	width: 100%; /* Make the table fill the container */
	border-collapse: collapse;
}

th, td {
	padding: 12px;
	text-align: left;
	border: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

/* Styles for the "Book" button */
.book-button {
	display: inline-block; /* Allows padding */
	padding: 10px 15px; /* Add padding */
	background-color: #4CAF50; /* Green background */
	color: white; /* White text */
	text-decoration: none; /* Remove underline */
	border-radius: 4px; /* Rounded corners */
	text-align: center; /* Center text */
	cursor: pointer; /* Change cursor on hover */
	transition: background-color 0.3s; /* Smooth background transition */
}

.book-button:hover {
	background-color: #45a049; /* Darker green on hover */
}

.disabled-button {
	background-color: white; /* Gray background for disabled */
	color: #666; /* Dark gray text */
	cursor: not-allowed; /* Not-allowed cursor */
}

    .button-container {
        
        justify-content: left;
        margin-left: 10px;
        margin-top: 10px; /* Optional: Adds some space above the button */
    }
a{
	padding-top:20px;
	/* color:white; */
	font-size: 20px;
	text-decoration: none;
}
</style>
</head>

<body>
	<h1>Train Reservation</h1>

	<!-- Button to open the panel -->
	<button class="open-btn" onclick="openPanel()">☰ Open Panel</button>

	<!-- Side Panel -->
	<div id="sidePanel" class="side-panel">
		<a href="javascript:void(0)" class="close-btn" onclick="closePanel()">×</a>
		<%
		HttpSession ses = request.getSession(false);
		String name = (String) ses.getAttribute("name");
		%>
		<h1><%=name%></h1>
		
		<div class="button-container">
		<a href="#">check reservations</a> <br>
		</div>
		<div class="button-container">
		<a href="#">change password</a><br>
		</div>
		<div class="button-container">
		<a href="#">update userName</a> <br>
		</div>
		<div class="button-container">
			<a href="#">change password</a><br>
		</div>

	</div>

	<!-- Train Reservation Table -->
	<div>
		<h3>Available Trains</h3>
		<table>
			<thead>
				<tr>
					<th>Train Number</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Schedule</th>
					<th>Number of Seats Available</th>
					<th>Book tickets</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="train" items="${trainList}">
					<tr>
						<td>${train.trainNumber}</td>
						<td>${train.source}</td>
						<td>${train.destination}</td>
						<td>${train.schedule}</td>
						<td>${train.noOfSeatsAvailable}</td>
						<td><c:if test="${train.noOfSeatsAvailable > 0}">
								<a
									href="bookingTIcketsPage.jsp?trainNumber=${train.trainNumber}&source=${train.source}&destination=${train.destination}&schedule=${train.schedule}&noOfSeatsAvailable=${train.noOfSeatsAvailable}"
									class="book-button">Book</a>
							</c:if> <c:if test="${train.noOfSeatsAvailable == 0}">
								<span class="disabled-button">Booked</span>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="script.js"></script>
</body>
</html>
