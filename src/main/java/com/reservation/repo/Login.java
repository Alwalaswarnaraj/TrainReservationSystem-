package com.reservation.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public static long login(String name, String password) throws SQLException, ClassNotFoundException {
		String getUserId = "select userId from user where userName = ?";
		Connection con = ConnectionClass.getConnection();
		PreparedStatement pst ;
		pst = con.prepareStatement(getUserId);
		pst.setString(1,name);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			long userId = rs.getLong("userId");
			
			String check ="select password from passwords where userId = ?";
			pst = con.prepareStatement(check);
			pst.setLong(1, userId);
			ResultSet r = pst.executeQuery();
			if(r.next()) {
				String retrivedPassword = r.getString("password");
				
				if(retrivedPassword.equals(password)) {
					return userId;
				}else{
					return 0;
				}
			}
		}
		return 0;
	}
}
