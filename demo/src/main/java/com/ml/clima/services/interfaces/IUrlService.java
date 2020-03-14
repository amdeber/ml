package com.ml.clima.services.interfaces;

import com.ml.clima.dto.UrlDto;
import com.ml.clima.dto.WeatherResultDto;
import com.ml.clima.model.DayWeather;

public interface IUrlService {

	UrlDto getLongUrl(String shortUrl);

	UrlDto getShortUrl(String longUrl);

}
