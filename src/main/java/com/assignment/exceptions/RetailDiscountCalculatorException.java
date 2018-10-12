package com.assignment.exceptions;

public class RetailDiscountCalculatorException extends RuntimeException{


	private static final long serialVersionUID = 7718828512143293558L;
	
	private final ErrorCode code;

	public RetailDiscountCalculatorException(ErrorCode code) {
		super();
		this.code = code;
	}
	public RetailDiscountCalculatorException(ErrorCode code, Throwable throwable) {
		super(throwable);
		this.code = code;
	}
	public ErrorCode getCode() {
		return this.code;
	}

}
