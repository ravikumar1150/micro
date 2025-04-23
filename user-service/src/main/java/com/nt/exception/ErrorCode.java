package com.nt.exception;

import java.time.LocalDateTime;

public class ErrorCode {

	private String message;

	private LocalDateTime date;

	private int statusCode;

	public ErrorCode(String message, LocalDateTime date, int statusCode) {
		super();
		this.message = message;
		this.date = date;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ErrorCode [message=" + message + ", date=" + date + ", statusCode=" + statusCode + "]";
	}

	
	
}
