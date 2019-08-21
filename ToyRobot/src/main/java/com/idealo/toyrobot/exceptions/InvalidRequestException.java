package com.idealo.toyrobot.exceptions;

public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2536496531908429514L;

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(String message, Throwable e) {
		super(message, e);
	}

}
