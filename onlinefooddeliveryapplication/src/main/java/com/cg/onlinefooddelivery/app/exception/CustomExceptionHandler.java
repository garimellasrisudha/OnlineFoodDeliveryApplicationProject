package com.cg.onlinefooddelivery.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<?> handleRestaurantNotFoundException(Exception ex,WebRequest request)
	{
		CustomerNotFoundExceptionResponse customerNotFoundException=new CustomerNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(customerNotFoundException,HttpStatus.BAD_REQUEST);
	}
	

}
