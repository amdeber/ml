package com.ml.clima.services.interfaces;

import com.ml.clima.model.DayWeather;

public interface IWeatherService {

	DayWeather getByDay(Long id);

}
