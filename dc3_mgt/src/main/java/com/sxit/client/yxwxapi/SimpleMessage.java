package com.sxit.client.yxwxapi;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.sxit.common.utils.NullUtil;

/**
 * 
 * @author agu
 *
 */
public class SimpleMessage<T> implements Serializable {

	private static final long serialVersionUID = 941156679578563922L;

	/** 是否成功 true:成功 false:失败 */
	private boolean success;

	/** 消息 */
	private String message;

	/** 返回数据 */
	private T data;

	public SimpleMessage() {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
