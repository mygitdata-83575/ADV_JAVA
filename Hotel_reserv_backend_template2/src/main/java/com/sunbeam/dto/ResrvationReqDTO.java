package com.sunbeam.dto;

import java.time.LocalDate;



import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Room;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ResrvationReqDTO extends BaseDTO{
   
   private Long roomId;
   private String guestName;
   private LocalDate checkInDate;
   private LocalDate checkOutDate;
   //private String Type;
   
	
}
