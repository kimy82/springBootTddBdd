package com.atos.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.atos.springboot.exceptions.ServiceException;

@ControllerAdvice
public class NotAllowedExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(ServiceException.class)
	public String handleNoMoreCustomWords() {
		return "error";
	}
	
}
