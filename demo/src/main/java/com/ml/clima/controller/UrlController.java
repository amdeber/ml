package com.ml.clima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.clima.dto.DayWeatherDto;
import com.ml.clima.dto.UrlDto;
import com.ml.clima.dto.WeatherResultDto;
import com.ml.clima.mapper.DayWeatherMapper;
import com.ml.clima.services.interfaces.IWeatherService;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    IWeatherService weatherService;
    
    @RequestMapping(value="/long/{longUrl}", method = RequestMethod.GET)
    public UrlDto getLongUrl(@PathVariable("shortUrl") String url) {
        return null; //DayWeatherMapper.entityToDto(weatherService.getByDay(url));
    }
	
	@RequestMapping(value="/short/{longUrl}", method = RequestMethod.GET)
    public UrlDto getShortUrl(@PathVariable("longUrl") Long day) {
        return null; //weatherService.getCountByWeathert();
    }
	
	
}
