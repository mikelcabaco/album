package com.bcnc.album.infrastructure.common.exceptions.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bcnc.album.infrastructure.common.exceptions.BadRequestException;
import com.bcnc.album.infrastructure.common.exceptions.model.ApiError;

/**
 * Handles all type of exception and return appropriate response type
 * 
 * @author BCNC
 * @since 1.0.0
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Handles internal server errors.
	 *
	 * @param ex the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler()
	public ResponseEntity<Object> handleInternalServerError(RuntimeException ex, WebRequest request) {
		var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		
		String message = String.valueOf(httpStatus.value());
		var apiError = createApiError(httpStatus, message);
		
		return handleExceptionInternal(ex, apiError, new HttpHeaders(), httpStatus, request);
	}
	
	
	/**
	 * Handle bad request exceptions.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ BadRequestException.class })
	public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
		var httpStatus = HttpStatus.BAD_REQUEST;
		var apiError = createApiError(httpStatus, ex.getErrorMessage());
		
		if (null != ex.getErrors() && ex.getErrors().hasErrors()) {
			List<Map<String, List<Object>>> errors = new ArrayList<>();
			for (ObjectError error : ex.getErrors().getAllErrors()) {
				List<Object> errArgs = null;
				if (null != error.getArguments()) {
					errArgs = Arrays.asList(error.getArguments());
				}
				Map<String, List<Object>> errPair = Map.of(error.getCode(), errArgs);
				errors.add(errPair);
			}
			apiError.setErrors(errors);
		}	
		return handleExceptionInternal(ex, apiError, new HttpHeaders(), httpStatus, request);
	}
	
	
	private ApiError createApiError(HttpStatus status, String message, String... errors) {
		return new ApiError(status, message, errors);
	}
}
