package com.cg.onlinefooddelivery.app.exception;

public class CustomerNotFoundExceptionResponse {
	private String message;
	public CustomerNotFoundExceptionResponse(String message)
	{
		this.message=message;
				
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
