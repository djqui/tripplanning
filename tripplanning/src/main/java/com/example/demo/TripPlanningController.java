package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
	public class TripPlanningController {
		@GetMapping("/welcome")
		public String welocme() {
			return "Welcome";
		}
		
		@GetMapping("/user/signup")
		public String signup() {
			return "Signup";
		}
		
		@GetMapping("/user/login")
		public String login() {
			return "Login";
		}
		
		@PostMapping("/user/validate")
		public String validateUser(@RequestParam("email") String email,
				@RequestParam("password") String password, Model model) {
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			return "Welcome";
		}

}
