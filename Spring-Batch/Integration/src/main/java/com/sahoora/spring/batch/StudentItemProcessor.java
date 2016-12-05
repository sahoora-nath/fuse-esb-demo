package com.sahoora.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import com.sahoora.spring.batch.model.Student;

/**
 * This is Optional, and called after item read but before item write.
 * It gives us the opportunity to perform a business logic on each item.
 * @author sahoora-nath
 *
 */
public class StudentItemProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student student) throws Exception {
		/*
         * Only return students which are equal or more than 60%
         *
         */
        if(student.getPercentage() < 75){
            return null;
        }
 
        return student;
	}

}
