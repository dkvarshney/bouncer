package com.dk.bouncer.exception;

public class BouncerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BouncerException(String message) {
		super(message);
	}
	
	public static BouncerException withMessage(String message) {
		return new BouncerException(message);
	}
}
