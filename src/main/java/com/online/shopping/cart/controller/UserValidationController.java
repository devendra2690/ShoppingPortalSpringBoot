package com.online.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.cart.bean.User;
import com.online.shopping.cart.service.UserService;

@RestController
@RequestMapping("/authentication")
@CrossOrigin("http://localhost:3000")
public class UserValidationController {
	
	@Autowired
	UserService userService;

	@PostMapping("/validateUser")
	public User validateUser(@RequestBody User user) {
		
		User validatedUserObj = userService.validateUser(user);
		return validatedUserObj;
	}
	
}
