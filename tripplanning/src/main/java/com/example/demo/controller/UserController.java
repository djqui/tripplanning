package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/welcome") 
	public String welocme() { 
		return "Welcome";
	}
	
	@GetMapping("/user/signup")
	public String showUserPage (Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@GetMapping("/user/login")
	public String showloginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/user/validate")
	public String saveUserForm(User user, RedirectAttributes redi) {
		redi.addFlashAttribute("message", "User has been saved...");
		service.save(user);
		return "redirect:/welcome";
	}
	
}
