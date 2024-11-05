package com.reservation.service;

import java.sql.SQLException;

import com.reservation.model.User;
import com.reservation.repo.RegistrationRepo;

public class RegistrationService {
	public static boolean doRegister(User u) throws ClassNotFoundException, SQLException {
		System.out.println("service");
		boolean result =RegistrationRepo.doRegister(u);
		return result;
	}
}
