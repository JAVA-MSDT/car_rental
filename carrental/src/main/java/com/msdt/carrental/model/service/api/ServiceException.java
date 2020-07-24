package com.msdt.carrental.model.service.api;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2119893329437972051L;

	public ServiceException() {
		super();
	}

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final Throwable cause) {
		super(cause);
	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
