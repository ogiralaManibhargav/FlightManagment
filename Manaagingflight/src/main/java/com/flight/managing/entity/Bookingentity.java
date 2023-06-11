package com.flight.managing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Bookingentity")
public class Bookingentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String bookingDate;
	@Column

	private String status;
	
	@Transient
	private
	Long temp;

	@JsonBackReference
	// @MapsId
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Flightentity.class)

	@JoinColumn(name = "number") // foreign key
	private Flightentity flight;

	/**
	 * @return the bookingId
	 */

	/**
	 * @return the flight
	 */
	public Flightentity getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flightentity flight) {
		this.flight = flight;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the flightEntity
	 * 
	 *         /**
	 * @param flightEntity the flightEntity to set
	 */

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the noOfPassengers
	 */
	/*
	 * public int getNoOfPassengers() { return noOfPassengers; } /**
	 * 
	 * @param noOfPassengers the noOfPassengers to set
	 * 
	 * public void setNoOfPassengers(int noOfPassengers) { this.noOfPassengers =
	 * noOfPassengers; }
	 */

	/**
	 * @return the flight
	 * 
	 *         public Flightentity getFlight() { return flight; } /**
	 * @param flight the flight to set
	 * 
	 *               public void setFlight(Flightentity flight) { this.flight =
	 *               flight; }
	 */
	/**
	 * 
	 */
	public Bookingentity() {
		super();
		System.out.println("Inside the bookingentity");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param bookingDate
	 * @param status
	 * @param flightentity
	 */
	public Bookingentity(Long id, String name, int age, String bookingDate, String status, Flightentity flight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.bookingDate = bookingDate;
		this.status = status;
		this.flight = flight;

	}

	@Override
	public String toString() {
		return "Bookingentity [id=" + id + ", name=" + name + ", age=" + age + ", bookingDate=" + bookingDate
				+ ", status=" + status + ", flightentity=" + flight + "]";
	}

	public Long getTemp() {
		return temp;
	}

	public void setTemp(Long temp) {
		this.temp = temp;
	}

}
