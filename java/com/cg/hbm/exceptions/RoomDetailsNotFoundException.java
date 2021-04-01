package com.cg.hbm.exceptions;

public class RoomDetailsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RoomDetailsNotFoundException(String message) {
		super("RoomDetails not found");
	}

}
