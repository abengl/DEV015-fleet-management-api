package com.fleetmanagement.api_rest.exception;

public class CustomBadRequestException extends RuntimeException {

	public CustomBadRequestException(String message) {
		super(message);
	}
}
