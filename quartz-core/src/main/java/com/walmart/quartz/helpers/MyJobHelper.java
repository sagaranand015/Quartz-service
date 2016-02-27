package com.walmart.quartz.helpers;

public class MyJobHelper {

	private String someStr;

	public MyJobHelper(String someStr) {
		this.someStr = someStr;
	}
	
	public String getSomeStr() {
		return someStr;
	}

	public void setSomeStr(String someStr) {
		this.someStr = someStr;
	}

}
