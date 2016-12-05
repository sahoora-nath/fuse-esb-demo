package com.sahoora.fuse.demo.service;

import com.sahoora.fuse.demo.studentservice.Student;
import com.sahoora.fuse.demo.studentservice.StudentStatusType;

public interface StudentResultService {
	Student updateStudent(Student student) throws Exception;

	StudentStatusType getStudentStatus(int studentId);
	
	Student lookupStudent(int studentId) throws Exception;
}