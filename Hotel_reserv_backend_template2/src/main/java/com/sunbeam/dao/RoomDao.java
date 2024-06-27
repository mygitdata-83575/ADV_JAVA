package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.jpa.repository.JpaRepository;
//2.	Get Available rooms on given check in date
//•	Endpoint: GET /rooms/available/{checkInDate}
//•	Request: Get all available rooms on given date
//•	Response: Return the details of available rooms in JSON format.


import com.sunbeam.entities.Room;

import com.sunbeam.entities.Reservation;

public interface RoomDao extends JpaRepository<Room,Long> {
//	@Query("select c from Category c left join fetch c.posts where c.id=:id")
//	Optional<Category> getCategoryAndPosts(Long id);
//	 List<Room> findAllByAvailability(Reservation.getCheckInDate());
	
	@Query("select r from room r join fetch r.reservation where r.checkInDate=:date")
	Room getAvlRoom(LocalDate date);
}
