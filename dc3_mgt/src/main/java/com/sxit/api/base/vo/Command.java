package com.sxit.api.base.vo;

public class Command {
	private String name;
	
	public Command(){}
	
	public Command(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
