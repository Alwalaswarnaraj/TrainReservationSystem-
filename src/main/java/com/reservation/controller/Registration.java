package com.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.User;
import com.reservation.service.RegistrationService;

public class Registration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("controller");
	User u = new User();
	u.setUserName(req.getParameter("username"));
	u.setPassword(req.getParameter("password"));
	u.setEmail(req.getParameter("email"));
	u.setRole(req.getParameter("role"));
	Timestamp date = new Timestamp(System.currentTimeMillis());
	u.setCreatedAt(date);
	try {
		boolean result = RegistrationService.doRegister(u);
		if(result) {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.println("failed to register");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
