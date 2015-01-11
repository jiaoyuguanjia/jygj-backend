package com.system.util;

public enum CommonResult {
	SUCCESS(0),
	/**input error and other error**/
	ERROR(-1),
	/**codes error and system error, codes may need to be updated**/
	EXCEPTION(-2), 
	
	NOT_FOUND(1),
	
	ALREADY_EXISTS(2),
	
	MISSING_PARAM(3),
	
	ACCESS_DENIED(4),
	
	HAVE_UPDATES(5),
	
	NOT_START(6),
	
	IN_PROCESS(7),
	
	SITE_DISABLED(10),
	;
	
	private int code;
	private String msg;

	private CommonResult(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
