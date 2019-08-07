package com.mho.portfolio.advice.exception;

public class LoginFailException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LoginFailException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public LoginFailException(String msg) {
		super(msg);
	}
	
	public LoginFailException() {
		super();
	}
	
	
}
