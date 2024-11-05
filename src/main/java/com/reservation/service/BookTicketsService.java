package com.reservation.service;

import java.sql.SQLException;

import com.reservation.model.ReservationModel;
import com.reservation.repo.BookTicketsRepo;

public class BookTicketsService {
	public static void bookTickets(ReservationModel rm, long userId) throws ClassNotFoundException, SQLException {
		BookTicketsRepo.bookTickets(rm, userId);
	}
}
