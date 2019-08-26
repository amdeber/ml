package com.ml.clima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.clima.dto.DayWeatherDto;
import com.ml.clima.mapper.DayWeatherMapper;
import com.ml.clima.model.DayWeather;
import com.ml.clima.services.interfaces.IWeatherService;


@RestController
@RequestMapping("/clima")
public class DayController {
	
    @Autowired
    IWeatherService weatherService;
    
	//TODO Add in request defaultValue= 
	@RequestMapping(value = "{day}", method = RequestMethod.GET)
    public DayWeatherDto getByDate(@PathVariable("day") Long day) {
        return DayWeatherMapper.entityToDto(weatherService.getByDay(day));
    }
    	
}
