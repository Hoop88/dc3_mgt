package com.sxit.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	private static Logger LOG = Logger.getLogger(Config.class);
	
	private static final String[] configFiles = new String[] { "conf/wz-cfg.properties" };
	
	private static Properties props = new Properties();
	
	static {
		try {
			for (String path : configFiles) {   
				System.out.println("path " + path);
				props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
            }
			LOG.info("Loading [initPassword.properties] configuration files.");
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	private Config() {
	}
	
	public static String getValue(String key) {
		return props.getProperty(key);
	}
	
	public static Integer getIntValue(String key) {
		return Integer.parseInt(props.getProperty(key));
	}
	
	public static Boolean getBooleanValue(String key) {
		return Boolean.parseBoolean(props.getProperty(key));
	}
	
	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}
