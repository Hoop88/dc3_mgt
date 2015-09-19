package com.sxit.common.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class Globals {

	
	public static <T> T getBean(String name) {
		WebApplicationContext wac = ContextLoader
				.getCurrentWebApplicationContext();
		return (T) wac.getBean(name);
	}
}
