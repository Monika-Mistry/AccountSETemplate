package com.qa.persistence.domain;

public class Account {

	private int accountNumber;
	private String firstName;
	private String lastName;

	public Account(int accountNumber, String firstName, String lastName) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
