package com.ml.clima.mapper;

import com.ml.clima.dto.UrlDto;
import com.ml.clima.model.Url;

public class UrlMapper {
	
	public static UrlDto entityToDto(Url url) {
		return new UrlDto(url.getLongUrl(), url.getShortUrl(), url.getClic());
	}
	

}
