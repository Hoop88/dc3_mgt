package com.sxit.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置参数
 * 
 * @author agu
 *
 */
public class SysConfig {
	public static String baseUrl = "";
	public static String webUrl = "";

	static {
		try {
			Properties prop = new Properties();
			prop.load(SysConfig.class
					.getResourceAsStream("/conf/sys.properties"));
			webUrl = prop.getProperty("webUrl");
			baseUrl = prop.getProperty("baseUrl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SysConfig() {

	}

	public static String getWebUrl() {
		return webUrl;
	}

	public static void setWebUrl(String webUrl) {
		SysConfig.webUrl = webUrl;
	}

}
