package com.flight.managing.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.managing.entity.Bookingentity;
import com.flight.managing.entity.Flightentity;
import com.flight.managing.exception.BookingUnauthorizedException;
import com.flight.managing.exception.Flightnotfoundexception;
import com.flight.managing.repository.Bookingrepo;

@Service
public class Bookingservice {
	@Autowired
	Bookingrepo bookingrepo;

	@Autowired
	Flightservice repo;

	public void save(Bookingentity f) {
		bookingrepo.save(f);
	}

	public List<Bookingentity> findAll() {

		return bookingrepo.findAll();
	}

	public Optional<Bookingentity> findbyId(Long id) {
		Optional<Bookingentity> f = bookingrepo.findById(id);

		if (f.isEmpty())
			return null;
		else
			return f;

	}

	public void delete(Long id) {
		bookingrepo.deleteById(id);
	}

	public Optional<Bookingentity> Deelete(Long id) {
		Optional<Bookingentity> f = bookingrepo.findById(id);

		if (f.isEmpty())
			return null;
		else {
			bookingrepo.Deelete(id);
			return f;
		}
	}

	public Bookingentity update(Bookingentity b) {
		Optional<Bookingentity> f = bookingrepo.findById(b.getId());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
		LocalDate date = LocalDate.parse(b.getBookingDate(), format);
		if (f.isPresent())
			return bookingrepo.save(b);
		else
			return null;
	}

	public Bookingentity getBooking(Bookingentity booking)
			throws BookingUnauthorizedException, ParseException, Flightnotfoundexception {
		// TODO Auto-generated method stub
		Optional<Flightentity> flightt = repo.findbyId(booking.getFlight().getNumber());
		Optional<Bookingentity> bookingIId = this.findbyId(booking.getTemp());

		// System.out.println("(((((((((((((((((((((((((((("+iid.toString());
		if (flightt == null || bookingIId == null)
			throw new BookingUnauthorizedException("Booking is not found");
		else {

			SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
			String date1 = booking.getFlight().getDateOfjourney();
			System.out.println("Inside the date  @@@@@@@@@@@ " + date1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			Date d = date.parse(date1);

			Date today = new Date();

			Calendar cal = Calendar.getInstance();

			Bookingentity bookingEntity = new Bookingentity();
			// bookingrepo
			if (today.compareTo(d) > 0) {

				bookingrepo.updateBooking(booking.getName(), booking.getAge(), booking.getBookingDate(),
						booking.getTemp());

			} else {
				throw new Flightnotfoundexception("Not able to update the details");
			}

			return null;
		}

	}
}
