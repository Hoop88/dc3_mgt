package com.sxit.model.report;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:标签设置 Model
 * @作者:张如兵    
 * @日期:2015-04-13 16:30:54  
 * @版本:1.0
 * @修改:
 */
 
public class LogLabel {

  	/**
	 *标签ID 
	 */
	private Integer labelId; 
	/**
	 *标签名称 
	 */
	private String labelName; 
	/**
	 *父ID 
	 */
	private Integer parentId; 
	/**
	 *父标签名称 
	 */
	private String parentName; 
	/**
	 *排序 
	 */
	private Integer orderNum; 
	/**
	 *特征URL 
	 */
	private String url; 
	
	public LogLabel() { 
	  super();
	}
	
	/**
	 * 获取标签ID 
	 */
	public Integer getLabelId() {
		return labelId;
	}
	
	/**
	 * 设置标签ID 
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	
	/**
	 * 获取标签名称 
	 */
	public String getLabelName() {
		return labelName;
	}
	
	/**
	 * 设置标签名称 
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
	/**
	 * 获取父ID 
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置父ID 
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取父标签名称 
	 */
	public String getParentName() {
		return parentName;
	}
	
	/**
	 * 设置父标签名称 
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	/**
	 * 获取排序 
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	
	/**
	 * 设置排序 
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	/**
	 * 获取特征URL 
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * 设置特征URL 
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labelId == null) ? 0 : labelId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   LogLabel other = (LogLabel) obj;
		if (labelId == null) {
			if (other.labelId != null)
				return false;
		} else if (!labelId.equals(other.getLabelId()))
		    return false;
	    return true;
	}
	


}
