package com.sxit.api.base.handler;

import javax.servlet.http.HttpServletRequest;

import com.sxit.api.base.vo.ResponseVo;



public interface IHandler {

	/**
	 * 数据初始化，包括设置request信息
	 * @param request {@link HttpServletRequest}
	 */
	boolean init(String content) throws Exception;
	
	/**
	 * 接口操作
	 * @throws Exception 
	 */
	void handle() throws Exception;
	
	/**
	 * 数据校验
	 * @return false 数据有误或者参数值缺失等 true OK
	 * @throws Exception 
	 */
	boolean verify() throws Exception;
	
	/**
	 * 返回消息
	 * @return
	 */
	ResponseVo getResponseMsg();
	
}
