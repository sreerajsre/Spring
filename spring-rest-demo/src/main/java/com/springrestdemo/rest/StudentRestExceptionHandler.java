package com.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springrestdemo.entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		StudentErrorResponse err = new StudentErrorResponse();
		err.setMessage(exc.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		StudentErrorResponse err = new StudentErrorResponse();
		err.setMessage(exc.getMessage());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(err,HttpStatus.BAD_REQUEST);
	}

}
