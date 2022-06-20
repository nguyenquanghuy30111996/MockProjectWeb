package com.vn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.entities.Users;
import com.vn.service.UserService;

@Controller
public class MemberController {

	@Autowired
	UserService memberService;

	@GetMapping(value = "member/login")
	public ModelAndView getLoginUI(Users member, Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("member/memberLogin");
		model.addAttribute("member", member);

		return m;
	}

	@GetMapping(value = "member/register")
	public String getRegisterUI(Model model) {
		model.addAttribute("member", new Users());
		return "member/memberRegister";
	}

	@PostMapping(value = "member/register")
	public String registerUsers(@ModelAttribute("member") @Valid Users member, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		// check username unique
		Users username = memberService.checkUsername(member.getUsername());
		if (username != null) {
			bindingResult.rejectValue("username", "member", "Username is already exists !");

		}
		// check email unique
		Users email = memberService.checkEmail(member.getEmail());
		if (email != null) {
			bindingResult.rejectValue("email", "member", "Email is already exists !");
		}
		// checkPassword
		String password = member.getPassword();
		String rePassword = member.getRePassword();
		if (password.equals(rePassword)) {

		} else {
			bindingResult.rejectValue("rePassword", "member", "Confirm passowrd is not equals Password !");
		}

		// check null fields
		if (bindingResult.hasErrors()) {
			return "member/memberRegister";
		} else {
		}
		{
			memberService.saveUsers(member);
			redirectAttributes.addFlashAttribute("message", "Register sucessfully !");
		}
		return "redirect:/member/login";

	}
	
	@GetMapping(value = "index")
	public String showHomePage(Model model, Users member) {
		model.addAttribute("member", member);
		return "index";
	}
	
	@GetMapping(value = "member/list")
	public String getAllUsers(Model model) {
		List<Users> members = memberService.findAll();
		model.addAttribute("member",members);
		return "member/memberList";
		
	}
	@GetMapping(value = "member/edit")
	public String getEditUsersUI(@RequestParam("id")Integer id , Model model) {
	     Users member = (Users) memberService.findById(id);
	     model.addAttribute("member", member);
		return "member/memberEdit";
		
	}
	@PostMapping(value = "member/edit")
	public String editUsers(Model model,Users member,RedirectAttributes attributes) {
		memberService.update(member);
		attributes.addFlashAttribute("message", "Update information successfully !");
		return "redirect:/member/list";
		
	}
}

