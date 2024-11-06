package com.reservation.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reservation.model.ReservationModel;
import com.reservation.repo.BookTicketsRepo;
import com.reservation.repo.ConnectionClass;

public class BookTicketsService {
	public static  ReservationModel bookTickets(ReservationModel rm, long userId) throws ClassNotFoundException, SQLException {
		ReservationModel result =  BookTicketsRepo.bookTickets(rm, userId);
		if(result == null) {
			return null;
		}return result;
	}
}
