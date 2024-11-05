package com.reservation.model;

import java.sql.Date;
import java.time.LocalDate;

public class Train{
	private int trainNumber;
	private String source;
	private String destination;
	private LocalDate schedule;
	private boolean isSeatsAvailable;
	private int noOfSeatsAvailable;
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public LocalDate getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDate schedule) {
		this.schedule = schedule;
	}
	public boolean isSeatsAvailable() {
		return isSeatsAvailable;
	}
	public void setSeatsAvailable(boolean isSeatsAvailable) {
		this.isSeatsAvailable = isSeatsAvailable;
	}
	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}
	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", source=" + source + ", destination=" + destination
				+ ", schedule=" + schedule + ", isSeatsAvailable=" + isSeatsAvailable + ", noOfSeatsAvailable="
				+ noOfSeatsAvailable + "]";
	}
	
	public Train() {}
	public Train(int trainNumber, String source, String destination, LocalDate schedule, boolean isSeatsAvailable,
			int noOfSeatsAvailable) {
		super();
		this.trainNumber = trainNumber;
		this.source = source;
		this.destination = destination;
		this.schedule = schedule;
		this.isSeatsAvailable = isSeatsAvailable;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	
}
