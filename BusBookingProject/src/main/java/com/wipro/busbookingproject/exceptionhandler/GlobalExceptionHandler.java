package com.wipro.busbookingproject.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(reason = "BusId not found", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public void exceptionHandler() {
		
	}
	
	@ResponseStatus(reason = "BusId not found to delete", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BusIdNotFoundException.class)
	public void exceptionDeleteHandler() {
		
	}

}
