package com.atm.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response<T> {
	
	@JsonProperty
	private Integer statuscode;
	@JsonProperty
	private String message;
	@JsonProperty
	private double balance;
	
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getBalance() {
		return balance;
	}
	public void setData(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Response [statuscode=" + statuscode + ", message=" + message + ", balance=" + balance + "]";
	}
	
	

}
