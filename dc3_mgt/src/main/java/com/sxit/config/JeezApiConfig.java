package com.sxit.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置参数
 * 
 * @author agu
 * 
 */
public class JeezApiConfig {
	public static String web_url = "";

	static {
		try {
			Properties prop = new Properties();
			prop.load(JeezApiConfig.class
					.getResourceAsStream("/conf/jeez_api.properties"));
			web_url = prop.getProperty("web_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public JeezApiConfig() {

	}

	public static String getWeb_url() {
		return web_url;
	}

	public static void setWeb_url(String web_url) {
		JeezApiConfig.web_url = web_url;
	}

}
