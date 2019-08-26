package com.ml.clima.jobs;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewDayTask {
		
	private static final Logger logger = LoggerFactory.getLogger(NewDayTask.class);
	
	//Fires at 12pm everyday.
	@Scheduled(cron = "0 0 12 * * ?")
	public void run() {
	    logger.info("Current time is :: " + Calendar.getInstance().getTime());
	}

}
