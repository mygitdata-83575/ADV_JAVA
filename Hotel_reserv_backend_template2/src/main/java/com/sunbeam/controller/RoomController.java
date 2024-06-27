package com.sunbeam.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	public RoomController() {
		System.out.println("in ctor" + getClass());
	}
	
	@GetMapping ("{/date}")
	public ResponseEntity<?> getRoomDetails(@PathVariable LocalDate date){
		System.out.println(" in get room " + date);
		try {
			return ResponseEntity.ok(roomService.getRoomDetails(date));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
	}
	
}
