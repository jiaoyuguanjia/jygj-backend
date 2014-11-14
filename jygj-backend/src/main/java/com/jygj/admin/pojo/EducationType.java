package com.jygj.admin.pojo;

public enum EducationType {

	YJS("研究生"),
	
	BK("本科"),
	
	DZ("大专"),
	
	GZ("高中");
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	private EducationType(String message) {
		this.message = message;
	}
	
	
	
}
