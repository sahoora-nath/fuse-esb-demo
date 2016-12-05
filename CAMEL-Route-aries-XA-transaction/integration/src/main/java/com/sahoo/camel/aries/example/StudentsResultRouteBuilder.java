package com.sahoo.camel.aries.example;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;

import com.sahoo.camel.aries.example.dao.StudentResultDao;
import com.sahoo.camel.aries.example.domain.StudentsResultDBO;

public class StudentsResultRouteBuilder extends SpringRouteBuilder {
	
	private StudentResultDao studentResultDao;
	
	@Override
	public void configure() throws Exception {
		from("amq://Input.Student?username=admin&password=admin")
		.transacted()
		.log("Message recevied from MQ - ${body}")
		.process(new Processor(){

			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.getOut().copyFrom(exchange.getIn());
				
				String studentName = exchange.getIn().getBody(String.class);
				
				StudentsResultDBO studentResult = new StudentsResultDBO();
				studentResult.setFirstName(studentName);
				studentResult.setLastName(studentName);
				studentResult.setDob(getRandomDOB());
				studentResult.setPercentage(getRandomPercentage());
				
				exchange.getOut().setBody(studentResult);
			}
		})
		.log("Sending Students data to persist. - ${body}")
		.to("jpa://com.sahoo.camel.aries.example.domain.StudentsResultDBO");
	}
	
	private Date getRandomDOB() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		Date date = Date.from(randomBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		return date;
	}
	
	private Double getRandomPercentage() {
		Random rand = new Random();
	    return rand.nextDouble() * 100;
	}

	public StudentResultDao getStudentResultDao() {
		return studentResultDao;
	}

	public void setStudentResultDao(StudentResultDao studentResultDao) {
		this.studentResultDao = studentResultDao;
	}
}
