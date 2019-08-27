package com.ml.clima.services.interfaces;

import com.ml.clima.dto.WeatherResultDto;
import com.ml.clima.model.DayWeather;

public interface IWeatherService {

	DayWeather getByDay(Long id);

	WeatherResultDto getCountByWeathert();

}
