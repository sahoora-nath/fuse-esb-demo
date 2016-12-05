package com.sahoora.fuse.demo.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sahoora.fuse.demo.dao.StudentResultDao;
import com.sahoora.fuse.demo.domain.StudentsResultDBO;
import com.sahoora.fuse.demo.service.StudentResultService;
import com.sahoora.fuse.demo.studentservice.Student;
import com.sahoora.fuse.demo.studentservice.StudentStatusType;

public class StudentResultServiceImpl implements StudentResultService {
	final static Logger logger = LoggerFactory.getLogger(StudentResultServiceImpl.class);
	private StudentResultDao studentResultDao;
	
	@Override
	public Student updateStudent(Student student) throws Exception {
		logger.info("Updating student {}.", student.getFirstName());
		StudentsResultDBO studentresultDBO = new StudentsResultDBO();
		BeanUtils.copyProperties(studentresultDBO, student);		
		
		studentResultDao.save(studentresultDBO);
		logger.info("Student updated successfully having Id {}.", student.getId());
		return student;
	}

	@Override
	public StudentStatusType getStudentStatus(int studentId) {
		logger.info("Getting status of studnet having ID - {}.", studentId);
		Double studentPercentage = studentResultDao.getStudentPercentage(studentId);
		if(studentPercentage != null) {
			if(studentPercentage > 35d) {
				return StudentStatusType.PASS;
			} else {
				return StudentStatusType.FAIL;
			}
		}
		logger.info("Completed StudentResultServiceImpl :: getStudentStatus()");
		return null;
	}
	
	@Override
	public Student lookupStudent(int studentId) throws Exception {
		logger.info("lookupStudent studnet having ID - {}.", studentId);
		StudentsResultDBO studentsResultDBO = studentResultDao.lookupStudent(studentId);
		if (studentsResultDBO == null) {
			throw new Exception("No result found for the student id : " + studentId);
		}
		Student student = new Student();
		BeanUtils.copyProperties(student, studentsResultDBO);
		logger.info("lookupStudent completed successfully for student ID - {}.", studentId);
		return student;
	}

	public StudentResultDao getStudentResultDao() {
		return studentResultDao;
	}
	
	public void setStudentResultDao(StudentResultDao studentResultDao) {
		this.studentResultDao = studentResultDao;
	}
}
