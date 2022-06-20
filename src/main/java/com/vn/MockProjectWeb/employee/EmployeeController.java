package com.vn.MockProjectWeb.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "employee/list")
	public ModelAndView getAllEmployee(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("employee/employeeList");
		List<Employee> e = employeeService.listAll();
		model.addAttribute("list", e);
		
		return m;

	}

	@GetMapping(value = "employee/add")
	public ModelAndView getCreateUI(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("employee/employeeAdd");
		model.addAttribute("employee", new Employee());
		return m;
	}

	@PostMapping(value = "employee/add")
	public String createEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,
			Model model, RedirectAttributes attributes) throws EmployeeNotFoundException {
		//check Password
		String password = employee.getPassword();
		String rePassword = employee.getRePassword();
		if(rePassword.equals(password)) {
			
		}else {
			bindingResult.rejectValue("rePassword", "employee", "Confirm password is not equals Password !");
		}
		
		
		// validate unique username
		Employee username = employeeService.checkUsername(employee.getUsername());
		if (username != null) {
			bindingResult.rejectValue("username", "employee", "Username is already exists !");
		}
		//validate unique email
		Employee email = employeeService.checkEmail(employee.getEmail());
		if (email != null) {
			bindingResult.rejectValue("email", "employee", "Email is already exists !");
		}

		if (bindingResult.hasErrors()) {
			return "employee/employeeAdd";
		} else {
		}
		{
			employeeService.saveEmployee(employee);
			attributes.addFlashAttribute("message", "The new employee has been saved successfully !");
		}

		return "redirect:/employee/list";
	}

	@GetMapping(value = "employee/delete")
	public String deleteEmployee(@RequestParam Integer id, RedirectAttributes attributes) {
		employeeService.delete(id);
		attributes.addFlashAttribute("message", " The employee #" + id + " has been deleted !");
		return "redirect:/employee/list";

	}

	@GetMapping(value = "employee/edit")
	public String getEditUI(@RequestParam("id") Integer id, Model model, RedirectAttributes attributes)
			throws EmployeeNotFoundException {
		Employee employee = employeeService.get(id);
		model.addAttribute("employee", employee);

		return "employee/employeeEdit";

	}

	@PostMapping(value = "employee/edit")
	public String editEmployee(@RequestParam("id") @Valid  Integer id, @ModelAttribute("employee") Employee employee,BindingResult bindingResult,
			RedirectAttributes attributes, Model model) {
		String password = employee.getPassword();
		String rePassword = employee.getRePassword();
		if(rePassword.equals(password)) {
			
		}else {
			bindingResult.rejectValue("rePassword", "employee", "Confirm password is not equals Password !");
		}
		if(bindingResult.hasErrors()) {
			return "employee/employeeEdit";
		}
		employeeService.update(employee);
		attributes.addFlashAttribute("message", "The employee #"+ id +" has  been updated  successfully !");

		return "redirect:/employee/list";

	}
	
}
	
