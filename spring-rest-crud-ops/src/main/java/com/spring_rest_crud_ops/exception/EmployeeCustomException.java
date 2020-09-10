package com.spring_rest_crud_ops.exception;

public class EmployeeCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeCustomException() {
	}

	public EmployeeCustomException(String message) {
		super(message);
	}

	public EmployeeCustomException(Throwable cause) {
		super(cause);
	}

	public EmployeeCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeCustomException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
