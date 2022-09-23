package com.example.demo.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.ALREADY_REPORTED)
public class DataAlreadyExists extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAlreadyExists(String m)
	{
		super(m);
	}
}
