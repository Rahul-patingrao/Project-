package com.qsp.springbootemployee.exeption;

public class EmailNotFound extends RuntimeException{

	String message;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public EmailNotFound(String message) {
		super();
		this.message = message;
	}
	
}
