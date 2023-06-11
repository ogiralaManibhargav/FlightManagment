package com.flight.managing.model;

import org.springframework.beans.factory.annotation.Value;

public class Booktickets {
	
	private Long bookingId;
	
	private String name;
	
	private int age;
	
	private String bookingDate;
	@Value("Active")
	private String status;
	
	private Long number;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	
	

	

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Booktickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booktickets(Long bookingId, String name, int age, String bookingDate, String status, Long number) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.age = age;
		this.bookingDate = bookingDate;
		this.status = status;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Booktickets [bookingId=" + bookingId + ", name=" + name + ", age=" + age + ", bookingDate="
				+ bookingDate + ", noOfPassengers="  + "]";
	}
	
	


}
