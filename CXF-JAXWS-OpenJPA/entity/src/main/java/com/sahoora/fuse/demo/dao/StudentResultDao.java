package com.sahoora.fuse.demo.dao;

import com.sahoora.fuse.demo.domain.StudentsResultDBO;

public interface StudentResultDao {
	StudentsResultDBO save(StudentsResultDBO entity);
	
	Double getStudentPercentage(int studentId);
	
	StudentsResultDBO lookupStudent(int studentId);
}