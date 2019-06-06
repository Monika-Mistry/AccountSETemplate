package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;

	@POST
	@Path("/addAccount")
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@GET
	@Path("/getAllAccounts")
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@GET
	@Path("/getAnAccount/{accountNumber}")
	public String getAnAccount(@PathParam("accountNumber") int accountNumber) {
		return service.getAnAccount(accountNumber);
	}

	@PUT
	@Path("/updateAccount")
	public String updateAccount(int accountNumber, String account) {
		return service.updateAccount(accountNumber, account);
	}

	@DELETE
	@Path("/deleteAccount")
	public String deleteAccount(int accountNumber) {
		return service.deleteAccount(accountNumber);
	}
}
