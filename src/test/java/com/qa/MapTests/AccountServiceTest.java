package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private JSONUtil jsonUtil;
	private AccountMapRepository amp;

	@Before
	public void setup() {
		jsonUtil = new JSONUtil();
		amp = new AccountMapRepository();

	}

	@Test
	public void addAccountTest() {

		Account acc = new Account(1234, "John", "Smith");
		String accString = jsonUtil.getJSONForObject(acc);

		assertEquals("Account not created", "Account added", amp.createAccount(accString));

	}

	@Test
	public void add2AccountsTest() {
		Account acc1 = new Account(1234, "John", "Smith");
		Account acc2 = new Account(12345, "Jane", "Doe");

		String acc1String = jsonUtil.getJSONForObject(acc1);
		String acc2String = jsonUtil.getJSONForObject(acc2);

		assertEquals("Account not created", "Account added", amp.createAccount(acc1String));
		assertEquals("Account not created", "Account added", amp.createAccount(acc2String));
	}

	@Test
	public void removeAccountTest() {
		Account acc = new Account(1234, "John", "Smith");
		String accString = jsonUtil.getJSONForObject(acc);
		amp.createAccount(accString);

		int accountNumber = acc.getAccountNumber();

		assertEquals("Account not removed", "Account deleted", amp.deleteAccount(accountNumber));
	}

	@Test
	public void remove2AccountsTest() {
		Account acc1 = new Account(1234, "John", "Smith");
		Account acc2 = new Account(12345, "Jane", "Doe");

		String acc1String = jsonUtil.getJSONForObject(acc1);
		String acc2String = jsonUtil.getJSONForObject(acc2);

		amp.createAccount(acc1String);
		amp.createAccount(acc2String);

		int accNo1 = acc1.getAccountNumber();
		int accNo2 = acc2.getAccountNumber();

		assertEquals("Account not removed", "Account deleted", amp.deleteAccount(accNo1));
		assertEquals("Account not removed", "Account deleted", amp.deleteAccount(accNo2));

	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
