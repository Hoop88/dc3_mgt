package com.sxit.common.memery;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sxit.mgt.system.service.SysExportService;
import com.sxit.model.system.SysExportColumn;

/**
 * 用于导出的参数配置   已加ehcache
 * 
 * @Title: ExportValue.java
 * @Package com.dfzy.base.common.memery
 * @Description: TODO
 * @author agu
 * @date 2014-3-12 上午10:06:43
 */

public class ExportMap {

	// Export 里面存放 按数据字典代码存放的LinkedHashMap的值.
	private static LinkedHashMap<String, List<SysExportColumn>> Export;

	private static SysExportService service;

	
	public static void init() {
		if (service == null) {
			service = getBean("sysExportService");
		}
	}

	/**
	 * 获取dict
	 * 
	 * @return HashMap
	 */
	public static HashMap getExport() {
		init();
		Export = service.getExportMap(); // 已经加了ehcache缓存
		return Export;
	}

	public static <T> T getBean(String beanid) {
		WebApplicationContext wac = ContextLoader
				.getCurrentWebApplicationContext();
		return (T) wac.getBean(beanid);
	}

}
