package com.reservation.controller;

import java.sql.SQLException;

import com.reservation.repo.Login;

public class ConLogin {
	
	public static long login(String name, String password) throws SQLException {
		long userId= 0;
		try {
			userId = Login.login(name, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}
}
