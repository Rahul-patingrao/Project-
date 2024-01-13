package com.qsp.springbootemployee.exeption;

public class EmployeeListNotFound extends RuntimeException{

		String	message;
		@Override
		public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
		}
		public EmployeeListNotFound(String message) {
			super();
			this.message = message;
		}
		
}
