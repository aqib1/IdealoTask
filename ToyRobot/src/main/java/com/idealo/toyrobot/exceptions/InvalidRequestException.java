package com.idealo.toyrobot.exceptions;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 *
 */
public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2536496531908429514L;

	/**
	 * @param message
	 */
	public InvalidRequestException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public InvalidRequestException(String message, Throwable e) {
		super(message, e);
	}

}
