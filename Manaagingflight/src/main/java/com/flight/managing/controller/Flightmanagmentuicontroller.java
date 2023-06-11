package com.flight.managing.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flight.managing.entity.Bookingentity;
import com.flight.managing.entity.Flightentity;
import com.flight.managing.exception.BookingUnauthorizedException;
import com.flight.managing.exception.Flightnotfoundexception;
import com.flight.managing.service.Bookingservice;
import com.flight.managing.service.Flightservice;

@Controller
public class Flightmanagmentuicontroller {
	@Autowired
	Flightservice flightservice;

	@Autowired
	Bookingservice bookingservice;

	@GetMapping("rest/Allflights")
	public ModelAndView getAllflights() {
		List<Flightentity> f = flightservice.findAll();
		ModelAndView m = new ModelAndView();
		m.addObject("Flight", f);
		m.setViewName("FlightList");
		return m;
	}

	@GetMapping("rest/registeringFlight")
	public ModelAndView registeringFlight() {
		return new ModelAndView("Registering");
	}

	@GetMapping("rest/saveFlightdetails")
	public ModelAndView saveFlightdetails(Flightentity f) {
		f.setStatus("Active");
		flightservice.save(f);
		return new ModelAndView("SavedSucessfully");
	}

	@GetMapping("rest/bysource/*")
	public ModelAndView getAllflightsbysource(@RequestParam(name = "findbysrc") String source)
			throws Flightnotfoundexception {
		List<Flightentity> f = flightservice.getflightsbySource(source);
		ModelAndView m = new ModelAndView();
		if (f.isEmpty()) {
			m.setViewName("Error");
		}

		m.addObject("Flight", f);
		m.setViewName("FlightList");
		return m;
	}

	@GetMapping("rest/bydestination/*")
	public ModelAndView getAllflightsbydestination(@RequestParam(name = "findbydestiny") String destination)
			throws Flightnotfoundexception {
		List<Flightentity> f = flightservice.getflightsbydestination(destination);
		ModelAndView m = new ModelAndView();
		if (f.isEmpty()) {
			m.setViewName("Error");
		}
		m.addObject("Flight", f);
		m.setViewName("FlightList");
		return m;
	}

	@GetMapping("rest/deleteflight/*")
	public ModelAndView deleteflight(@RequestParam(name = "flight") String flight) throws Flightnotfoundexception {

		Long bookingno1 = Long.parseLong(flight);
		flightservice.Deelete(bookingno1);
		ModelAndView m = new ModelAndView();
		m.setViewName("Deletedsucessfully");
		return m;

	}

	@GetMapping("rest/deelete")
	public ModelAndView delete() {
		ModelAndView m = new ModelAndView();
		m.setViewName("Delete");
		return m;
	}

	@PostMapping("rest/saveflights")
	public String saveFlights(Flightentity f, Model m) {
		flightservice.save(f);
		return "SavedSucessfuly";
	}

	@GetMapping("rest/find")
	public ModelAndView Index() {
		ModelAndView m = new ModelAndView();
		m.setViewName("Find");
		return m;
	}

	@GetMapping({ "/rest/BookingFlight" })
	public ModelAndView Bookking() {
		List<Flightentity> f = flightservice.findAll();
		System.out.println(f);

		ModelAndView m = new ModelAndView();
		m.addObject("Flight", f);
		m.addObject("booking", new Bookingentity());
		m.setViewName("Rough");

		return m;

	}

	@PostMapping("rest/saveBookinggs") // change to post
	public String saveBooking(@ModelAttribute Bookingentity b)
	{
		b.setStatus("Active");

		// b.setStatus("Active");
		bookingservice.save(b);

		return "Booking is saved sucessfully";
	}

	@GetMapping("rest/AllBookinggs")
	public ModelAndView getAllBookings() {
		List<Bookingentity> b = bookingservice.findAll();
		System.out.println("list ssssssssssss" + b);
		ModelAndView m = new ModelAndView();
		if (b.isEmpty()) {
			m.setViewName("Error");
			return m;
		}
		m.addObject("Booking", b);
		m.setViewName("BookingList");
		return m;
	}

	@GetMapping("rest/deeleteBooking")
	public ModelAndView deleteBooking() {
		ModelAndView m = new ModelAndView();
		m.setViewName("DeleteBooking");
		return m;
	}

	@GetMapping("rest/deleteBookinng/*")
	public String deleteBoooking(@RequestParam(name = "booking") String booking) {
		Long l = Long.parseLong(booking);
		bookingservice.Deelete(l);
		return "Booking_deleted";
	}
//	deleteBookinng

	@GetMapping("rest/rough")
	public ModelAndView rough() {
		return new ModelAndView("NewFile");
	}

	@GetMapping({ "/rest/udpateBookingdetails" })
	public ModelAndView udpateBookingdetails() {
		List<Flightentity> f = flightservice.findAll();
		System.out.println(f);

		ModelAndView m = new ModelAndView();
		m.addObject("Flight", f);
		m.addObject("booking", new Bookingentity());
		m.setViewName("Update");

		return m;

	}

	@PostMapping("rest/editbooking")
	public ModelAndView updateBooking(@ModelAttribute Bookingentity booking)
			throws BookingUnauthorizedException, ParseException, Flightnotfoundexception {

		bookingservice.getBooking(booking);
		return new ModelAndView("SavedSucessfully");
	}

}
