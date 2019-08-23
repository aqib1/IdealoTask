package com.idealo.toyrobot.exceptions;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 *
 */
public class RobotNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3822185561376995140L;

	/**
	 * @param message
	 */
	public RobotNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public RobotNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
