package com.reservation.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/trainreservation";
		String dbname = "root";
		String dbpass = "swarna@08";
		Connection con = DriverManager.getConnection(url, dbname, dbpass);
		return con;
	}
}	
