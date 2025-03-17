package com.eshoping.exception;

public class ProductException extends RuntimeException{
	public ProductException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	public ProductException(String message) {
		super();
		this.message = message;
	}

}
