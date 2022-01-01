package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Customer {
	private String identity;
	private String fullName;
	private List<Account> accounts = new ArrayList<>();

	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	// Overloading: Same class & method name, diffent signature
	// Overriding: Inherited Classes, same method name & signature
	//public Optional<Account> removeAccount(int index){} //doldurucaz i�ini

	
	public Optional<Account> removeAccount(String iban) {
		Account foundAccount = null;
		for (var account : accounts) {
			if (account.getIban().equals(iban)) {
				foundAccount = account;
				break;
			}
		}
		if (Objects.nonNull(foundAccount)) {
			accounts.remove(foundAccount);
		}
		return Optional.ofNullable(foundAccount);
	}

	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}

}
