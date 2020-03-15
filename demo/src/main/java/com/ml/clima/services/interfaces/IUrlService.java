package com.ml.clima.services.interfaces;

import com.ml.clima.model.Url;

public interface IUrlService {

	Url getLongUrl(String shortUrl);

	Url getShortUrl(String longUrl);

}
