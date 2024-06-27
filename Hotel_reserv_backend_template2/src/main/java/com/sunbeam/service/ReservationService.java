package com.sunbeam.service;

import com.sunbeam.dto.ResrvationReqDTO;
import com.sunbeam.entities.Reservation;

//1.Create Reservation:
//•	Endpoint: POST /reservations
//•	Request:JSON payload containing reservation details (guest name, check-in date, check-out date, room ID).
//•	Response: Confirmation of the created reservation.

//3.	Cancel Reservation:
//•	Endpoint: DELETE /reservations/{reservationId}
//•	Request : Cancel a reservation by providing its unique identifier.
//•	Response: Confirmation of the canceled reservation.

public interface ReservationService {
	
	public String createReservation(ResrvationReqDTO dto);
	
	public String cancelReservation(Long resrvationId);
	
}
