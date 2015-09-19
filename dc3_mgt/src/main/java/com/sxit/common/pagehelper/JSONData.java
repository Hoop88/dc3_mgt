package com.sxit.common.pagehelper;

import java.io.Serializable;

public class JSONData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1736482660100854737L;
	/** 返回数据 */
	private Object data;

	public JSONData() {
		super();

	}

	public JSONData(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static JSONData newData(Object o){
		return new JSONData(o);
	}
}
