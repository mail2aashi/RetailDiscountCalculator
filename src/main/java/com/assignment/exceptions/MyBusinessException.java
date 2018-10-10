package com.assignment.exceptions;

public class MyBusinessException extends RuntimeException{


	private static final long serialVersionUID = 7718828512143293558L;
	
	private final ErrorCode code;

	public MyBusinessException(ErrorCode code) {
		super();
		this.code = code;
	}

	public ErrorCode getCode() {
		return this.code;
	}

}
