package com.bcnc.album.infrastructure.common.exceptions;


/**
 * Core checked exception in application
 * 
 * @author BCNC
 * @since 1.0.0
 */
public class CoreException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 14443223432L;
	
	/** Custom error message to show */
	private final String errorMessage;

	/**
	 * Instantiates a new core exception.
	 *
	 * @param message the message
	 */
	public CoreException(String message) {
		super(message);
		this.errorMessage = message;
	}
	
	
	/**
	 * Returns the error message of the exception
	 * 
	 * @return String with error message or null if not defined
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
