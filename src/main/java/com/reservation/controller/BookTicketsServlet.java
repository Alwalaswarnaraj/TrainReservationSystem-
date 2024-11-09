package com.reservation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
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
		System.out.println(date);
		LocalDate date2 = LocalDate.parse(date); // Convert String to Date
		System.out.println("Converted Date: " + date2);
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
		
		ReservationModel result = null;
		try {
			result = BookTicketsService.bookTickets(rm, userId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(result == null) {
			System.out.println("NUllll in controller");
		}else {
			
			session.setAttribute("reservationId", result.getReservationId());
			session.setAttribute("trainNumber", result.getTrainNumber());
			LocalDate date0 = result.getDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			String datestr = date.formatted(formatter);
			session.setAttribute("date",datestr);
			session.setAttribute("source", result.getSource());
			session.setAttribute("destination", result.getDestination());
			session.setAttribute("seats", result.getNumSeats());
			session.setAttribute("name", result.getUserName());
			
			RequestDispatcher rd = req.getRequestDispatcher("ConfirmTickets.jsp");
			rd.forward(req, resp);
		}
	}
}
