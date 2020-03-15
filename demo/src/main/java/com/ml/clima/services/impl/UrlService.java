package com.ml.clima.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.url.UrlDao;
import com.ml.clima.dto.UrlDto;
import com.ml.clima.exception.ShortUrlNotFoundException;
import com.ml.clima.mapper.UrlMapper;
import com.ml.clima.model.Url;
import com.ml.clima.services.interfaces.IUrlService;
import com.ml.clima.utils.UrlUtils;

@Service
public class UrlService implements IUrlService {

	@Autowired
	UrlDao urlDao;

	@Override
	public Url getLongUrl(String shortUrl) {
		Url urlExist =  urlDao.getFindByShortUrl(shortUrl); 
		return urlDao.getFindByShortUrl(shortUrl) != null ? urlExist: null;
	}

	@Override
	public Url getShortUrl(String longUrl) {
		Url urlExist =  urlDao.getFindByLongUrl(longUrl); 
		if (urlExist != null) {
			return urlExist;
		}else {
			String shortUrl = UrlUtils.getInstance().transformLongToShorUrl(longUrl);
			Url urlNew = urlDao.create(new Url(longUrl, shortUrl));
			return urlNew;
		}
	}


}