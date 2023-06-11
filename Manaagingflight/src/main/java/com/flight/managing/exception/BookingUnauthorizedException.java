package com.flight.managing.exception;

public class BookingUnauthorizedException extends Exception {

	/**
	 * @param message
	 */
	public BookingUnauthorizedException(String message) {
		super(message);
		 System.out.println("Booking with the id is not found");
		
		// TODO Auto-generated constructor stub
	}
	
     

}
