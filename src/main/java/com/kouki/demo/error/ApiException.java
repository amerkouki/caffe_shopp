package com.kouki.demo.error;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ApiBaseException.class)
	public ResponseEntity<ErrorDetails> handleApiException(ApiBaseException ex , WebRequest request){
		ErrorDetails error=new ErrorDetails(ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,ex.getStatusCode());
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		ValidationError validationError=new ValidationError();
		validationError.setUrl(request.getDescription(false));
		List<FieldError> field=(List<FieldError>) ex.getBindingResult().getFieldError();
		
		for(FieldError f: field) {
			validationError.addError(f.getDefaultMessage());
		}
		return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);
	}
}
