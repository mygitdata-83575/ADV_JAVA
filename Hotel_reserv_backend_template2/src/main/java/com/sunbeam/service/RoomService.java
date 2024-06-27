package com.sunbeam.service;

import java.time.LocalDate;

import com.sunbeam.dto.RoomResDto;

//1.	Create Reservation:
//•	Endpoint: POST /reservations
//•	Request:JSON payload containing reservation details (guest name, check-in date, check-out date, room ID).
//•	Response: Confirmation of the created reservation.

public interface RoomService {
//	CategoryPostDTO getCategoryAndPostDetails(Long categoryId);
	
	RoomResDto getRoomDetails(LocalDate date); 
	
}
