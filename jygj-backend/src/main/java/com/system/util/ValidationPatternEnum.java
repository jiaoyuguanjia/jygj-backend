package com.system.util;

public enum ValidationPatternEnum {
	MOBILE_PHONE_CN("^1\\d{10}$"),
	FIXED_PHONE_CN("^(0\\d{2,3}-)?[1-9]\\d{5,7}(-\\d{1,4})?$"),
	MAIL("^[a-zA-Z0-9_+.-]+\\@([a-zA-Z0-9-]+\\.){1,}[a-zA-Z0-9]{2,4}$"),
	;

	private String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	private ValidationPatternEnum(String pattern) {
		this.pattern = pattern;
	}
	
	

}
