package com.sahoora.fuse.demo.dao.base;

import java.util.List;

public interface EntityManagerBase<E, K> {

	/**
	 * creates a new instance of entity in the database. 
	 * <p/><em>Note: The entity instance returned by this will be attached.</em>
	 * @param entity - The entity to create.
	 * @return the new instance of attached entity.
	 */
	E create(E entity);
	
	/**
	 * Merges changes to an entity instance into the database.
	 * <p/><em>Note: The entity instance returned by this will be attached.</em>
	 * 
	 * @param entity The entity to merge into the database.
	 * @return The modified entity (attached).
	 */
	E update(E entity);
	
	/**
	 * Removes an entity instance from the database.
	 * @param entity
	 */
	void delete(E entity);
	
	/**
	 * Obtains an entity instance from the database using its primary key.
	 * <p/><em>Note: The entity instance returned by this will be attached, provided this is invoked in a transaction,
     * which is the usual case.</em>
	 * @param id the primary key
	 * @return The entity for the key if it exists (attached), or <tt>null</tt> if no matching entity can be found.
	 */
	E findById(K id);
	
	/**
	 * Obtains list of entity instances from the database using named query.
	 * <p/><em>Note: The entity instance returned by this will be attached, provided this is invoked in a transaction,
     * which is the usual case.</em>
	 * @param namedQuery The named query to run.
	 * @return The List of entities (attached), or <tt>empty list</tt> if no matching entity can be found.
	 */
	List<E> queryAll(String namedQuery);
}
