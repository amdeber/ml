package com.ml.clima.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class UrlNullPointerException extends RuntimeException{
	public UrlNullPointerException() {
		super("The url cannot be null!");
	}

}
