package com.sxit.test;

import java.util.Date;

import com.sxit.common.utils.JsonUtils;
import com.sxit.model.system.SysUser;

public class TestJsonUtil {

	
	public static void main(String[] args) {
		
		SysUser user = new SysUser();
		
		
		user.setCreateTime(new Date());
		
		String json = JsonUtils.toJson(user);
		
		System.out.println(json);
		
	}
}
