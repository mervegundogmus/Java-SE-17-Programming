package com.example.banking.domain;

public class Account {
	private String iban; // attribute/state/property/data
	// balance: instance+value-typed variable ->0.0
	protected double balance;

	public Account(String iban, double balance) {
		// iban: instance+reference variable
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		// validation
		if (amount <= 0)
			return false;
		// business logic
		this.balance = this.balance + amount;
		return true;
	}

	public boolean withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0)  //task
			return false;
		// business rule
		if (amount > this.balance) //task
			return false;
		// this.balance = this.balance - amount; //task
		this.balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	public double withdrawAll() {
		var balance = this.balance;
		this.balance = 0.0;
		return balance;
	}

}
