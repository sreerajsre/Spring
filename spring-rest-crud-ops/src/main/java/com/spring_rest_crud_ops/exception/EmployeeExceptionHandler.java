package com.spring_rest_crud_ops.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleExcpetion(EmployeeCustomException exception){
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleExcpetion(Exception exception){
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
}
