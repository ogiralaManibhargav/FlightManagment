package com.flight.managing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.managing.entity.Flightentity;
import com.flight.managing.model.Flight;

@Repository
public interface Flightrepo extends JpaRepository<Flightentity, Long> {

	void save(Flight f);

	@Query("SELECT f FROM Flightentity f WHERE f.source LIKE %?1%")
	List<Flightentity> findByKeyword(String source);

	@Query("SELECT f FROM Flightentity f WHERE f.destination LIKE %?1%")
	List<Flightentity> findBydestination(String destination);

	@Transactional
	@Modifying
	@Query("UPDATE Flightentity f set f.status='INACTIVE' where f.number = ?1 ")
	void Deelete(Long id);

	

}
