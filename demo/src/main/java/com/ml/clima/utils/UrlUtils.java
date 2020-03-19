package com.ml.clima.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.validator.UrlValidator;

import com.google.common.hash.Hashing;
import com.ml.clima.exception.ShortUrlNotFoundException;
import com.ml.clima.exception.URLNoValidException;
import com.ml.clima.exception.UrlNullPointerException;
import com.ml.clima.model.Url;


public class UrlUtils {

	private static UrlUtils INSTANCE;

	private UrlUtils() {
	}

	public static UrlUtils getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UrlUtils();
		}

		return INSTANCE;
	}

	public String urlWithoutDomain(String url){
		try {
			URI uri = new URI(url);
			String domain = "https://" + uri.getHost();
			return url.replace(domain, "");
		} catch (URISyntaxException e) {
			return "";
		}	
	}
	
	public String transformLongToShorUrl(String url) {
		return "https://me.li/" + Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
	}
	
	public boolean isUrlValid(String url){
		String[] schemes = {"http","https"}; 
		UrlValidator urlValidator = new UrlValidator(schemes);
		return urlValidator.isValid(url);
	}
	
	public void urlParamsIsNull(String url) {
		if (url == null)
    		throw new UrlNullPointerException(); 
	}
	
	public void urlNotValid(String url) {
		if (!UrlUtils.getInstance().isUrlValid(url))
    		throw new URLNoValidException(url); 
	}
	
	public void urlNoExistInDB(Url urlDB, String url) {
		if (urlDB == null)
    		throw new ShortUrlNotFoundException(url); 
	}
	
	
}
