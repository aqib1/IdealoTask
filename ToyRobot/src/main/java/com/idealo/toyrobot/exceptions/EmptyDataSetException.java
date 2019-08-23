package com.idealo.toyrobot.exceptions;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 */
public class EmptyDataSetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 941552931898971299L;

	/**
	 * @param message
	 */
	public EmptyDataSetException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public EmptyDataSetException(String message, Throwable e) {
		super(message, e);
	}
}
