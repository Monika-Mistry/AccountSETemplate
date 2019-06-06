package com.qa.business.service;

public interface AccountService {

	// C
	String addAccount(String account);

	// R
	String getAllAccounts();

	String getAnAccount(int accountNumber);

	// U
	String updateAccount(int accountNumber, String account);

	// D
	String deleteAccount(int accountNumber);

}
