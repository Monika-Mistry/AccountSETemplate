package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;

	public String addAccount(String account) {

	}

	public String getAllAccounts() {

	}

	public String getAnAccount(int accountNumber) {

	}

	public String updateAccount(int accountNumber, String account) {

	}

	public String deleteAccount(int accountNumber) {

	}
}
