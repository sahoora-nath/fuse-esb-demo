package com.sahoora.spring.batch.fuse.dao.impl;

import com.sahoora.spring.batch.fuse.beans.BatchItem;
import com.sahoora.spring.batch.fuse.dao.BatchEventDao;

/**
 * This service is invoked from spring batch ItemWriter CRUD operation in DB
 * @author sahoora-nath
 *
 */
public class BatchEventDaoImpl implements BatchEventDao {

	@Override
	public void createItems(BatchItem batchItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BatchItem updateItems(BatchItem batchItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
