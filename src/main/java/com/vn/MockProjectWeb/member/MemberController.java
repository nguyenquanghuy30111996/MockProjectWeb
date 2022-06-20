package com.vn.MockProjectWeb.member;

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

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@GetMapping(value = "member/login")
	public ModelAndView getLoginUI(Member member, Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("member/memberLogin");
		model.addAttribute("member", member);

		return m;
	}

	@GetMapping(value = "member/register")
	public String getRegisterUI(Model model) {
		model.addAttribute("member", new Member());
		return "member/memberRegister";
	}

	@PostMapping(value = "member/register")
	public String registerMember(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		// check username unique
		Member username = service.checkUsername(member.getUsername());
		if (username != null) {
			bindingResult.rejectValue("username", "member", "Username is already exists !");

		}
		// check email unique
		Member email = service.checkEmail(member.getEmail());
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
			service.saveMember(member);
			redirectAttributes.addFlashAttribute("message", "Register sucessfully !");
		}
		return "redirect:/member/login";

	}

	@PostMapping(value = "member/login")
	public String login(@ModelAttribute("member")@Valid  Member member , BindingResult bindingResult ,Model model , RedirectAttributes attributes) {
		//checkLogin
		String username = member.getUsername();
		String password = member.getPassword();
		if("".equals(username) || username == null ) {
			bindingResult.rejectValue("username", "member", "The required fields are not null !");
		}
		if("".equals(password) || password == null ) {
			bindingResult.rejectValue("password", "member", "The required fields are not null !");
		}
		Member username1 = service.checkUsername(member.getUsername());
		Member password1 = service.checkPassword(member.getPassword());
		if(username1 == null || password1 == null) {
			bindingResult.rejectValue("password", "memeber", "Username / password is invalid. Please try again !");
			
		}else {
			return "redirect:/index";
		}
				
			
		
		
	   if(bindingResult.hasErrors()) {
		   return "member/memberLogin";
	   }
		
	
		return "redirect:/index";
		
	}
	@GetMapping(value = "index")
	public String showHomePage(Model model, Member member) {
		model.addAttribute("member", member);
		return "index";
		
	}
	
	@GetMapping(value = "member/list")
	public String getAllMember(Model model) {
		List<Member> members = service.findAll();
		model.addAttribute("member",members);
		return "member/memberList";
		
	}
	@GetMapping(value = "member/edit")
	public String getEditMemberUI(@RequestParam("id")Integer id , Model model) {
	     Member member = (Member) service.findAllById(id);
	     model.addAttribute("member", member);
		return "member/memberEdit";
		
	}
	@PostMapping(value = "member/edit")
	public String editMember(Model model,Member member,RedirectAttributes attributes) {
		service.update(member);
		attributes.addFlashAttribute("message", "Update information successfully !");
		return "redirect:/member/list";
		
	}
}

