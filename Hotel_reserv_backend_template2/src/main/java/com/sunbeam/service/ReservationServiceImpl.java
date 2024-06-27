package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ResrvationReqDTO;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
	private ReservationDao reservationDao;	
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	
	private GuestDao guestDao;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	
	public String createReservation(ResrvationReqDTO dto) {
		Guest guest = guestDao.findByFirstName(dto.getGuestName())
				  .orElseThrow(()->
				  new ResourceNotFoundException("Invalid Guest Name !!!!"));
		
		Room room = roomDao.findById(dto.getRoomId())
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Room ID !!!!"));
		
		Reservation reserv = mapper.map(dto, Reservation.class);
		
		reserv.setRoom(room);
		reserv.setGuest(guest);
		
		Reservation reservation = reservationDao.save(reserv);
		return "Reservation created";
	}


	@Override
	public String cancelReservation(Long resrvationId) {
		if(reservationDao.existsById(resrvationId)) {
			reservationDao.deleteById(resrvationId);
			return "Reservation deleted successfully";
		}
		return "Reservation not deleted !!!";
	}
	
	
	
}
