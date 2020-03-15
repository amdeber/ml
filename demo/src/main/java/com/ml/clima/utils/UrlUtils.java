package com.ml.clima.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import com.google.appengine.repackaged.com.google.common.hash.Hashing;

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
		String shortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		return "https://me.li/" + shortUrl;
	}
	
}
