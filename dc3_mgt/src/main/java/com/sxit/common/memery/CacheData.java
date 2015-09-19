package com.sxit.common.memery;

import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.sxit.mgt.common.service.CommonService;

/**
 * 缓存数据     在service的方法上使用ehcache进行缓存
 * @author agu
 *
 */

public class CacheData {

	private static CommonService commonService;

	private static Map<String, String> PathRightMap; // 权限路径
	private static Map<String, String> ParamsMap;     // 系统参数

	public static void init() {
		if (commonService == null) {
			commonService = getBean("commonService");
		}
	}

	public static Map<String, String> getPathRightMap() {
		init();
		PathRightMap = commonService.getPathRightMap();  //方法加缓存
		return PathRightMap;
	}
	
	public static Map<String, String> getParamsMap() {
		init();
		ParamsMap = commonService.getSysParamsMap();  //方法加缓存
		return ParamsMap;
	}


	public static <T> T getBean(String beanid) {
		WebApplicationContext wac = ContextLoader
				.getCurrentWebApplicationContext();
		return (T) wac.getBean(beanid);
	}
}
