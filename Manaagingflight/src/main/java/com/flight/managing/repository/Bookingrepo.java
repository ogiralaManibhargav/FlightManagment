package com.flight.managing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.managing.entity.Bookingentity;
import com.flight.managing.model.Booktickets;

@Repository
public interface Bookingrepo extends JpaRepository<Bookingentity, Long> {
	void save(Booktickets f);

	@Transactional
	@Modifying
	@Query("UPDATE Bookingentity f set f.status='INACTIVE' where f.id = ?1 ")
	void Deelete(Long id);

	@Transactional
	@Modifying
	@Query("UPDATE Bookingentity f set f.status='INACTIVE' where f.id = ?1 ")
	void insert(Bookingentity b);

	@Transactional
	@Modifying
	@Query("update Bookingentity u set  u.status='Active' ,u.name = ?1 , u.age = ?2 , u.bookingDate = ?3 where u.id = ?4")
	void updateBooking(String name, int age, String bookingDate, Long id);

	// @Query("SELECT f Bookingentity f where f.id = ?1")

}
