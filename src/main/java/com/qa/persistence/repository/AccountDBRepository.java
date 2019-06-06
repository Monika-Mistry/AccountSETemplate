package com.qa.persistence.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	private JSONUtil json;

	public String getAllAccounts() {

		Query query = em.createQuery("SELECT a FROM Account a");

		Collection<Account> accounts = (Collection<Account>) query.getResultList();

		return json.getJSONForObject(accounts);
	}

	@Transactional(TxType.REQUIRED)
	public String createAccount(String account) {

		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int accountNumber) {

		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String updateAccount(int accountNumber, String account) {

		return null;
	}

}
