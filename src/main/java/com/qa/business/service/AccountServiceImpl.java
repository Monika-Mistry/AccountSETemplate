package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository accountRepo;

	// @Inject
	// private JSONUtil json;

	@Override
	public String addAccount(String account) {
		// if (account.) {
		// return "{\"message\": \"This account is blocked\"}";
		// } else {
		return accountRepo.createAccount(account);
		// }
	}

	@Override
	public String getAllAccounts() {
		return accountRepo.getAllAccounts();
	}

	@Override
	public String getAnAccount(int accountNumber) {
		return accountRepo.getAnAccount(accountNumber);
	}

	@Override
	public String updateAccount(int accountNumber, String account) {
		return accountRepo.updateAccount(accountNumber, account);
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return accountRepo.deleteAccount(accountNumber);
	}

}
