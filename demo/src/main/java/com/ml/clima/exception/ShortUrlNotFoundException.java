package com.ml.clima.exception;

public class ShortUrlNotFoundException extends RuntimeException {

	public ShortUrlNotFoundException(String url) {
		super("Short url not found : " + url);
	}

}
