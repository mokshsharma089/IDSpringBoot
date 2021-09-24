package com.Identity.exceptions;

public class IdentityException extends Exception{

	//have to add this otherwise eclipse/STS show error
	private static final long serialVersionUID = 1L;
	
	
	public IdentityException(String message) {
		super(message);
	}

	
}
