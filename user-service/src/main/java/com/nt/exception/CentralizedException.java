package com.nt.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedException {

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<?> userNotFound(UserIdNotFoundException ex) {
		
	ErrorCode ecode =	new ErrorCode(ex.getMessage(),LocalDateTime.now(),404);
		
		return new ResponseEntity<>(ecode,HttpStatus.NOT_FOUND);

	}

}
