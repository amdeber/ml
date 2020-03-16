package com.ml.clima.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.clima.dto.UrlDto;
import com.ml.clima.exception.ShortUrlNotFoundException;
import com.ml.clima.exception.URLNoValidException;
import com.ml.clima.exception.UrlNullPointerException;
import com.ml.clima.mapper.UrlMapper;
import com.ml.clima.model.Url;
import com.ml.clima.services.interfaces.IUrlService;
import com.ml.clima.utils.UrlUtils;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    IUrlService urlService;
    
    @RequestMapping(value="/long", method = RequestMethod.POST)
    public UrlDto getLongUrl(@RequestBody String url, HttpServletRequest request) {
    	urlParamsIsNull(url);
    	urlNotValid(url);
    	Url urlExist = urlService.getLongUrl(url);
    	urlNoExistInDB(urlExist, url);
    	return UrlMapper.entityToDto(urlExist);
    }
	
	@RequestMapping(value="/short", method = RequestMethod.POST)
    public UrlDto getShortUrl(@RequestBody String url, HttpServletRequest request) {
		urlParamsIsNull(url);	
		urlNotValid(url);
        return UrlMapper.entityToDto(urlService.getShortUrl(url));
    }
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public String deleteFromShortUrl(@RequestBody String url, HttpServletRequest request) {
		urlParamsIsNull(url);	
		urlNotValid(url);
		Url urlExist = urlService.getLongUrl(url);
		urlNoExistInDB(urlExist, url);
        return urlService.deleteShortUrl(url) > 0 ? "URL deleted" : "Url not deleted!";
    }
	
	private void urlParamsIsNull(String url) {
		if (url == null)
    		throw new UrlNullPointerException(); 
	}
	
	private void urlNotValid(String url) {
		if (!UrlUtils.getInstance().isUrlValid(url))
    		throw new URLNoValidException(url); 
	}
	
	private void urlNoExistInDB(Url urlDB, String url) {
		if (urlDB == null)
    		throw new ShortUrlNotFoundException(url); 
	}
	
	
	
}
