package com.sahoora.fuse.demo.dao.base.impl;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.sahoora.fuse.demo.domain.base.BaseAware;

/**
 * Listener to update the common column before every write;
 * @author sahoo
 *
 */
public class StudentBaseListener {

	@PrePersist
	@PreUpdate
	public void updateCommonColumn(BaseAware baseAware) {
		baseAware.getStudentsBase().updateBeforePersist();
	}
}
