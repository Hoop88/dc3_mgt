package com.sxit.api.base.vo;

public class Header {
	private String appid;
	private String echostr;
	private String signature;
	private String timestamp;
	private String nonce;
	private String sid;

	
	public Header(){}
	
	public Header(String appid, String echostr, String signature, String timestamp, String nonce, String sid){
		this.appid = appid;
		this.echostr = echostr;
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.sid = sid;
	}
	
	public void setAppid(String appid){
		this.appid = appid;
	}
	
	public String getAppid(){
		return this.appid;
	}
	
	public void setEchostr(String echostr){
		this.echostr = echostr;
	}
	
	public String getEchostr(){
		return this.echostr;
	}
	
	public void setSignature(String signature){
		this.signature = signature;
	}
	
	public String getSignature(){
		return this.signature;
	}
	
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	
	public String getTimestamp(){
		return this.timestamp;
	}
	
	public void setNonce(String nonce){
		this.nonce = nonce;
	}
	
	public String getNonce(){
		return this.nonce;
	}
	
	public void setSid(String sid){
		this.sid = sid;
	}
	
	public String getSid(){
		return this.sid;
	}
}
