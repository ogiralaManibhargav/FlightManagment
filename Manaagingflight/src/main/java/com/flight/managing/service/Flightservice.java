package com.flight.managing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.managing.entity.Bookingentity;
import com.flight.managing.entity.Flightentity;
import com.flight.managing.exception.Flightnotfoundexception;
import com.flight.managing.model.Flight;
import com.flight.managing.repository.Flightrepo;

@Service
public class Flightservice {

	@Autowired
	Flightrepo flightrepo;

	public void save(Flightentity f) {

		flightrepo.save(f);
	}

	public List<Flightentity> findAll() {
		return flightrepo.findAll();
	}

	public Optional<Flightentity> findbyId(Long id) {
		Optional<Flightentity> f = flightrepo.findById(id);
		System.out.println(f);

		if (f == null)
			return null;
		else
			return f;

	}

	public List<Flightentity> getflightsbySource(String query) throws Flightnotfoundexception {

		List<Flightentity> flist = flightrepo.findByKeyword(query);

		if (flist.isEmpty()) {
			throw new Flightnotfoundexception("Flight not found");
		}
		return flist;
	}

	public List<Flightentity> getflightsbydestination(String query) throws Flightnotfoundexception {

		List<Flightentity> flist = flightrepo.findBydestination(query);
		if (flist.isEmpty()) {
			throw new Flightnotfoundexception("Flight not found");
		}
		return flist;
	}

	public Optional<Flightentity> Deelete(Long id) throws Flightnotfoundexception {
		System.out.println(id + " ddd#######################################");
		Optional<Flightentity> f = flightrepo.findById(id);

		if (f.isEmpty())
			throw new Flightnotfoundexception("Flight not found");
		else {

			flightrepo.Deelete(id);
			return f;
		}
	}

}
