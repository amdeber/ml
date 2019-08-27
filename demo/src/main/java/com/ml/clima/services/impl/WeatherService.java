package com.ml.clima.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.clima.constants.WeatherContants;
import com.ml.clima.dao.day.DayWeatherDao;
import com.ml.clima.domain.WeatherRepository;
import com.ml.clima.dto.WeatherResultDto;
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

	@Override
	public WeatherResultDto getCountByWeathert() {
		WeatherResultDto wr = new WeatherResultDto();
		wr.setDroughtDays(weatherRepository.countByWeather(WeatherContants.DROUGHT));
		wr.setRainDays(weatherRepository.countByWeather(WeatherContants.RAIN));
		wr.setOptimalDays(weatherRepository.countByWeather(WeatherContants.OPTIMAL));
		return wr;
	}
}
