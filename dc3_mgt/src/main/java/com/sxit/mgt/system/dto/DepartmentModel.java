package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:部门 Model
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:22  
 * @版本:1.0
 * @修改:
 */
 
public class DepartmentModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *部门ID 
	 */
	private Integer depId; 
	/**
	 *部门名称 
	 */
	 @NotBlank(message = "部门名称不能为空")
	private String depName; 
	/**
	 *父菜单 
	 */

	private Integer parentId; 
	/**
	 *创建时间 
	 */

	private Date createTime; 
	
	public DepartmentModel() { 
	  super();
	}
	
	public Integer getDepId() {
		return depId;
	}
	
	public void setDepId(Integer depId) {
	    colset.add("depId");
		this.depId = depId;
	}
	
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
	    colset.add("depName");
		this.depName = depName;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
	    colset.add("parentId");
		this.parentId = parentId;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    colset.add("createTime");
		this.createTime = createTime;
	}
	


}
