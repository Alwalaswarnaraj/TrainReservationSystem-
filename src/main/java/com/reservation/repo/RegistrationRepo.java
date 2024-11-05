package com.reservation.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.reservation.model.User;

public class RegistrationRepo {
	public static boolean doRegister(User user) throws SQLException, ClassNotFoundException {
		System.out.println("repo");
		String queryInsertIntoUser = "insert into user(userName, emailId, role, createed_at) values(?, ?, ?, ?)";
		Connection con = ConnectionClass.getConnection();
		PreparedStatement pst = null;
		pst = con.prepareStatement(queryInsertIntoUser);
		System.out.println(user.getUserName());
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getRole());
		pst.setTimestamp(4, user.getCreatedAt());
//		System.out.println(user.getPassword());
		int in = pst.executeUpdate();
		System.out.println(in);
		if(in > 0) {
			String getDeatils = "select userId from user where userName = ?";
			pst = con.prepareStatement(getDeatils);
			pst.setString(1, user.getUserName());
			ResultSet r =pst.executeQuery();
			long usrID = 0;
			if(r.next()) {
				usrID = r.getLong("userId");
				System.out.println(usrID);
			}
			String insertIntoPasswords = "insert into passwords (userId, password, userName, emailId) values (?,?,?,?)";
			PreparedStatement ps ;
			 ps = con.prepareStatement(insertIntoPasswords);	         
	            ps.setLong(1, usrID);
//	            System.out.println(usrID);
//	            System.out.println(user.getPassword());
	            ps.setString(2, user.getPassword());
//	            System.out.println(user.getUserName());
	            ps.setString(3, user.getUserName());
//	            System.out.println(user.getEmail());
	            ps.setString(4, user.getEmail());
			int result = ps.executeUpdate();
			System.out.println(result);
			if(result>0) {
				return true;
			}else {
				String deleteQuery = "delete from user where userId = "+usrID;
				Statement st = con.createStatement();
				st.execute(deleteQuery);
			}
		}
		return false;
	}
}
