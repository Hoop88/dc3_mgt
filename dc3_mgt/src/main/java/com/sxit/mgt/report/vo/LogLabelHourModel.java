package com.sxit.mgt.report.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:按时段统计 Model
 * @作者:张如兵    
 * @日期:2015-04-14 10:51:22  
 * @版本:1.0
 * @修改:
 */
 
public class LogLabelHourModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *year+month+day+hour+label 
	 */
	 @NotBlank(message = "year+month+day+hour+label不能为空")
	private String id; 
	/**
	 *年 
	 */
	 @NotBlank(message = "年不能为空")
	private String year; 
	/**
	 *月 
	 */
	 @NotBlank(message = "月不能为空")
	private String month; 
	/**
	 *日 
	 */
	 @NotBlank(message = "日不能为空")
	private String day; 
	/**
	 *时 
	 */
	 @NotBlank(message = "时不能为空")
	private String hour; 
	/**
	 *父ID 
	 */
	 @NotNull(message = "父ID不能为空")
	private Integer parentId; 
	/**
	 *特征名称 
	 */
	 @NotBlank(message = "特征名称不能为空")
	private String parentName; 
	/**
	 *特征ID 
	 */
	 @NotNull(message = "特征ID不能为空")
	private Integer labelId; 
	/**
	 *特征名称 
	 */
	 @NotBlank(message = "特征名称不能为空")
	private String labelName; 
	/**
	 *请求数 
	 */
	 @NotNull(message = "请求数不能为空")
	private Long reqNums; 
	/**
	 *请求用户数 
	 */
	 @NotNull(message = "请求用户数不能为空")
	private Long userNums; 
	
	public LogLabelHourModel() { 
	  super();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
	    colset.add("id");
		this.id = id;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
	    colset.add("year");
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
	    colset.add("month");
		this.month = month;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
	    colset.add("day");
		this.day = day;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
	    colset.add("hour");
		this.hour = hour;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
	    colset.add("parentId");
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
	    colset.add("parentName");
		this.parentName = parentName;
	}
	
	public Integer getLabelId() {
		return labelId;
	}
	
	public void setLabelId(Integer labelId) {
	    colset.add("labelId");
		this.labelId = labelId;
	}
	
	public String getLabelName() {
		return labelName;
	}
	
	public void setLabelName(String labelName) {
	    colset.add("labelName");
		this.labelName = labelName;
	}
	
	public Long getReqNums() {
		return reqNums;
	}
	
	public void setReqNums(Long reqNums) {
	    colset.add("reqNums");
		this.reqNums = reqNums;
	}
	
	public Long getUserNums() {
		return userNums;
	}
	
	public void setUserNums(Long userNums) {
	    colset.add("userNums");
		this.userNums = userNums;
	}
	


}
