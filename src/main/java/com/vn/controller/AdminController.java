package com.vn.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping(value = {"/admin", "/admin/"})
	public String getAdminDashboard(Model model, Principal principal) {
		
//		Authentication authentication = (Authentication) principal;
//		
//		System.err.println(authentication.getAuthorities());
//		
//		Object authOject = ((Authentication) principal).getPrincipal();
//		
//		
//		CustomUserDetail customUserDetail = (CustomUserDetail) authOject;
//		model.addAttribute("user", customUserDetail.getUsers());
//		
//		System.err.println(customUserDetail.getRoles());
		
		return "admin_home";
	}

}
