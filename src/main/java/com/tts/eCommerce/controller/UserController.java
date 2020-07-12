package com.tts.eCommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerce.model.User;
import com.tts.eCommerce.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@GetMapping(value = "/users/{username}")
	public String getUser(@PathVariable(value = "username") String username, Model model) {
		User user = userService.findByUsername(username);
		User loggedInUser = userService.getLoggedInUser();
		return "user";
	}
	
	@GetMapping (value = "/users")
	public String getUsers(@RequestParam(value = "filter", required = false) String filter, Model model) {
		List<User> users = new ArrayList<>();
		User loggedInUser = userService.getLoggedInUser();
		model.addAttribute("users", users);
		return "users";
	}
	

}
