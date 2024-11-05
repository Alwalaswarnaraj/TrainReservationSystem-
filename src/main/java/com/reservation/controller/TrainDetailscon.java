package com.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.model.Train;
import com.reservation.service.TrainDetails;

public class TrainDetailscon extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String source = (String) req.getParameter("source");
		String destination = (String) req.getParameter("destination");
		System.out.println(source);
		System.out.println(destination);
	
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			// Check if source and destination parameters are provided
			if (source == null || destination == null || source.isEmpty() || destination.isEmpty()) {
				out.println("<p>Please provide both source and destination.</p>");
				return;
			}

			List<Train> trains = TrainDetails.getDetails(source, destination);
			if (trains.isEmpty()) {
				out.println("<p>No trains available from " + source + " to " + destination + ".</p>");
			} else {
				req.setAttribute("trainList", trains);
				RequestDispatcher rd = req.getRequestDispatcher("trainList.jsp");
				rd.forward(req, resp);
			}

		} finally {
			// Close the PrintWriter
			out.close();
		}
//		out.println(source);
//		out.println(destination);
	}
}
