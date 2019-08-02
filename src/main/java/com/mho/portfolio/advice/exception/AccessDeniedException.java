package com.mho.portfolio.advice.exception;

public class AccessDeniedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccessDeniedException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public AccessDeniedException(String msg) {
		super(msg);
	}
	
	public AccessDeniedException() {
		super();
	}

}
