package com.sxit.model.report;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:按日统计 Model
 * @作者:张如兵    
 * @日期:2015-04-14 10:44:43  
 * @版本:1.0
 * @修改:
 */
 
public class LogLabelDay {

  	/**
	 *year+month+day+label 
	 */
	private String id; 
	/**
	 *年 
	 */
	private String year; 
	/**
	 *月 
	 */
	private String month; 
	/**
	 *日 
	 */
	private String day; 
	/**
	 *父ID 
	 */
	private Integer parentId; 
	/**
	 *特征名称 
	 */
	private String parentName; 
	/**
	 *特征ID 
	 */
	private Integer labelId; 
	/**
	 *特征名称 
	 */
	private String labelName; 
	/**
	 *请求数 
	 */
	private Long reqNums; 
	/**
	 *请求用户数 
	 */
	private Long userNums; 
	
	public LogLabelDay() { 
	  super();
	}
	
	/**
	 * 获取year+month+day+label 
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置year+month+day+label 
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取年 
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 设置年 
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * 获取月 
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * 设置月 
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * 获取日 
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * 设置日 
	 */
	public void setDay(String day) {
		this.day = day;
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
	 * 获取特征名称 
	 */
	public String getParentName() {
		return parentName;
	}
	
	/**
	 * 设置特征名称 
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	/**
	 * 获取特征ID 
	 */
	public Integer getLabelId() {
		return labelId;
	}
	
	/**
	 * 设置特征ID 
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	
	/**
	 * 获取特征名称 
	 */
	public String getLabelName() {
		return labelName;
	}
	
	/**
	 * 设置特征名称 
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
	/**
	 * 获取请求数 
	 */
	public Long getReqNums() {
		return reqNums;
	}
	
	/**
	 * 设置请求数 
	 */
	public void setReqNums(Long reqNums) {
		this.reqNums = reqNums;
	}
	
	/**
	 * 获取请求用户数 
	 */
	public Long getUserNums() {
		return userNums;
	}
	
	/**
	 * 设置请求用户数 
	 */
	public void setUserNums(Long userNums) {
		this.userNums = userNums;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   LogLabelDay other = (LogLabelDay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}
	


}
