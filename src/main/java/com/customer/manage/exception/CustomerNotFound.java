package com.customer.manage.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFound extends RuntimeException {
	 public CustomerNotFound(String message){
		    super(message);
		  }

	/*
	 * @Override public HttpHeaders getResponseHeaders() { // return response
	 * headers }
	 */
}
