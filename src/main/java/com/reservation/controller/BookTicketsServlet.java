package com.reservation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reservation.model.ReservationModel;
import com.reservation.service.BookTicketsService;

public class BookTicketsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		String date = req.getParameter("schedule");
		LocalDate date2 = LocalDate.parse(date); // Convert String to Date
		System.out.println("Converted Date: " + date);
		int trainNumber = Integer.parseInt(req.getParameter("trainNumber"));
		int availableseats = Integer.parseInt(req.getParameter("availableSeats"));
		int numSeats = Integer.parseInt(req.getParameter("numSeats"));
		HttpSession session = req.getSession();
		long userId = (Long) session.getAttribute("userId");
		ReservationModel rm = new ReservationModel();
		rm.setDate(date2);
		rm.setDestination(destination);
		rm.setSource(source);
		rm.setNumSeats(numSeats);
		rm.setAvailableseats(availableseats);
		rm.setTrainNumber(trainNumber);
		try {
			BookTicketsService.bookTickets(rm, userId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
