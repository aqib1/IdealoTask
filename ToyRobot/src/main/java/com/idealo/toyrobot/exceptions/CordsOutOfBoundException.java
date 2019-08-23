package com.idealo.toyrobot.exceptions;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public class CordsOutOfBoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788250111181165726L;

	/**
	 * @param message
	 */
	public CordsOutOfBoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public CordsOutOfBoundException(String message, Throwable e) {
		super(message, e);
	}
}
