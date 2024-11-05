package com.reservation.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reservation.model.Train;

public class GetTrainDetails {
	public static List<Train> getTrainDetails(String source, String destination) throws SQLException, ClassNotFoundException {
		List<Train> trainDetails = new ArrayList<Train>();
		String query = "Select * from train where source = ? and destination = ?";
		Connection con = ConnectionClass.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, source);
		pst.setString(2, destination);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Train a = new Train();
			a.setTrainNumber(rs.getInt("trainNumber"));
			a.setSource(rs.getString("source"));
			a.setDestination(rs.getString("destination"));
			a.setSchedule(rs.getDate("schedule").toLocalDate());
			a.setSeatsAvailable(true);
			a.setNoOfSeatsAvailable(rs.getInt("noOfseatedAvailable"));
			trainDetails.add(a);
		}
		return trainDetails;
	}
}
