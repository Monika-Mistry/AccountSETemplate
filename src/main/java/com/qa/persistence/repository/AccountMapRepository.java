package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	@Inject
	private JSONUtil jsonUtil;

	public String getAllAccounts() {
		return jsonUtil.getJSONForObject(accountMap);
	}

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public String createAccount(String account) {

		Account acc = jsonUtil.getObjectForJSON(account, Account.class);

		accountMap.put(acc.getAccountNumber(), acc);

		return "Account added";
	}

	public String deleteAccount(int accountNumber) {
		accountMap.remove(accountNumber);
		return "Account deleted";
	}

	public String updateAccount(int accountNumber, String account) {

		Account acc = jsonUtil.getObjectForJSON(account, Account.class);

		accountMap.replace(accountNumber, acc);

		return "Account updated";
	}

	public int findAccountsWithFirstName(String name) {
		return (int) accountMap.values().stream().filter(a -> a.getFirstName().equals(name)).count();

	}

	public String getAnAccount(int accountNumber) {
		Account acc = accountMap.values().stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst().get();
		return jsonUtil.getJSONForObject(acc);
	}

}
