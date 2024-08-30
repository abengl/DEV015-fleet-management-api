package com.fleetmanagement.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
		String htmlResponse = "<html><body><h1>404 Not Found</h1><p>The requested resource was not found.</p></body></html>";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(htmlResponse);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		String htmlResponse = "<html><body><h1>400 Bad Request</h1><p>" + ex.getMessage() + "</p></body></html>";
		return ResponseEntity.badRequest().body(htmlResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		String htmlResponse = "<html><body><h1>500 Internal Server Error</h1><p>An unexpected error occurred.</p></body></html>";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(htmlResponse);
	}
}
