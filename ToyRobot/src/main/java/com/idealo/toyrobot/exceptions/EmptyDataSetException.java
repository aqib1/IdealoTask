package com.idealo.toyrobot.exceptions;

public class EmptyDataSetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 941552931898971299L;

	public EmptyDataSetException(String message) {
		super(message);
	}

	public EmptyDataSetException(String message, Throwable e) {
		super(message, e);
	}
}
