package com.ml.clima.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.day.DayWeatherDao;
import com.ml.clima.domain.WeatherRepository;
import com.ml.clima.model.DayWeather;
import com.ml.clima.services.interfaces.IWeatherService;

@Service
public class WeatherService implements IWeatherService {
	
	@Autowired
	WeatherRepository weatherRepository;
	
	@Autowired
	DayWeatherDao dateRepository;

	@Override
	public DayWeather getByDay(Long day) {
		return weatherRepository.findByDay(day);
	}
	
//	public void insertDate(Date date) {
//	    dateRepository.insertWithEntityManager(date);
//	}

}
