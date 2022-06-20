package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vn.entities.CinemaRoom;
import com.vn.service.CinemaRoomService;



@Controller
public class CinemaRoomController {

	@Autowired
	CinemaRoomService cinemaRoomService;
	
	

	

//	@GetMapping("/page/{pageNum}/{totalPage}")
//	public String redirectPage(Model model,@PathVariable("pageNum") Integer pageNum,@PathVariable("totalPage") Integer totalPage) {
//
//		if(pageNum==0) {
//			return "redirect:/list";
//		}else if (pageNum < totalPage) {
//			model.addAttribute("currentPage", pageNum);
//			return listPage(model, pageNum);
//		}
//		else {
//			return listPage(model, totalPage);
//		}
//	}
	
	
	 @GetMapping("/")
	    public String viewSearch(Model model, @RequestParam("keyword") String keyword) {
	        List<CinemaRoom> cinemaRoomList = cinemaRoomService.getAllCinemaRoomsByKeyword(keyword);
	        model.addAttribute("cinemaRoomList", cinemaRoomList);
	        model.addAttribute("keyword", keyword);
	         
	        return "cinema_room_list";
	    }
	
//	@GetMapping("/list")
//	public ModelAndView viewPage() {
//		Model model = new Model()
//		return listPage(1);
//	}
//	
//	@GetMapping("/listPage/{pageNum}")
//	public ModelAndView listPage(@PathVariable("pageNum") Integer pageNum) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("cinema_room_list");
//		Page<CinemaRoom> page = cinemaRoomService.getPageCinemaRooms(pageNum, 3);
//		List<CinemaRoom> cinemaRoomList = page.toList();
//		modelAndView.addObject("cinemaRoomList", cinemaRoomList);
//		modelAndView.addObject("currentPage", pageNum);
//		modelAndView.addObject("totalPages", page.getTotalPages());
//		
//		return modelAndView;
//	}
//	
	
	 @GetMapping("/listCinemaRoom")
	 public String getList(Model model) {
		 List<CinemaRoom> cinemaRoomList = cinemaRoomService.getAllCinemaRooms();
	        model.addAttribute("cinemaRoomList", cinemaRoomList);
	        return "admin_cinema_room_list";
	 }
	 
//	 @GetMapping("/listCinemaRoom")
//	 public ModelAndView getList() {
//		 ModelAndView modelAndView = new ModelAndView();
//		 List<CinemaRoom> cinemaRoomList = cinemaRoomService.getAllCinemaRooms();
//		 modelAndView.setViewName("admin_cinema_room_list");
//		 modelAndView.addObject("cinemaRoomList", cinemaRoomList);
//	        return modelAndView;
//	 }
	 
	 
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cinema_room_list");
		List<CinemaRoom> cinemaRoomList = cinemaRoomService.getAllCinemaRooms();
		modelAndView.addObject("cinemaRoomList", cinemaRoomList);
		return modelAndView;
	}
	
	@GetMapping("/seatDetail")
	public ModelAndView listDetail() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("seat_detail");
		return modelAndView;
	}
	
	@GetMapping("/addCinemaRoom")
	public ModelAndView addCinemaRoom() {
		ModelAndView modelAndView = new ModelAndView("add_new_cinema_room");
		CinemaRoom cinemaRoom = new CinemaRoom();
		modelAndView.addObject("cinemaRoom", cinemaRoom);
		return modelAndView;
	}
	
	
	
	@PostMapping("/saveCinemaRoom")
	public String saveCinemaRoom(@ModelAttribute("cinemaRoom") CinemaRoom cinemaRoom) {
		cinemaRoomService.saveCinemaRoom(cinemaRoom);
		return "redirect:/listCinemaRoom";
	}
	
	
}

