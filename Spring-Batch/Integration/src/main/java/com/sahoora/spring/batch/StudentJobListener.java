package com.sahoora.spring.batch;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class StudentJobListener implements JobExecutionListener {
	final static Logger logger = LoggerFactory.getLogger(StudentJobListener.class);
	private LocalDateTime startTime, stopTime;
	
	@Override
	public void afterJob(JobExecution arg0) {
		LocalDateTime startTime = LocalDateTime.now();
        logger.info("Job starts at :"+startTime);
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		stopTime = LocalDateTime.now();
        logger.info("Job stops at : {}", stopTime);
        logger.info("Total time take in millis : {}", ChronoUnit.SECONDS.between(startTime, stopTime));
	}
}
