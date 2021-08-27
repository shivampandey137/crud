package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.model.Bank;
import com.atm.model.Response;
import com.atm.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService;

	@GetMapping("/availableCash/{id}")
	public Response<Bank> availableCash(@PathVariable Long id) {
		//System.out.println("balance=200");
		return bankService.viewBalance(id);
	}
	
	@PutMapping("/addCash")
	public Response<Bank> addMoney(@RequestBody Bank bank) {
		
		return bankService.addCash(bank);
	}
	
	
}
