package com.ml.clima.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.print.attribute.URISyntax;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ml.clima.model.Url;
import com.ml.clima.services.interfaces.IUrlService;
import com.ml.clima.utils.UrlUtils;

@RestController
public class UrlRedirect {

	@Autowired
	IUrlService urlService;

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ResponseEntity<Object> redirectToExternalUrl(@PathVariable("url") String url) throws URISyntaxException {
		UrlUtils.getInstance().urlParamsIsNull(url);
		Url urlExist = urlService.getLongUrlWithCounter("https://me.li/" + url);
		UrlUtils.getInstance().urlNoExistInDB(urlExist, url);
		URI uri = new URI(urlExist.getLongUrl());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}

