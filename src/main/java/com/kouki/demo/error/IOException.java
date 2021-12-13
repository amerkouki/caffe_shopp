package com.kouki.demo.error;

import org.springframework.http.HttpStatus;

public class IOException extends ApiBaseException{

	public IOException(String message) {
		super(message);
	}
	
	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}
}
