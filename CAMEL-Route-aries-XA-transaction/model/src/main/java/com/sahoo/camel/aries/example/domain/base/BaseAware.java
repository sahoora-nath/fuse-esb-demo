package com.sahoo.camel.aries.example.domain.base;

/**
 * This to be implemented by entities that have a common set of columns.
 * @author sahoo
 *
 */
public interface BaseAware {

	StudentsBase getStudentsBase();
	
	void setStudentsBase(StudentsBase base);
}
