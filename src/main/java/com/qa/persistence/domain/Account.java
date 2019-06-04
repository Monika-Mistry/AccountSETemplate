package com.qa.persistence.domain;

public class Account {

	private int id;
	private int accountNumber;
	private String firstName;
	private String lastName;
	private static int counter = 1;

	public Account(int accountNumber, String firstName, String lastName) {
		this.setId(counter);
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		counter++;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
