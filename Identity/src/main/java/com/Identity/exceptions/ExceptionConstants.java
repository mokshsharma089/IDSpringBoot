package com.Identity.exceptions;

public enum ExceptionConstants {
	
	IDENTITY_NUMBER_ALREADY_EXISTS("Id.Number.Exists.Already"),
	IDENTITY_NUMBER_EMPTY("Id.Number.Empty"),
	IDENTITY_NUMBER_INVALID("Id.Number.Invalid"),
	NAME_EMPTY("Name.Empty"),
	NAME_INVALID("Name.Invalid"),
	ID_NOT_FOUND("No.Record.With.Such.Id"),
	PHONE_NOT_FOUND("No.Record.With.Such.Phone.Number"),
	NAME_NOT_FOUND("No.Record.With.Such.Name");
	
	private final String type;
	private ExceptionConstants(String type) {
		this.type=type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
