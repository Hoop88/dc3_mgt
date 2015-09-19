package com.sxit.test;

public class Test1 {
	
	public static void main(String[] args) {
		
		String key = "."+"System.Department";
		key = key.replaceAll("\\.", "\\/");
		
		System.out.println(key);
	}

}
