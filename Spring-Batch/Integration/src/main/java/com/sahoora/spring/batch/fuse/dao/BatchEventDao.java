package com.sahoora.spring.batch.fuse.dao;

import com.sahoora.spring.batch.fuse.beans.BatchItem;

public interface BatchEventDao {
	void createItems(BatchItem batchItem);
	BatchItem updateItems(BatchItem batchItem);
}
