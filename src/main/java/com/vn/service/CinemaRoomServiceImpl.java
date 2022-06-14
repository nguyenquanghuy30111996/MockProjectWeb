package com.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.entities.CinemaRoom;
import com.vn.repository.CinemaRoomRepository;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService{

	
	@Autowired
	CinemaRoomRepository cinemaRoomRepository;
	
	@Override
	public List<CinemaRoom> getAllCinemaRooms() {
		List<CinemaRoom> list = cinemaRoomRepository.findAll();
		return list;
	}

	@Override
	public Page<CinemaRoom> getPageCinemaRooms(Integer pageIndex, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageIndex, pageSize);
		return cinemaRoomRepository.findAll(pageable);
	}

}
