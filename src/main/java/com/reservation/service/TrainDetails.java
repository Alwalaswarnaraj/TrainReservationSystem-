package com.reservation.service;

import java.sql.SQLException;
import java.util.List;

import com.reservation.model.Train;
import com.reservation.repo.GetTrainDetails;

public class TrainDetails {
	public static List<Train> getDetails(String source, String destination)  {
		List<Train> trains =null;
		try {
			trains = GetTrainDetails.getTrainDetails(source, destination);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		for(Train t: trains) {
			System.out.println(t);
		}
		return trains;
	}
}
