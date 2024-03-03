package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String loginPage() {
		
		return "loginPage";
		
	}
	
	@GetMapping("/loginErrorPage")
	public String loginErrorPage() {
		
		return "loginErrorPage";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		
		if(userService.authenticate(username, password)) {
			
			return "redirect:/home";
			
		}else {
			
			return "redirect:/loginErrorPage";
			
		}
		
	}
	
	
	
}
