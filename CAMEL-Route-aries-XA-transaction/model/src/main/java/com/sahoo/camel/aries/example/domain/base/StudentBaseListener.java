package com.sahoo.camel.aries.example.domain.base;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
