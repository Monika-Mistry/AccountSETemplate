package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(TxType.SUPPORTS)
public class AccountDBRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

}
