package com.ml.clima.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.validator.UrlValidator;

import com.google.common.hash.Hashing;


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
	
}
