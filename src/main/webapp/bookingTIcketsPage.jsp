<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Train Tickets</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        .booking-form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-group input[type="number"],
        .form-group input[type="text"] {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .form-group input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="booking-form">
    <h2>Book Your Seats</h2>
    <form action="reservation" method="get">
        <div class="form-group">
            <label for="trainNumber">Train Number</label>
            <input type="text" id="trainNumber" name="trainNumber" value="${param.trainNumber}" readonly>
        </div>

        <div class="form-group">
            <label for="source">Source</label>
            <input type="text" id="source" name="source" value="${param.source}" readonly>
        </div>

        <div class="form-group">
            <label for="destination">Destination</label>
            <input type="text" id="destination" name="destination" value="${param.destination}" readonly>
        </div>

        <div class="form-group">
            <label for="schedule">Schedule</label>
            <input type="text" id="schedule" name="schedule" value="${param.schedule}" readonly>
        </div>

        <div class="form-group">
            <label for="availableSeats">Available Seats</label>
            <input type="text" id="availableSeats" name="availableSeats" value="${param.noOfSeatsAvailable}" readonly>
        </div>

        <div class="form-group">
            <label for="numSeats">Number of Seats to Book</label>
            <input type="number" id="numSeats" name="numSeats" min="1" max="${param.noOfSeatsAvailable}" required>
        </div>

        <div class="form-group">
            <input type="submit" value="Check Availability and Book">
        </div>
    </form>
</div>

</body>
</html>
