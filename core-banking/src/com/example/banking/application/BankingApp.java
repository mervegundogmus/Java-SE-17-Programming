package com.example.banking.application;

import com.example.banking.domain.Account;

public class BankingApp {
	public static void main(String[] args) {
		// acc: Local+Reference Variable -> Stack
		Account acc = //acc -> Stack
				//Heap Object
				new Account("tr1",10_000);
		acc.withdraw(1_000);
		System.err.println(acc.getBalance());
		System.err.println(acc.toString());
		
		//Account acc2 = new Account("tr2", 20_000);
		// x: Local+Value-typed Variable
		//int x = 42;
	}

}
