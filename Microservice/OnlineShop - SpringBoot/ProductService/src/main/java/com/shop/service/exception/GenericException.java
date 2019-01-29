package com.shop.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenericException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public GenericException(String message) {
		super(message);
	}
}
