package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AccountTest {

	@Test
	@DisplayName("create account object successfuly")
	void createObjectSuccesfuly() {
		// 1. Test Fixture/Setup
		// 2. Call exercise method
		var acc = new Account("tr1", 10_000); //var using just local variable
		// 3. Verification
		assertEquals("tr1", acc.getIban());
		assertEquals(10_000, acc.getBalance());
		// 4. Tear-down
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void depositWithNegativeAmountShouldFail(String iban, double balance, double amount)
		throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account(iban, balance);
		// 2. Call exercise method
		var result = acc.deposit(amount);
		// 3. Verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
	}
	
	@Test
	void depositWithPositivetiveAmountShouldSuccess() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var result = acc.deposit(1);
		// 3. Verification
		assertTrue(result);
		assertEquals(10_001, acc.getBalance());
		
	}
}
 