package com.eshoping.exception;

public class CustomerException extends RuntimeException{

	
public CustomerException() {
		super();
	}

public CustomerException(String message) {
		super();
		this.message = message;
	}

public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

private String message;


}
