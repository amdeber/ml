package com.ml.clima.mapper;

import com.ml.clima.dto.DayWeatherDto;
import com.ml.clima.model.DayWeather;

public class UrlMapper {
	
	public static DayWeatherDto entityToDto(DayWeather dayWeather) {
		DayWeatherDto dto = new DayWeatherDto();
		dto.setDay(dayWeather.getDay());
		dto.setWeather(dayWeather.getWeather());
		return dto;
	}
	

}
