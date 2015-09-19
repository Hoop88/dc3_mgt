package com.sxit.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置参数
 * 
 * @author agu
 *
 */
public class MingYuanApiConfig {
	public static String api_url = "";

	static {
		try {
			Properties prop = new Properties();
			prop.load(MingYuanApiConfig.class
					.getResourceAsStream("/conf/mingyuan_api.properties"));
			api_url = prop.getProperty("api_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MingYuanApiConfig() {

	}

	public static String getApi_url() {
		return api_url;
	}

	public static void setApi_url(String api_url) {
		MingYuanApiConfig.api_url = api_url;
	}


}
