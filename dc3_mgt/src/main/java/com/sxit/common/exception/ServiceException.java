package com.sxit.common.exception;

/**
 * @author wuyiming
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 6743245603899074353L;

	public ServiceException() {
		super();
	}

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}
}
