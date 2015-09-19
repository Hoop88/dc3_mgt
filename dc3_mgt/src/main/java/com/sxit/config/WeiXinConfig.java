package com.sxit.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 用于查询明源客户信息和会员信息的接口url
 * 
 * @author agu
 * 
 */
public class WeiXinConfig {
	public static String apiurl = "http://localhost:8080/yxwx/memberCenter/";

	static {
		try {
			Properties prop = new Properties();
			prop.load(WeiXinConfig.class
					.getResourceAsStream("/conf/weixin_api.properties"));
			apiurl = prop.getProperty("apiurl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WeiXinConfig() {

	}


}
