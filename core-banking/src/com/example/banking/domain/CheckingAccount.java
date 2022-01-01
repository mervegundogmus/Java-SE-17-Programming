package com.example.banking.domain;

public class CheckingAccount extends Account { // constructur kalıtımda aktarılmaz
	private double overdraftAmount; // iki tane customerdan geliyor attiribute, bi tane burda var toplam üç tane

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if(amount<=0.0) return false;
		//business rule
		if(amount > (balance+overdraftAmount))
			return false;
		this.balance -= amount;
		return true;
	};
	
	
}
