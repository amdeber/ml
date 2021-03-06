package com.ml.clima.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShortUrlNotFoundException extends RuntimeException {

	public ShortUrlNotFoundException(String url) {
		super("Short url not found : " + url);
	}

}
