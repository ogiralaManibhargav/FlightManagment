package com.flight.managing.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;


public class Flight {

	
	
	private Long flightNo;
	private String carrierName;
	private String flightModel;
	private Long seatCapacity;
	private String source;
	  @Value("Active")
	private String status;
	  
	  
	  

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfjourney() {
		return dateOfjourney;
	}

	public void setDateOfjourney(String dateOfjourney) {
		this.dateOfjourney = dateOfjourney;
	}
	private String destination;
	
	private String dateOfjourney;
	/**
	 * @return the flightNo
	 */
	public Long getFlightNo() {
		return flightNo;
	}
	
	
	
	public void setFlightNo(Long flightNo) {
		this.flightNo = flightNo;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
	public String getFlightModel() {
		return flightModel;
	}
	
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	
	public Long getSeatCapacity() {
		return seatCapacity;
	}
	
	public void setSeatCapacity(Long seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	public Flight(Long flightNo, String carrierName, String flightModel, Long seatCapacity, String source,
			String destination, String dateOfjourney) {
		super();
		this.flightNo = flightNo;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
		this.source = source;
		this.destination = destination;
		this.dateOfjourney = dateOfjourney;
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
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + ", source=" + source + ", destination=" + destination
				+ ", dateOfjourney=" + dateOfjourney + "]";
	}
	
	
	
}
