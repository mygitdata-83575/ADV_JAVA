package com.sunbeam.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Guest;


public interface GuestDao extends JpaRepository<Guest, Long>{

	Optional<Guest> findByFirstName(String name);
	
}
