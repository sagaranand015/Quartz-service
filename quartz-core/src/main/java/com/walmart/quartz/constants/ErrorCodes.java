package com.walmart.quartz.constants;

public enum ErrorCodes {
	
	DUMMY_RESPONSE(200),
	SUCCESS_RESPONSE(200),
	ERROR_RESPONSE(400);
	
	private final Integer value;

    private ErrorCodes(Integer value) {
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
	
}
