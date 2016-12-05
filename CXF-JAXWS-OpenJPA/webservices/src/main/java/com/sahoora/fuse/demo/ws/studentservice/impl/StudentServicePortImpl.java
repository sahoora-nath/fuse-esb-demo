package com.sahoora.fuse.demo.ws.studentservice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sahoora.fuse.demo.faults.NoResultExcpetion;
import com.sahoora.fuse.demo.faults.StudentServiceExcpetion;
import com.sahoora.fuse.demo.service.StudentResultService;
import com.sahoora.fuse.demo.studentservice.Student;
import com.sahoora.fuse.demo.studentservice.StudentStatusType;
import com.sahoora.fuse.demo.ws.studentservice.LookupStudentRequest;
import com.sahoora.fuse.demo.ws.studentservice.LookupStudentResponse;
import com.sahoora.fuse.demo.ws.studentservice.StudentServicePort;
import com.sahoora.fuse.demo.ws.studentservice.StudentStatusRequest;
import com.sahoora.fuse.demo.ws.studentservice.StudentStatusResponse;
import com.sahoora.fuse.demo.ws.studentservice.UpdateStudentRequest;
import com.sahoora.fuse.demo.ws.studentservice.UpdateStudentResponse;

public class StudentServicePortImpl implements StudentServicePort {
	final static Logger logger = LoggerFactory.getLogger(StudentServicePortImpl.class);
	private StudentResultService studentResultService;

	public StudentResultService getStudentResultService() {
		return studentResultService;
	}

	public void setStudentResultService(StudentResultService studentResultService) {
		this.studentResultService = studentResultService;
	}

	public UpdateStudentResponse updateStudent(UpdateStudentRequest request) throws StudentServiceExcpetion {
		Student updatedStudent = null;
		try {
			updatedStudent = studentResultService.updateStudent(request.getStudent());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new StudentServiceExcpetion(e.getMessage());
		}
		UpdateStudentResponse response = new UpdateStudentResponse();
		response.setStudent(updatedStudent);
		return response;
	}

	public StudentStatusResponse getStudentStatus(StudentStatusRequest request) throws NoResultExcpetion {
		int studentId = request.getStudentId();
		StudentStatusType statusType = studentResultService.getStudentStatus(studentId);
		if (statusType == null) {
			throw new NoResultExcpetion("Invalid Student ID - "+ studentId);
		}
		StudentStatusResponse response = new StudentStatusResponse();
		response.setStatus(statusType);
		return response;
	}

	public LookupStudentResponse lookupStudent(LookupStudentRequest request) throws NoResultExcpetion {
		LookupStudentResponse response = new LookupStudentResponse();
		try {
			Student lookupStudent = studentResultService.lookupStudent(request.getStudentId());
			response.setStudent(lookupStudent);
			return response;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new NoResultExcpetion(e.getMessage());
		}
	}
}
