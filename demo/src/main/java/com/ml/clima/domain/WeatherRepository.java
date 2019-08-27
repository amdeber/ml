package com.ml.clima.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Service;

import com.ml.clima.model.DayWeather;


@Service
public interface WeatherRepository extends Repository<DayWeather, Long>{
	
	DayWeather findByDay(Long day);
	
	Long countByWeather(String weather);
	
}
