package com.Identity.service;

import org.springframework.stereotype.Service;

import com.Identity.exceptions.ExceptionConstants;
import com.Identity.exceptions.IdentityException;

@Service
public class Validation {
	
	public boolean validateIdentityNumber(String id) throws IdentityException {
		if(id.isBlank()==true) {
			throw new IdentityException(ExceptionConstants.IDENTITY_NUMBER_EMPTY.toString());
		}
		if(id.matches("[0-9]{12}")==false) {
			throw new IdentityException(ExceptionConstants.IDENTITY_NUMBER_INVALID.toString());
		}
		return true;
	}
	
	public boolean validateName(String name) throws IdentityException{
		if(name.isBlank()==true) {
			throw new IdentityException(ExceptionConstants.NAME_EMPTY.toString());
		}
		if(name.matches("[a-zA-Z ]+")==false) {
			throw new IdentityException(ExceptionConstants.NAME_INVALID.toString());
		}
		return true;
	}
	
}
