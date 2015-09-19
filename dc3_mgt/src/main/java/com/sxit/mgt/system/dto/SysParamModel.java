package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:系统参数 Model
 * @作者:张如兵    
 * @日期:2015-07-20 14:00:23  
 * @版本:1.0
 * @修改:
 */
 
public class SysParamModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *主键id 
	 */
	 @NotNull(message = "主键id不能为空")
	private Long paramsId; 
	/**
	 *参数名称 
	 */
	 @NotBlank(message = "参数名称不能为空")
	private String paramsName; 
	/**
	 *参数值 
	 */
	 @NotBlank(message = "参数值不能为空")
	private String paramsValue; 
	/**
	 *参数描述 
	 */
	 @NotBlank(message = "参数描述不能为空")
	private String paramsDesc; 
	
	public SysParamModel() { 
	  super();
	}
	
	public Long getParamsId() {
		return paramsId;
	}
	
	public void setParamsId(Long paramsId) {
	    colset.add("paramsId");
		this.paramsId = paramsId;
	}
	
	public String getParamsName() {
		return paramsName;
	}
	
	public void setParamsName(String paramsName) {
	    colset.add("paramsName");
		this.paramsName = paramsName;
	}
	
	public String getParamsValue() {
		return paramsValue;
	}
	
	public void setParamsValue(String paramsValue) {
	    colset.add("paramsValue");
		this.paramsValue = paramsValue;
	}
	
	public String getParamsDesc() {
		return paramsDesc;
	}
	
	public void setParamsDesc(String paramsDesc) {
	    colset.add("paramsDesc");
		this.paramsDesc = paramsDesc;
	}
	


}
