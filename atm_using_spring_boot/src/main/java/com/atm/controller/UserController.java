package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.model.Bank;
import com.atm.model.Response;
import com.atm.model.User;
import com.atm.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/availableBalance/{id}")
	public Response<Bank> availableBalance(@PathVariable Long id) {
		
		return userService.viewBalance(id);
	}
	
	@PutMapping("/withdraw")
	public Response<User> withdraw(@RequestBody User user) {
		
		return userService.withdrawCash(user);
	}
	
	@PutMapping("/deposit")
	public Response<User> deposit(@RequestBody User user) {
		
		return userService.depositCash(user);
	}
}
