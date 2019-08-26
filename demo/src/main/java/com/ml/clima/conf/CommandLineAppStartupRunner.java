package com.ml.clima.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ml.clima.services.interfaces.IWeatherCreatorService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	private IWeatherCreatorService WeatherCreatorService;

	@Override
	public void run(String... args) throws Exception {
		WeatherCreatorService.createInicialDays(); 
	}

}
