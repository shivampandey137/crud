package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.model.Bank;
import com.atm.model.Response;
import com.atm.model.User;
import com.atm.repository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	UserRespository userRespository;

	public Response<Bank> viewBalance(Long id) {

		Response<Bank> response = new Response<Bank>();
		User user = userRespository.findById(id).orElse(null);
		if (user != null) {
			double balance = user.getBalance();
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

	public Response<User> withdrawCash(User user) {
		Response<User> response = new Response<User>();
		
		User existingUser = userRespository.findById(user.getId()).orElse(null);
		if (existingUser != null) {
			
			if(existingUser.getBalance()>=user.getBalance() && user.getBalance()%100==0) {
				
			double balance = existingUser.getBalance() - user.getBalance();
			user.setBalance(balance);
			// bankRepository.saveTotalBalance(balance);
			
			userRespository.save(user);
			//userRepository.save(user);

			response.setData(balance);
			response.setMessage("Please collect your cash");
			response.setStatuscode(204);
			return response;
			}
			else {
				double balance=existingUser.getBalance();
				response.setData(balance);
				response.setMessage("You have low balance or you entered wrong amount");
				response.setStatuscode(400);
				return response;
			}
		}

		else {
			response.setMessage("No user found by the id=" + user.getId());
			response.setStatuscode(400);
			return response;
		}
	}

	public Response<User> depositCash(User user) {
		
		Response<User> response = new Response<User>();
		User existingUser = userRespository.findById(user.getId()).orElse(null);
		if (existingUser != null) {
			
			if(user.getBalance()%100==0) {
			double balance = existingUser.getBalance() + user.getBalance();
			user.setBalance(balance);
			
			userRespository.save(user);

			response.setData(balance);
			response.setMessage("Deposit successfull");
			response.setStatuscode(204);
			return response;
			}
			else {
				
				double balance=existingUser.getBalance();
				response.setData(balance);
				response.setMessage("You have entered wrong amount");
				response.setStatuscode(400);
				return response;
			}
		}

		else {
			response.setMessage("No user found by the id=" + user.getId());
			response.setStatuscode(400);
			return response;
		}
	}
}
