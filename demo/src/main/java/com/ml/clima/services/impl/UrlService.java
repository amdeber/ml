package com.ml.clima.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.clima.constants.WeatherContants;
import com.ml.clima.dao.day.DayWeatherDao;
import com.ml.clima.dao.url.UrlDao;
import com.ml.clima.domain.UrlRepository;
import com.ml.clima.domain.WeatherRepository;
import com.ml.clima.dto.UrlDto;
import com.ml.clima.dto.WeatherResultDto;
import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Url;
import com.ml.clima.services.interfaces.IUrlService;
import com.ml.clima.services.interfaces.IWeatherService;

@Service
public class UrlService implements IUrlService {

	@Autowired
	UrlDao urlDao;

	@Override
	public UrlDto getLongUrl(String shortUrl) {
		Url url = urlDao.getFindByShortUrl(shortUrl);
		return new UrlDto(url.getUrlLong(), url.getUrlShort());
	}

	@Override
	public UrlDto getShortUrl(String longUrl) {
		Url url = urlDao.getFindByLongUrl(longUrl);
		return new UrlDto(url.getUrlLong(), url.getUrlShort());
	}


}
