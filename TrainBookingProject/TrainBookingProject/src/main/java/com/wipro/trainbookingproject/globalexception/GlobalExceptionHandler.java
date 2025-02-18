package com.wipro.trainbookingproject.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wipro.trainbookingproject.exception.DeleteIdNotFoundException;
import com.wipro.trainbookingproject.exception.TrainIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(reason = "Id is not found to get", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrainIdNotFoundException.class)
	public void findTrainById() {
		
	}
	
	@ResponseStatus(reason = "Id is not found to delete", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(DeleteIdNotFoundException.class)
	public void DeleteTrainById() {
		
	}
}
