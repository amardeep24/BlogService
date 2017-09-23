/**
 * 
 */
package com.amardeep.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amardeep.blog.api.ErrorApi;

/**
 * @author AMARDEEP
 *
 */
@ControllerAdvice
public class ExceptionResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorApi> handleIllegalArgumentException(IllegalArgumentException iae){
		logger.error("####handleIllegalArgumentException invoked with exception####",iae.getMessage());
		ErrorApi error=new ErrorApi().setExceptionMessage(iae.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
