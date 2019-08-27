package com.ml.clima.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ml.clima.services.interfaces.IWeatherCreatorService;

@Component
public class NewDayTask {
		
	private static final Logger logger = LoggerFactory.getLogger(NewDayTask.class);
	@Autowired
	IWeatherCreatorService weatherCreatorService;
	
	
	//Fires at 12pm everyday.
	@Scheduled(cron = "0 0 12 * * ?")
	public void run() {
		weatherCreatorService.createWeatherForSpecificDay();
	    logger.info("New day created");
	}

}
