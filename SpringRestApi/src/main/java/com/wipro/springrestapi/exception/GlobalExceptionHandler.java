package com.wipro.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ResponseStatus(reason = "Empno not found in Employee", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public void exceptionHandler() {
		
	}
	
}
