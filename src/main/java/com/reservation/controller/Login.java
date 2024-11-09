package com.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class Login extends HttpServlet {
	{
		System.out.println("swarnarak");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
//		System.out.println(name+" "+password);
		PrintWriter out = resp.getWriter();
		
		try {
			long userId = ConLogin.login(name, password);
			if(userId != 0){
			req.setAttribute("name", name);
			req.setAttribute("password", password);
			HttpSession session = req.getSession();
			session.setAttribute("userId", userId);
			System.out.println("session: "+userId);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("loginFailed.jsp");
			rd.forward(req, resp);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
