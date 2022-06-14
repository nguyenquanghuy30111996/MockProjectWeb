package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vn.entities.CinemaRoom;
import com.vn.service.CinemaRoomService;



@Controller
public class CinemaRoomController {

	@Autowired
	CinemaRoomService cinemaRoomService;
	
	@GetMapping("/listPage")
	public ModelAndView listPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cinema_room_list");
		Page<CinemaRoom> page = cinemaRoomService.getPageCinemaRooms(0, 5);
		List<CinemaRoom> cinemaRoomList = page.toList();
		modelAndView.addObject("cinemaRoomList", cinemaRoomList);
		return modelAndView;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cinema_room_list");
		List<CinemaRoom> cinemaRoomList = cinemaRoomService.getAllCinemaRooms();
		modelAndView.addObject("cinemaRoomList", cinemaRoomList);
		return modelAndView;
	}
	
}
