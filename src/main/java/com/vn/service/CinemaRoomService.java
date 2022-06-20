package com.vn.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vn.entities.CinemaRoom;



public interface CinemaRoomService {
	
	public List<CinemaRoom> getAllCinemaRooms();
	
	public Page<CinemaRoom> getPageCinemaRooms(Integer pageIndex, Integer pageSize);
	
	public void saveCinemaRoom(CinemaRoom cinemaRoom);

	public List<CinemaRoom> getAllCinemaRoomsByKeyword(String keyword);

}
