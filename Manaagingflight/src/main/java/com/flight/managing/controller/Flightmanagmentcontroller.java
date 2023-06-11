package com.flight.managing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.managing.entity.Bookingentity;
import com.flight.managing.entity.Flightentity;
import com.flight.managing.exception.Flightnotfoundexception;
import com.flight.managing.model.Booktickets;
import com.flight.managing.repository.Bookingrepo;
import com.flight.managing.repository.Flightrepo;

@RestController
@CrossOrigin("*")
public class Flightmanagmentcontroller {

	@Autowired
	Flightrepo flightrepo;
	@Autowired
	Bookingrepo bookingrepo;

	@GetMapping("/")
	public String Hello() {
		return "Helloworld";
	}

	@PostMapping("/Addflight")
	public void addFlight(@RequestBody Flightentity f) {
		f.setStatus("Active");

		flightrepo.save(f);
	}

	@GetMapping("/findallflights")
	public ResponseEntity<List<Flightentity>> viewAll() {
		return ResponseEntity.ok(flightrepo.findAll());
	}

	@GetMapping("/findbyId/{flightNo}")
	public ResponseEntity<Optional<Flightentity>> viewbyId(@PathVariable String flightNo) {

		Long flightNo1 = Long.parseLong(flightNo);
		return ResponseEntity.ok(flightrepo.findById(flightNo1));
	}

	@GetMapping("/Search/source={source}")

	public ResponseEntity<List<Flightentity>> Search(@PathVariable String source) {

		return ResponseEntity.ok(flightrepo.findByKeyword(source));
	}

	@GetMapping("/Search/destination={destination}")

	public ResponseEntity<List<Flightentity>> Searchbydestiny(@PathVariable String destination) {

		return ResponseEntity.ok(flightrepo.findBydestination(destination));
	}

	@PostMapping("/Addbooking")
	public void addBooking(@RequestBody Bookingentity b) {
		bookingrepo.save(b);
	}

	@GetMapping("/findallbooking")
	public ResponseEntity<List<Bookingentity>> viewAllbooking() {
		return ResponseEntity.ok(bookingrepo.findAll());
	}

	@GetMapping("/findbybookingId/{bookingno}")
	public ResponseEntity<Optional<Bookingentity>> viewbybookingId(@PathVariable String bookingno) {
		Long bookingno1 = Long.parseLong(bookingno);
		return ResponseEntity.ok(bookingrepo.findById(bookingno1));
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBooking(@PathVariable String id) {

		Long bookingno1 = Long.parseLong(id);
		bookingrepo.Deelete(bookingno1);

	}

	@DeleteMapping("/deleteflight/{id}")
	public void deleteflight(@PathVariable String id) {

		Long bookingno1 = Long.parseLong(id);
		flightrepo.Deelete(bookingno1);

	}

	@PutMapping("/udpdate")
	public void updateBookingdetails(@RequestBody Booktickets tickets) {

		bookingrepo.save(tickets);
	}

	@PutMapping("/flight/{id}")
	public ResponseEntity<Flightentity> updateFlight(@PathVariable Long id, @RequestBody Flightentity flightEntity)
			throws Flightnotfoundexception {
		Flightentity f = flightrepo.findById(id)
				.orElseThrow(() -> new Flightnotfoundexception("The id is not present" + id));
		flightEntity.setNumber(id);
		flightEntity.setStatus("Active");
		Flightentity f1 = flightrepo.save(flightEntity);
		return ResponseEntity.ok(f1);

	}

}
