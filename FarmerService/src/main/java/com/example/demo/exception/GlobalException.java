package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFound ex, WebRequest req){
		ErrorDetails error = new ErrorDetails(ex.getMessage(),"404",new Date());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND); 
	}
	
	public ResponseEntity<ErrorDetails> dataAlreadyExists(DataAlreadyExists ex, WebRequest req){
		ErrorDetails error1 = new ErrorDetails(ex.getMessage(),"404",new Date());
		return new ResponseEntity<ErrorDetails>(error1,HttpStatus.ALREADY_REPORTED); 
	}
}
