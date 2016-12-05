package com.sahoora.fuse.demo.dao.base.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sahoora.fuse.demo.dao.base.EntityManagerBase;

/**
 * EntityManagerBaseImpl provides a base implementation for basic CRUD services.
 * @author sahoo
 *
 * @param <E> The type of the entity that this DAO manages.
 * @param <K> The type of the primary key of the entity.
 */
public class EntityManagerBaseImpl<E, K> implements EntityManagerBase<E, K> {
	final static Logger logger = LoggerFactory.getLogger(EntityManagerBaseImpl.class);
	
	private EntityManager entityManager;
	private TransactionManager transactionManager;
	
	/** The class of entity that this DAO manages. */
	private Class<E> type;
	
	public EntityManagerBaseImpl(Class<E> type) {
		this.type = type;
	}
	/** {@inheritDoc} */
	public E create(E entity) {
		logger.debug("Persisting {}", entity);
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}
	
	/** {@inheritDoc} */
	public E update(final E entity) {
		logger.debug("Updating {}", entity);
		E merged = entityManager.merge(entity);
		entityManager.flush();
		return merged;
	}

	/** {@inheritDoc} */
	public E findById(K id) {
		logger.debug("Retrieving {}:{}", type, id);
		return entityManager.find(type, id);
	}
	
	/** {@inheritDoc} */
	public void delete(final E entity) {
		logger.debug("Deleting {}", entity);
		entityManager.remove(entity);
	}
	
	/** {@inheritDoc} */
	public List<E> queryAll(String namedQuery) {
		logger.debug("Querying {}:{}", type, namedQuery);
		TypedQuery<E> query = getEntityManager().createNamedQuery(namedQuery, type);
		return new ArrayList<E>(query.getResultList());
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