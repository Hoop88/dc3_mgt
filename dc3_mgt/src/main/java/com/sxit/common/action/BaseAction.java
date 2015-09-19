package com.sxit.common.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sxit.common.binder.CustomDateEditor;
import com.sxit.common.excel.ExcelExport;
import com.sxit.model.system.BaseUser;

/**
 * @公司:深讯信科
 * @功能:Action的基类封装
 * @作者:张如兵
 * @日期:2015-02-25 20:47:48
 * @版本:1.0
 * @修改:
 */
@SuppressWarnings("unchecked")
public class BaseAction {

	private static final ThreadLocal<HttpServletRequest> LOCAL_REQUEST = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> LOCAL_RESPONSE = new ThreadLocal<HttpServletResponse>();
	protected Logger log = LoggerFactory.getLogger(BaseAction.class);

	private Validator validator;

	@Resource
	public void setValidator(LocalValidatorFactoryBean validatorFactory) {// 浣跨敤spring涓畾涔夌殑factory
		validator = validatorFactory.getValidator();
	}

	public BaseAction() {
		super();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

	}

	@ModelAttribute
	public void setHttp(HttpServletRequest request, HttpServletResponse response) {
		LOCAL_REQUEST.set(request);
		LOCAL_RESPONSE.set(response);
	}

	/**
	 * 将信息存储到会话信息中
	 */
	protected void set(String key, Object value) {
		HttpServletRequest request = LOCAL_REQUEST.get();
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	/**
	 * 从会话信息中获取信息
	 */
	protected Object get(String key) {
		HttpServletRequest request = LOCAL_REQUEST.get();
		HttpSession session = request.getSession();
		return session.getAttribute(key);
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	protected HttpSession getHttpSession() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		HttpSession session = request.getSession();
		return session;
	}

	/**
	 * 从session中获取 String
	 */
	protected String getStr(String key) {
		HttpServletRequest request = LOCAL_REQUEST.get();
		HttpSession session = request.getSession();

		Object o = session.getAttribute(key);
		if (o == null)
			return null;
		else
			return o.toString();
	}

	protected BaseUser getCurUser() {
		BaseUser baseUser = (BaseUser) this.get("baseUser");
		return baseUser;
	}

	/**
	 * 获取当前用户的ID
	 */
	protected Integer getCurUserId() {
		BaseUser baseUser = (BaseUser) this.get("baseUser");
		if (baseUser != null) {
			return (int) baseUser.getUserId();
		}
		return 0;
	}

	/**
	 * 获取当前URL
	 * 
	 * @return
	 */
	public String getCururl() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		String reqStr = request.getRequestURL().toString();
		String queryStr = request.getQueryString();

		if (StringUtils.isBlank(queryStr)) {
			return reqStr;
		} else {
			return reqStr + "?" + queryStr;
		}
	}

	public String getRequestURL() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		String reqStr = request.getRequestURL().toString();
		return reqStr;
	}

	/**
	 * 获取请求IP
	 * 
	 * @return
	 */
	public String getIp() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * 楠岃瘉
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public <T> Set<ConstraintViolation<T>> verify(final T t) {
		Set<ConstraintViolation<T>> failures = validator.validate(t);
		return failures;
	}

	public String getRealPath() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		// return request.getRealPath("");
		return request.getServletContext().getRealPath("");
	}

	public HttpServletRequest getRequest() {
		HttpServletRequest request = LOCAL_REQUEST.get();
		return request;
	}

	public HttpServletResponse getResponse() {
		HttpServletResponse response = LOCAL_RESPONSE.get();
		return response;
	}

	/**
	 * 下载
	 * 
	 * @Description: TODO
	 * @param export
	 * @param outPutFileName
	 * @throws IOException
	 */
	public void dowloadExcel(ExcelExport export, String outPutFileName)
			throws IOException, Exception {

		if (export != null) {

			HttpServletResponse response = LOCAL_RESPONSE.get();
			// 取得输出流
			OutputStream out = response.getOutputStream();
			// 清空输出流
			response.reset();

			// 设置响应头和下载保存的文件名
			response.setHeader("content-disposition", "attachment;filename="
					+ outPutFileName);
			// 定义输出类型
			response.setContentType("APPLICATION/msexcel");

			export.WriteExcel(out);

			out.close();

			// 这一行非常关键，否则在实际中有可能出现莫名其妙的问题！！！
			response.flushBuffer();// 强行将响应缓存中的内容发送到目的地
		}
	}
}
