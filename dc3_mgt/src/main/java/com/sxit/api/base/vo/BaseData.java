package com.sxit.api.base.vo;

public class BaseData {
	private String mobile;
	
	public BaseData(){}
	
	public BaseData(String mobile){
		this.mobile = mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getMobile(){
		return this.mobile;
	}
}
