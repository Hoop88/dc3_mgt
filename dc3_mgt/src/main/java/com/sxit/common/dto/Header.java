package com.sxit.common.dto;

public class Header {
	private long code;
	private String message;

	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Header(long code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
