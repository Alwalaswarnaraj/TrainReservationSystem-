package com.reservation.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reservation.model.ReservationModel;
import com.reservation.service.BookTicketsService;

public class BookTicketsRepo {
	public static ReservationModel bookTickets(ReservationModel rm, long userId) throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionClass.getConnection()) {
        	System.out.println(1);
            // 1. Check availability of seats and schedule
            String checkSeatsQuery = "SELECT noOfseatedAvailable, schedule FROM train WHERE trainNumber = ?";
            try (PreparedStatement pst = con.prepareStatement(checkSeatsQuery)) {
            	System.out.println(2);
                pst.setInt(1, rm.getTrainNumber());
                ResultSet rs = pst.executeQuery();

                int availableSeats = 0;
                Date scheduleDate = null;

                if (rs.next()) {
                    availableSeats = rs.getInt("noOfseatedAvailable");
                    scheduleDate = rs.getDate("schedule");
                    System.out.println("avail: "+availableSeats);
                }
                if (availableSeats >= rm.getNumSeats()) {
                	System.out.println(4);
                	Boolean res = updateTrainSeatsAvailable(availableSeats, rm.getNumSeats(),rm);
                	System.out.println(res);
                	if(res) {
                		System.out.println(6);
                		System.out.println("update on the trainSeats");
                		String userName = getUserName(userId);
                		
                		boolean out = InsertIntoReservation(rm, userName, scheduleDate, userId);
                		System.out.println(userName+" username");
                		if(out) {
                			System.out.println("into insert");
                			String query = "select * from reservations where trainNumber = ?";
                			PreparedStatement psts = con.prepareStatement(query);
                			System.out.println(rm.getTrainNumber());
                			psts.setInt(1, rm.getTrainNumber());
                			ResultSet result = psts.executeQuery();
                			System.out.println(result);
//                			result.next();
                			if(result.next()) {
//                				rs.next();
                				System.out.println("sawa");
                				ReservationModel rem = new ReservationModel();
                				rem.setUserName(result.getString("userName"));
                				rem.setReservationId(result.getString("reservationId"));
                				rem.setSource(result.getString("source"));
                				rem.setDestination(result.getString("destination"));
                				rem.setNumSeats(result.getInt("seatNumbers"));
                				rem.setDate(result.getDate("schedule").toLocalDate());
                				rem.setTrainNumber(result.getInt("TrainNumber"));
                				System.out.println("completed insert");
                				return rem;
                			}
                		}return null;
                	}return null;
                }return null;
        }catch(SQLException e) {
        	e.printStackTrace();
        	}
        }
		return null;
	}



	public static boolean updateTrainSeatsAvailable(int available, int seatsbooked, ReservationModel rm)
			throws SQLException, ClassNotFoundException {
		System.out.println(5);
		String updateSeatsQuery = "UPDATE train SET noOfseatedAvailable = ? WHERE trainNumber = ?";
		Connection con = ConnectionClass.getConnection();
		
		PreparedStatement pst2 = con.prepareStatement(updateSeatsQuery);
			int remainingSeats = available - seatsbooked;
			pst2.setInt(1, remainingSeats);
			pst2.setInt(2, rm.getTrainNumber());
			int out = pst2.executeUpdate();
			System.out.println(out+" "+111);
		if (out>0) {
			System.out.println(out);
			return true;
		}
		return false;
	}

	public static String getUserName(long userId) throws ClassNotFoundException, SQLException {
		String userName = null;
		Connection con = ConnectionClass.getConnection();
		String getUserQuery = "SELECT userName FROM user WHERE userId = ?";
		PreparedStatement pst3 = con.prepareStatement(getUserQuery);
			pst3.setLong(1, userId);
			ResultSet userResult = pst3.executeQuery();
			if (userResult.next()) {
				userName = userResult.getString("userName");
			}return userName;
	}

	public static boolean InsertIntoReservation(ReservationModel rm, String userName, Date scheduleDate, long userId)
			throws ClassNotFoundException, SQLException {
		String insertReservationQuery = "INSERT INTO reservations "
				+ "(userId, TrainNumber, seatNumbers, status, userName, schedule, source, destination) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = ConnectionClass.getConnection();
		PreparedStatement pst4 = con.prepareStatement(insertReservationQuery);
		pst4.setLong(1, userId);
		pst4.setInt(2, rm.getTrainNumber());
		pst4.setInt(3, rm.getNumSeats());
		pst4.setBoolean(4, true); // assuming 'true' means reservation success
		pst4.setString(5, userName);
		pst4.setDate(6, scheduleDate);
		pst4.setString(7, rm.getSource());
		pst4.setString(8, rm.getDestination());

		boolean out = pst4.execute();
		if (out) {
			return true;
		}
		return true;
	}
}
