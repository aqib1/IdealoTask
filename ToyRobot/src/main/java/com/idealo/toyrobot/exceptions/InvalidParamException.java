package com.idealo.toyrobot.exceptions;

public class InvalidParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2842931377050485340L;

	public InvalidParamException(String message) {
		super(message);
	}

	public InvalidParamException(String message, Throwable e) {
		super(message, e);
	}

}
