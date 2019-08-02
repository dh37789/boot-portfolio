package com.mho.portfolio.advice.exception;

public class AuthenticationEntryPointException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AuthenticationEntryPointException(String msg, Throwable t) {
		super(msg, t);
	}
	public AuthenticationEntryPointException(String msg) {
		super(msg);
	}
	public AuthenticationEntryPointException() {
		super();
	}
}
