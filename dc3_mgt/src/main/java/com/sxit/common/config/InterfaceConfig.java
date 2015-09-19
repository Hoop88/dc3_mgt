package com.sxit.common.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
 
/**
 * 
 * @Title: InterfaceConfig.java
 * @Package com.dfzy.rossini.json.util
 * @Description: TODO
 * @author agu 
 * @date 2013-10-23 下午5:47:26
 */

public class InterfaceConfig {
	public static String deskey = "F0204FA319309C84FA404545D96F1122";
	public static String md5key = "F0204FA319309D84FA404545D96F5522";
	public static boolean checkTime = true;
	public static long delayTime = 1000 * 60 * 5; // 延迟5分钟
	public static boolean useDes = true;
	public static boolean useMd5 = true;

	static {
		try {
			Properties prop = new Properties();
			prop.load(InterfaceConfig.class.getResourceAsStream("/conf/interface.properties"));
			deskey = prop.getProperty("deskey");
			md5key = prop.getProperty("md5key");
			
			String _checkTime = prop.getProperty("checkTime");
			if ("true".equals(_checkTime.toLowerCase())) {
				checkTime = true;
			} else {
				checkTime = false;
			}
			
			String _delayTime = prop.getProperty("delayTime");

			if (StringUtils.isNumeric(_delayTime)) {
				delayTime = Long.parseLong(_delayTime);
			}

			String _useDes = prop.getProperty("useDes");
			String _useMd5 = prop.getProperty("useMd5");
			
			System.out.println(_useDes);
			System.out.println(_useMd5);
			if ("true".equals(_useDes.toLowerCase().trim())) {
				useDes = true;
			} else {
				useDes = false;
			}

			if ("true".equals(_useMd5.toLowerCase().trim())) {
				useMd5 = true;
			} else {
				useMd5 = false;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
