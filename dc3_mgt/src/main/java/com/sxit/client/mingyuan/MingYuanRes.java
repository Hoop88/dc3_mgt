package com.sxit.client.mingyuan;

public class MingYuanRes {

	private String errorcode; // 客户名
	private String message; // 性别
	private String status; //状态

	public MingYuanRes(String errorcode, String message) {
		super();
		this.errorcode = errorcode;
		this.message = message;
	}

	public MingYuanRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
