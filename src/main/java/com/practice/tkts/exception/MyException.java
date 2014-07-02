package com.practice.tkts.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class MyException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 94519047919775340L;

	private String errorCode;
	private String errorMessage;
	
	public MyException(String errorCode, String errorMessage)
	{
		super(Response.status(Integer.parseInt(errorCode)).
				entity(new ErrorBean(errorCode,errorMessage)).type("application/json").
				build());
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
