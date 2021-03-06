package com.atos.springboot.exceptions;

public class ServiceException extends RuntimeException {

	
	private static final long	serialVersionUID	= 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
