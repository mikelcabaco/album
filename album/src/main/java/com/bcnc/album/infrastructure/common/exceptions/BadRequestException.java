package com.bcnc.album.infrastructure.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import lombok.Getter;


/**
 * Web exception for rest operation that has bad request or invalid input data
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Getter
public class BadRequestException extends CoreException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 14443223429L;
	
	/** 
	 * The errors detected
	 * @return {@link Errors} the errors
	 */
	private final transient Errors errors;
	
	
	/**
	 * Instantiates a bad request exception with specified errors and default message.
	 *
	 * @param errors produced in request
	 */
	public BadRequestException(Errors errors) {
		super(HttpStatus.BAD_REQUEST.name());
		this.errors = errors;
	}

}
