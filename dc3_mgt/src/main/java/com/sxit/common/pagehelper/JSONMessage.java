package com.sxit.common.pagehelper;

import java.io.Serializable;
import java.util.Map;

public class JSONMessage extends PageVo implements Serializable {
	
	private static final long serialVersionUID = 941156679578563922L;

	/** 服务是否超时 */
	private boolean timeout;

	/** 是否成功 true:成功 false:失败 */
	private boolean success;

	/** 消息 */
	private String message;
	
    private Map map;

	/** 返回数据 */
	private Object data;

	/** 返回数据1 */
	private Object data1;

	/** 返回数据2 */
	private Object data2;

	/** 返回数据3 */
	private Object data3;
	
	public JSONMessage() {}
	
	public JSONMessage(boolean success) {
		this.success = success;
	}
	
	public JSONMessage(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public JSONMessage(boolean success, String message, Object obj) {
		this.success = success;
		this.message = message;
		this.data = obj;
	}
	
	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData1() {
		return data1;
	}

	public void setData1(Object data1) {
		this.data1 = data1;
	}

	public Object getData2() {
		return data2;
	}

	public void setData2(Object data2) {
		this.data2 = data2;
	}

	public Object getData3() {
		return data3;
	}

	public void setData3(Object data3) {
		this.data3 = data3;
	}

	public Map getMap1() {
		return map;
	}

	public void setMap1(Map map) {
		this.map = map;
	}
}
