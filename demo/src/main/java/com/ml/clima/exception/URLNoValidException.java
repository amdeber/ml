package com.ml.clima.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class URLNoValidException extends RuntimeException {

	public URLNoValidException(String url) {
		super("URL is not valid : " + url);
	}

}
