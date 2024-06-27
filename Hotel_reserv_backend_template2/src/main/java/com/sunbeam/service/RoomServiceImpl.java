package com.sunbeam.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.RoomResDto;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RoomServiceImpl() {
		System.out.println("in ctor "+ getClass());
	}
	
	@Override
	public RoomResDto getRoomDetails(LocalDate date) {
		Room room = roomDao.getAvlRoom(date);
					
		
		
			return modelMapper.map(room, RoomResDto.class);
		
	}
//	public CategoryPostDTO getCategoryAndPostDetails(Long categoryId) {
//		// return category + posts details
//		Category categoryEnt = categoryDao
//				.getCategoryAndPosts(categoryId) // Optional<Category>
//				.orElseThrow(
//						() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
//		return modelMapper.map(categoryEnt,CategoryPostDTO.class);
//
//	}
}
