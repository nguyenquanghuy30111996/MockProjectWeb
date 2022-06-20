package com.vn.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vn.entities.Users;

@Controller
public class AuthController {
	
	@GetMapping("/login")
	public String getLoginUI(Model model, Principal principal) {
		
		if(principal != null)
			return "redirect:/home";
		
		model.addAttribute("user", new Users());
		return "login";
	}
	
	@GetMapping("/403")
	public String get403(Model model) {
		return "403";
	}

}
