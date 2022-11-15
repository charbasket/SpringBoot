package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

// Vamos a crear nuestra propia clase para los detalles de error
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
