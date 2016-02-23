package com.walmart.quartz.constants;

public enum ErrorMessages {

	DUMMY_RESPONSE("Dummy response."), 
	SUCCESS_RESPONSE("The request was successful."), 
	ERROR_RESPONSE("Error in getting the response.");

	private final String value;

	private ErrorMessages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
