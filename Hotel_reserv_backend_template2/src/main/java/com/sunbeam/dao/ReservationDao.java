package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long>{

}
