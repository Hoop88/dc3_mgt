package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:系统功能 Model
 * @作者:张如兵    
 * @日期:2015-06-17 16:45:33  
 * @版本:1.0
 * @修改:
 */
 
public class FunctionModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *功能ID 
	 */
	 @NotNull(message = "功能ID不能为空")
	private Integer functionId; 
	/**
	 *功能名称 
	 */
	 @NotBlank(message = "功能名称不能为空")
	private String functionName; 
	/**
	 *功能编码 
	 */
	 @NotBlank(message = "功能编码不能为空")
	private String functionCode; 
	/**
	 *目标区域 
	 */
	 @NotBlank(message = "目标区域不能为空")
	private String openTarget; 
	/**
	 *功能级别 
	 */
	 @NotNull(message = "功能级别不能为空")
	private Integer functionLevel; 
	/**
	 *父功能 
	 */
	 @NotNull(message = "父功能不能为空")
	private Integer parentId; 
	/**
	 *排序 
	 */
	 @NotNull(message = "排序不能为空")
	private Integer sort; 
	/**
	 *类别 
	 */
	 @NotNull(message = "类别不能为空")
	private Integer type; 
	
	public FunctionModel() { 
	  super();
	}
	
	public Integer getFunctionId() {
		return functionId;
	}
	
	public void setFunctionId(Integer functionId) {
	    colset.add("functionId");
		this.functionId = functionId;
	}
	
	public String getFunctionName() {
		return functionName;
	}
	
	public void setFunctionName(String functionName) {
	    colset.add("functionName");
		this.functionName = functionName;
	}
	
	public String getFunctionCode() {
		return functionCode;
	}
	
	public void setFunctionCode(String functionCode) {
	    colset.add("functionCode");
		this.functionCode = functionCode;
	}
	
	public String getOpenTarget() {
		return openTarget;
	}
	
	public void setOpenTarget(String openTarget) {
	    colset.add("openTarget");
		this.openTarget = openTarget;
	}
	
	public Integer getFunctionLevel() {
		return functionLevel;
	}
	
	public void setFunctionLevel(Integer functionLevel) {
	    colset.add("functionLevel");
		this.functionLevel = functionLevel;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
	    colset.add("parentId");
		this.parentId = parentId;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
	    colset.add("sort");
		this.sort = sort;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
	    colset.add("type");
		this.type = type;
	}
	


}
