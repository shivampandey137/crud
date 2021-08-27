package com.atm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bank")
public class Bank {

	@Id
	private Long id;
	private long cardNo;
	private int pin;
	private double totalBalance;

	public Bank() {
		super();
	}

	public Bank(Long id, long cardNo, int pin, double totalBalance) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.pin = pin;
		this.totalBalance = totalBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", cardNo=" + cardNo + ", pin=" + pin + ", totalBalance=" + totalBalance + "]";
	}

}
