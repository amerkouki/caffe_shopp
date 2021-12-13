package com.kouki.demo.error;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException{

	public ApiBaseException(String message ) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	public abstract HttpStatus getStatusCode();
}
