package com.ml.clima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ml.clima.dto.DayWeatherDto;
import com.ml.clima.dto.UrlDto;
import com.ml.clima.dto.WeatherResultDto;
import com.ml.clima.mapper.DayWeatherMapper;
import com.ml.clima.mapper.UrlMapper;
import com.ml.clima.model.Url;
import com.ml.clima.services.interfaces.IUrlService;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    IUrlService urlService;
    
    @RequestMapping(value="/long/{longUrl}", method = RequestMethod.GET)
    public UrlDto getLongUrl(@PathVariable("shortUrl") String url) {
    	Url urlExist = urlService.getLongUrl(url);
    	if (urlExist == null)
    		throw new ResponseStatusException(
    	 	           HttpStatus.NOT_FOUND, "Short Url Not Found", new Exception());  	
    	return UrlMapper.entityToDto(urlService.getLongUrl(url));
    }
	
	@RequestMapping(value="/short/{longUrl}", method = RequestMethod.GET)
    public UrlDto getShortUrl(@PathVariable("longUrl") Long day) {
        return null; //weatherService.getCountByWeathert();
    }
	
	
}
