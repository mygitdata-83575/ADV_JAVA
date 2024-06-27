//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
//product name(unique)  , price , available quantity

//3. Lab exam practice question
//Develop RESTful web service for managing hotel room reservation for a hotel. Users should be able to reserve hotel room, view all available rooms, cancel reservation.
//
//Entities (with attributes):
//•	Room:Room ID, room number, type (single, double, suite), price, availability(boolean)
//• Guest :Guest ID  first name ,last name , dob
//•	Reservation:Reservation ID, guest id, check-in date, check-out date, room ID, total price.
//
//Create the entities
//You can insert records in guests n rooms table.
//OR 
//Better - use JUnit testing for Data JPA Layer.


package com.sunbeam.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="room")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
public class Room extends BaseEntity {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
//	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private String type;
	
	@Column(name="room_no", length = 25)
	private String roomNo;
	
	@Column(name="price")
	private double price;
	
	@Column(name="avl_room")
	private boolean availability;

	
	

	


	
	
}
