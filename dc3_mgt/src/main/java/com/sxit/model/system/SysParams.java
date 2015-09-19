package com.sxit.model.system;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:系统参数 Model
 * @作者:张如兵    
 * @日期:2015-07-20 13:58:41  
 * @版本:1.0
 * @修改:
 */
 
public class SysParams {

  	/**
	 *主键id 
	 */
	private Long paramsId; 
	/**
	 *参数名称 
	 */
	private String paramsName; 
	/**
	 *参数值 
	 */
	private String paramsValue; 
	/**
	 *参数描述 
	 */
	private String paramsDesc; 
	
	public SysParams() { 
	  super();
	}
	
	/**
	 * 获取主键id 
	 */
	public Long getParamsId() {
		return paramsId;
	}
	
	/**
	 * 设置主键id 
	 */
	public void setParamsId(Long paramsId) {
		this.paramsId = paramsId;
	}
	
	/**
	 * 获取参数名称 
	 */
	public String getParamsName() {
		return paramsName;
	}
	
	/**
	 * 设置参数名称 
	 */
	public void setParamsName(String paramsName) {
		this.paramsName = paramsName;
	}
	
	/**
	 * 获取参数值 
	 */
	public String getParamsValue() {
		return paramsValue;
	}
	
	/**
	 * 设置参数值 
	 */
	public void setParamsValue(String paramsValue) {
		this.paramsValue = paramsValue;
	}
	
	/**
	 * 获取参数描述 
	 */
	public String getParamsDesc() {
		return paramsDesc;
	}
	
	/**
	 * 设置参数描述 
	 */
	public void setParamsDesc(String paramsDesc) {
		this.paramsDesc = paramsDesc;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramsId == null) ? 0 : paramsId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysParams other = (SysParams) obj;
		if (paramsId == null) {
			if (other.paramsId != null)
				return false;
		} else if (!paramsId.equals(other.getParamsId()))
		    return false;
	    return true;
	}
	


}
