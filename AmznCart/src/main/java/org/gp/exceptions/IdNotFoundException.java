package org.gp.exceptions;

public class IdNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid ID Entered";
	}

}
