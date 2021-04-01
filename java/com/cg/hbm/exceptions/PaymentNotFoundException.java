package com.cg.hbm.exceptions;

public class PaymentNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public 	PaymentNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public PaymentNotFoundException() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
