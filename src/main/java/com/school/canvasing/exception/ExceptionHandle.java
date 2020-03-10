package com.school.canvasing.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.school.canvasing.common.Constants;

@RestController
@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);
	

	@ExceptionHandler(LoginException.class)
	public final ResponseEntity<ErrorResponse> handleLoginException(
			LoginException exception, WebRequest request) {
		LOGGER.info("Exceptin cause: "+exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED, exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotException(
			UserNotException exception, WebRequest request) {
		LOGGER.info("Exceptin cause: "+exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED,exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentException.class)
	public final ResponseEntity<ErrorResponse> handleStudentException(
			StudentException exception, WebRequest request) {
		LOGGER.info("Exceptin cause: "+exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED,exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(InValidInputException.class)
	public final ResponseEntity<ErrorResponse> handleInValidInputException(
			InValidInputException exception, WebRequest request) {
		LOGGER.info("Exceptin cause: "+exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED,exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
