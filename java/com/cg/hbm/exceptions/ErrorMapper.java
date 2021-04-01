package com.cg.hbm.exceptions;
/**
 * 
 * @author Harshitha
 *
 */

public class ErrorMapper {
	
	private int errorCode;
	private String errorMessage;
	/**
	 * 
	 * @return int
	 */
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * 
	 * @return String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
