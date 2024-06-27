package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ResrvationReqDTO;
import com.sunbeam.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController{
	
	@Autowired
	private ReservationService reservationService;

	public ReservationController() {
		System.out.println("in ctor " + getClass());
	
	}
	@PostMapping
	public ResponseEntity<?> addReservation (@RequestBody ResrvationReqDTO dto){
		System.out.println("in add reservation "+ dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(reservationService.createReservation(dto));
			
		}
		catch(RuntimeException e){
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
			
		}
	
	}
	
	@DeleteMapping("/{resId}")
	public ResponseEntity <?> deleteReservation(@PathVariable Long resId){
		System.out.println("in delete" + resId);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(reservationService.cancelReservation(resId));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
}