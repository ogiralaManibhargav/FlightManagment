package com.flight.managing.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="Flightentity")
public class Flightentity {
	
	//String search;
	     @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	     @Column
		private Long number;
	     @Column
		private String carrierName; 
	     @Column
		private String flightModel;
	     @Column
		private Long seatCapacity;
		/**
		 * @return the flightNo 
		 */
	     @Column
	     private String source;
	     @Column
	 	private String destination;
	     
	     @Column
	     private String dateOfjourney;
	     
	     @Column

	     private String status;
	     
	     @Transient
	     @JsonIgnore
	     int temp=0;
	     
	     
	     
	     @JsonManagedReference
	     @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
	     private List<Bookingentity> booking; 
	 
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}


		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		} 
		

/**
		 * @param number
		 * @param carrierName
		 * @param flightModel
		 * @param seatCapacity
		 * @param source
		 * @param destination
		 * @param dateOfjourney
		 * @param status
		 * @param booking
		 */
	/*	public Flightentity(Long number, String carrierName, String flightModel, Long seatCapacity, String source,
				String destination, String dateOfjourney, String status) {
			super();
			this.number = number;
			this.carrierName = carrierName;
			this.flightModel = flightModel;
			this.seatCapacity = seatCapacity;
			this.source = source;
			this.destination = destination;
			this.dateOfjourney = dateOfjourney;
			this.status = status;
			//this.booking = booking;
		}
*/


		
	
		/**
		 * @return the dateOfjourney
		 */
		public String getDateOfjourney() {
			return dateOfjourney;
		}


		/**
 * @param number
 * @param carrierName
 * @param flightModel
 * @param seatCapacity
 * @param source
 * @param destination
 * @param dateOfjourney
 * @param status
 * @param booking
 */
public Flightentity(Long number, String carrierName, String flightModel, Long seatCapacity, String source,
		String destination, String dateOfjourney, String status, List<Bookingentity> booking) {
	super();
	this.number = number;
	this.carrierName = carrierName;
	this.flightModel = flightModel;
	this.seatCapacity = seatCapacity;
	this.source = source;
	this.destination = destination;
	this.dateOfjourney = dateOfjourney;
	this.status = status;
	this.booking = booking;
}



		/**
		 * @param number
		 * @param carrierName
		 * @param flightModel
		 * @param seatCapacity
		 * @param source
		 * @param destination
		 * @param dateOfjourney
		 * @param status
		 */
		public Flightentity(Long number, String carrierName, String flightModel, Long seatCapacity, String source,
				String destination, String dateOfjourney, String status) {
			super();
			this.number = number;
			this.carrierName = carrierName;
			this.flightModel = flightModel;
			this.seatCapacity = seatCapacity;
			this.source = source;
			this.destination = destination;
			this.dateOfjourney = dateOfjourney;
			this.status = status;
		}


		/**
		 * @param dateOfjourney the dateOfjourney to set
		 */
		public void setDateOfjourney(String dateOfjourney) {
			this.dateOfjourney = dateOfjourney;
		}


		


		


		@Override
		public String toString() {
			return "Flightentity [number=" + number + ", carrierName=" + carrierName + ", flightModel=" + flightModel
					+ ", seatCapacity=" + seatCapacity + ", source=" + source + ", destination=" + destination
					+ ", dateOfjourney=" + dateOfjourney + ", status=" + status + ", booking="  + "]";
		}


		/**
		 * @return the source
		 */
		public String getSource() {
			return source;
		}


		/**
		 * @param source the source to set
		 */
		
		public void setSource(String source) {
			this.source = source;
		}


		/**
		 * @return the destination
		 */
		public String getDestination() {
			return destination;
		}


		/**
		 * @param destination the destination to set
		 */
		public void setDestination(String destination) {
			this.destination = destination;
		}


		
		/**
		 * @return the number
		 */
		public Long getNumber() {
			return number;
		}


		/**
		 * @param number the number to set
		 */
		public void setNumber(Long number) {
			this.number = number;
		}


		/**
		 * @return the booking
		 */
		


		/**
		 * @param booking the booking to set
		 */
		


		/**
		 * @return the carrierName
		 */
		public String getCarrierName() {
			return carrierName;
		}
		/**
		 * @param carrierName the carrierName to set
		 */
		public void setCarrierName(String carrierName) {
			this.carrierName = carrierName;
		}
		/**
		 * @return the flightModel
		 */
		public String getFlightModel() {
			return flightModel;
		}
		/**
		 * @param flightModel the flightModel to set
		 */
		public void setFlightModel(String flightModel) {
			this.flightModel = flightModel;
		}
		/**
		 * @return the seatCapacity
		 */
		public Long getSeatCapacity() {
			return seatCapacity;
		}
		/**
		 * @param seatCapacity the seatCapacity to set
		 */
		public void setSeatCapacity(Long seatCapacity) {
			this.seatCapacity = seatCapacity;
		}
	
		
		public Flightentity() {
			super();
			// TODO Auto-generated constructor stub
		}


		
		
	}



