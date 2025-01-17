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

		Account acc = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();

		return "{\"message\": \"New Account Created\"}";
	}

	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int accountNumber) {

		Account acc = em.find(Account.class, accountNumber);

		em.getTransaction().begin();
		em.remove(acc);
		em.getTransaction().commit();

		return "{\"message\": \"Account deleted\"}";
	}

	@Transactional(TxType.REQUIRED)
	public String updateAccount(int accountNumber, String account) {

		Account oldAcc = em.find(Account.class, accountNumber);
		Account newAcc = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.detach(oldAcc);
		oldAcc = newAcc;
		em.merge(oldAcc);
		em.getTransaction().commit();

		return "{\"message\": \"Account details updated\"}";
	}

	public String getAnAccount(int accountNumber) {
		return json.getJSONForObject(em.find(Account.class, accountNumber));
	}

}
