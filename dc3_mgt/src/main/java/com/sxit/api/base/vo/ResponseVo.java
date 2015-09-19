package com.sxit.api.base.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxit.common.config.InterfaceConfig;
import com.sxit.common.security.DESCoder;
import com.sxit.common.security.MD5;

@JsonIgnoreProperties(value = { "md5String" })
public class ResponseVo {

	private int code; // 0 为成功

	private int status; // 状态

	private String message; // 消息

	private String content; // des加密的返回内容

	private String time; // 返回时间

	private String vercode; // 验证串

	public ResponseVo() {
		super();
		this.time = System.currentTimeMillis() + "";
	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param status
	 * @param message
	 */
	public ResponseVo(int code, int status, String message) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.time = System.currentTimeMillis() + "";

	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param status
	 * @param message
	 * @param content
	 */
	public ResponseVo(int code, int status, String message, String content) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.content = content;
		this.time = System.currentTimeMillis() + "";
	}

	/**
	 * 加密内容
	 * 
	 * @return
	 */
	public ResponseVo desContent() {
		if (StringUtils.isNotBlank(content)) {
			try {
				this.content = URLEncoder.encode(
						DESCoder.encrypt(content, InterfaceConfig.deskey), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	

	/**
	 * 返回成功信息
	 * 
	 * @param msg
	 * @return
	 */
	public static ResponseVo successMsg(String msg) {
		return new ResponseVo(0, 0, msg);
	}

	/**
	 * 返回成功信息
	 * 
	 * @param msg
	 * @param content
	 * @return
	 */
	public static ResponseVo successMsg(String msg, String content) {
		return new ResponseVo(0, 0, msg, content);
	}

	public static ResponseVo successMsg(int status, String msg, String content) {
		return new ResponseVo(0, status, msg, content);
	}

	/**
	 * 返回错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public static ResponseVo errorMsg(String msg) {
		return new ResponseVo(1, 0, msg);
	}

	/**
	 * 返回错误细细
	 * 
	 * @param msg
	 * @param status
	 * @return
	 */
	public static ResponseVo errorMsg(String msg, int status) {
		return new ResponseVo(1, status, msg);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVercode() {
		String md5String = getMd5String();
		this.vercode = MD5.md5(md5String, InterfaceConfig.md5key);
		return this.vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	/**
	 * 获取验证串
	 * 
	 * @return
	 */
	@JsonIgnore
	public String getMd5String() {
		StringBuffer sb = new StringBuffer();
		sb.append(code);
		sb.append(status);
		if (message != null) {
			sb.append(message);
		}
		if (content != null) {
			sb.append(content);
		}
		sb.append(time);
		return sb.toString();
	}

}
