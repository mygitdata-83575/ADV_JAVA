package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//• Guest :Guest ID  first name ,last name , dob

@Entity
@Table(name="Guest")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
public class Guest extends BaseEntity {
	
	@Column(name = "First_Name", length = 25)
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "DOB")
	private LocalDate dob;
	
	@OneToOne
	@JoinColumn(name="room_id", nullable = false)
	private Room room;
}
