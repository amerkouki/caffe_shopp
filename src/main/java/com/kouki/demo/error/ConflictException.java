package com.kouki.demo.error;

import org.springframework.http.HttpStatus;

public class ConflictException  extends ApiBaseException{

	public ConflictException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}

	
}
