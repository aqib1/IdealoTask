package com.idealo.toyrobot.exceptions;

public class CordsOutOfBoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788250111181165726L;

	public CordsOutOfBoundException(String message) {
		super(message);
	}

	public CordsOutOfBoundException(String message, Throwable e) {
		super(message, e);
	}
}
