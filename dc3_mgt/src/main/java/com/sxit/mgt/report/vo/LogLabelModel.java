package com.sxit.mgt.report.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:标签设置 Model
 * @作者:张如兵    
 * @日期:2015-04-13 16:30:54  
 * @版本:1.0
 * @修改:
 */
 
public class LogLabelModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *标签ID 
	 */
	// @NotNull(message = "标签ID不能为空")
	private Integer labelId; 
	/**
	 *标签名称 
	 */
	 @NotBlank(message = "标签名称不能为空")
	private String labelName; 
	/**
	 *父ID 
	 */
	// @NotNull(message = "父ID不能为空")
	private Integer parentId; 
	/**
	 *父标签名称 
	 */
	// @NotBlank(message = "父标签名称不能为空")
	private String parentName; 
	/**
	 *排序 
	 */
	 @NotNull(message = "排序不能为空")
	private Integer orderNum; 
	/**
	 *特征URL 
	 */
	 @NotBlank(message = "特征URL不能为空")
	private String url; 
	
	public LogLabelModel() { 
	  super();
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
	
	public Integer getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(Integer orderNum) {
	    colset.add("orderNum");
		this.orderNum = orderNum;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
	    colset.add("url");
		this.url = url;
	}
	


}
