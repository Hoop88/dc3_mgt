package com.sxit.api.base.vo;

public class HttpBody {
	Object oHeader;
	Object oCommand; 
	Object oData;
	
	public HttpBody(){}
	
	public HttpBody(Object oHeader, Object oCommand, Object oData){
		this.oHeader = oHeader;
		this.oCommand = oCommand;
		this.oData = oData;
	}
	
	public void setHeader(Object oHeader){
		this.oHeader = oHeader;
	}
	
	public Object getHeader(){
		return this.oHeader;
	}
	
	public void setCmd(Object oCommand){
		this.oCommand = oCommand;
	}
	
	public Object getCmd(){
		return this.oCommand;
	}
	
	public void setData(Object oData){
		this.oData = oData;
	}
	
	public Object getData(){
		return this.oData;
	}
}


