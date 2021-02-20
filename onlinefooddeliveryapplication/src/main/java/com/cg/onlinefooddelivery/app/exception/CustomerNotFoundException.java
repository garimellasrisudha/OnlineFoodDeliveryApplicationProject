package com.cg.onlinefooddelivery.app.exception;

public class CustomerNotFoundException extends RuntimeException{
 

public CustomerNotFoundException(String message) {
	super(message);
}

public CustomerNotFoundException() {
	
}
}
