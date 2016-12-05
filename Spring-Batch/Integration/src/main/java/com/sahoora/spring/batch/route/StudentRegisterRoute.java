package com.sahoora.spring.batch.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Students route to start spring batch scheduler.
 * @author sahoora-nath
 *
 */
public class StudentRegisterRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//cron=0+0/5+12-18+?+*+MON-FRI - five minutes starting at 12pm (noon) to 6pm on weekdays
		//corn=0+0/1+*+1/1+*+?+* - evenry minute
		
		from("quartz2://studentGroup/studentRegisterName?cron=0+0/1+*+1/1+*+?+*")
		.log("Student Result Batch started.")
		.to("spring-batch:studentJob");
	}
}