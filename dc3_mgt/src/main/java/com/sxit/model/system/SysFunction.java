package com.sxit.model.system;

/**
 * @公司:深讯信科
 * @功能:功能 Model
 * @作者:张如兵    
 * @日期:2015-06-17 18:18:58  
 * @版本:1.0
 * @修改:
 */
 
public class SysFunction {

  	/**
	 *功能ID 
	 */
	private Integer functionId; 
	/**
	 *功能名称 
	 */
	private String functionName; 
	/**
	 *功能编码 
	 */
	private String functionCode; 
	/**
	 *目标区域 
	 */
	private String openTarget; 
	/**
	 *功能级别 
	 */
	private Integer functionLevel; 
	/**
	 *父功能 
	 */
	private Integer parentId; 
	/**
	 *排序 
	 */
	private Integer sort; 
	/**
	 *类别 
	 */
	private Integer type; 
	/**
	 *状态 
	 */
	private Integer state; 
	
	public SysFunction() { 
	  super();
	}
	
	/**
	 * 获取功能ID 
	 */
	public Integer getFunctionId() {
		return functionId;
	}
	
	/**
	 * 设置功能ID 
	 */
	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}
	
	/**
	 * 获取功能名称 
	 */
	public String getFunctionName() {
		return functionName;
	}
	
	/**
	 * 设置功能名称 
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	/**
	 * 获取功能编码 
	 */
	public String getFunctionCode() {
		return functionCode;
	}
	
	/**
	 * 设置功能编码 
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	
	/**
	 * 获取目标区域 
	 */
	public String getOpenTarget() {
		return openTarget;
	}
	
	/**
	 * 设置目标区域 
	 */
	public void setOpenTarget(String openTarget) {
		this.openTarget = openTarget;
	}
	
	/**
	 * 获取功能级别 
	 */
	public Integer getFunctionLevel() {
		return functionLevel;
	}
	
	/**
	 * 设置功能级别 
	 */
	public void setFunctionLevel(Integer functionLevel) {
		this.functionLevel = functionLevel;
	}
	
	/**
	 * 获取父功能 
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置父功能 
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取排序 
	 */
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置排序 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 获取类别 
	 */
	public Integer getType() {
		return type;
	}
	
	/**
	 * 设置类别 
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取状态 
	 */
	public Integer getState() {
		return state;
	}
	
	/**
	 * 设置状态 
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionId == null) ? 0 : functionId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysFunction other = (SysFunction) obj;
		if (functionId == null) {
			if (other.functionId != null)
				return false;
		} else if (!functionId.equals(other.getFunctionId()))
		    return false;
	    return true;
	}
	


}
