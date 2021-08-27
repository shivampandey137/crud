package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.model.Bank;
import com.atm.model.Response;
import com.atm.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;

	public Response<Bank> viewBalance(Long id) {

		Response<Bank> response = new Response<Bank>();
		Bank bank = bankRepository.findById(id).orElse(null);
		if (bank != null) {
			double balance = bank.getTotalBalance();
			System.out.println(balance);
			response.setData(balance);
			response.setMessage("Balance fetched successfully");
			response.setStatuscode(200);
			return response;
		} else {
			response.setMessage("Balance not found with id " + id);
			response.setStatuscode(400);
			return response;
		}
	}

	public Response<Bank> addCash(Bank bank) {

		Response<Bank> response = new Response<Bank>();
		
		Bank existingBank = bankRepository.findById(bank.getId()).orElse(null);
		if (existingBank != null) {
			double balance = bank.getTotalBalance() + existingBank.getTotalBalance();
			bank.setTotalBalance(balance);
			// bankRepository.saveTotalBalance(balance);
			
			bankRepository.save(bank);

			response.setData(balance);
			response.setMessage("Balance updated successfully");
			response.setStatuscode(204);
			return response;
		}

		else {
			response.setMessage("No product found by the id=" + bank.getId());
			response.setStatuscode(400);
			return response;
		}
	}

}
