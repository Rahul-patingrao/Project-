package com.qsp.springbootemployee.exeption;

public class PhoneNotFound extends RuntimeException{
  
	String message;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public PhoneNotFound(String message) {
		super();
		this.message = message;
	}
	
}
