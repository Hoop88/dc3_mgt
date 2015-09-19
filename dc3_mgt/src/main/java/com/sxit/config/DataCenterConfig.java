package com.sxit.config;

import java.util.Properties;

public class DataCenterConfig {
 
	public static String apiurl= "";
	public static String appid = "";
	public static String token = "";
	
	static{
		try{
			Properties prop = new Properties();
			prop.load(DataCenterConfig.class
					.getResourceAsStream("/conf/datacenter.properties"));
			apiurl = prop.getProperty("apiurl");
			appid = prop.getProperty("appid");
			token = prop.getProperty("token");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
