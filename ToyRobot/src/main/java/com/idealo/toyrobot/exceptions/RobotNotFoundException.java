package com.idealo.toyrobot.exceptions;

public class RobotNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3822185561376995140L;

	public RobotNotFoundException(String message) {
		super(message);
	}

	public RobotNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
