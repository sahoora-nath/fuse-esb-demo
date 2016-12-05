package com.sahoora.fuse.demo.domain.base;

/**
 * This to be implemented by entities that have a common set of columns.
 * @author sahoo
 *
 */
public interface BaseAware {

	StudentsBase getStudentsBase();
	
	void setStudentsBase(StudentsBase base);
}
