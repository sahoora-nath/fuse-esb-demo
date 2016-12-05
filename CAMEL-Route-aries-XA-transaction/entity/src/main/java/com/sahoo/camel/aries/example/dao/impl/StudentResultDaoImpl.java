package com.sahoo.camel.aries.example.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;

import com.sahoo.camel.aries.example.dao.StudentResultDao;
import com.sahoo.camel.aries.example.domain.StudentsResultDBO;

public class StudentResultDaoImpl implements StudentResultDao {
	private EntityManager entityManager;
	private TransactionManager transactionManager;
	
	public StudentsResultDBO create(StudentsResultDBO entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	
}
