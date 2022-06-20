package com.vn.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
//	
//	@GetMapping(value = {"/", "", "/index", "/home"})
//	public String getHome(Model model, Principal principal) {
//		if(principal == null) {
//			return "redirect:/login";
//		}
//		
//		CustomUserDetail customUserDetail = (CustomUserDetail) ((Authentication) principal).getPrincipal();
//		model.addAttribute("user", customUserDetail.getUsers());
//		
//		return "home";
//	}
//	
//	@GetMapping(value = {"/user-info"})
//	public String getInfoPage(Model model, Principal principal) {
//		
//		CustomUserDetail customUserDetail = (CustomUserDetail) ((Authentication) principal).getPrincipal();
//		model.addAttribute("user", customUserDetail.getUsers());
//		
//		return "user-info";
//	}
//	
	

}
