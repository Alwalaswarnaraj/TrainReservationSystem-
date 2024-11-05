package com.reservation.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.reservation.model.ReservationModel;

public class BookTicketsRepo {
	public static int bookTickets(ReservationModel rm, long userId) throws ClassNotFoundException, SQLException {
		try(Connection con = ConnectionClass.getConnection()) {
			String seatsAvaliable = "Select noOfseatedAvailable,schedule from train where trainNumber = ?";
			PreparedStatement pst = con.prepareStatement(seatsAvaliable);
			pst.setInt(1,rm.getTrainNumber());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				int availableseats = rs.getInt("noOfseatedAvailable");
				Date date = rs.getDate("schedule");
				if(availableseats > rm.getNumSeats()) {
					 String updateSeatsQuery = "UPDATE train SET noOfseatedAvailable = ? WHERE trainNumber = ?";
	                    PreparedStatement pst2 = con.prepareStatement(updateSeatsQuery);
	                    int remainingSeats = availableseats - rm.getNumSeats();
	                    System.out.println(availableseats);
	                    System.out.println(rm.getTrainNumber());
	                    pst2.setInt(1, remainingSeats);
	                    pst2.setInt(2, rm.getTrainNumber());
	                    long result = pst2.executeUpdate();
	                    if(result>0) {
	                    	String query = "select userName from user where userId = userId";
	                    	System.out.println(userId);
//	                    	Statement pst3 = con.prepareStatement(query);
	                    	Statement pst3 = con.createStatement();
	                    	ResultSet res = pst3.executeQuery(query);
	                    	if(res.next()) {
	                    		String userName = res.getString("userName");
	                    		System.out.println(userName);
	                    		String insertIntoReserv = "insert into reservations (userId, TrainNumber, seatNumbers, status, userName, schedule, source, destination) values (?, ?, ?, ?, ?, ?, ?,?)";
	                    		PreparedStatement pst4 = con.prepareStatement(insertIntoReserv);
	                    		pst4.setLong(1, userId);
	                    		pst4.setInt(2, rm.getTrainNumber());
	                    		pst4.setInt(3, rm.getNumSeats());
	                    		pst4.setBoolean(4, true);
	                    		pst4.setString(5, userName);
	                    		pst4.setDate(6, Date.valueOf(rm.getDate()));
	                    		pst4.setString(7, rm.getSource());
	                    		pst4.setString(8, rm.getDestination());
	                    		pst4.execute();
	                    	}
	                    }
	                    return rm.getNumSeats();
				}else {
					return availableseats;
				}
			}return rm.getTrainNumber();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
