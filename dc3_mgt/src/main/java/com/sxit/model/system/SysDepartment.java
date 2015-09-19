package com.sxit.model.system;

import java.io.Serializable;
import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:部门 Model
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:22  
 * @版本:1.0
 * @修改:
 */
 
public class SysDepartment implements Serializable {

  	/**
	 * 
	 */
	private static final long serialVersionUID = -121933835923090949L;
	/**
	 *部门ID 
	 */
	private Integer depId; 
	/**
	 *部门名称 
	 */
	private String depName; 
	/**
	 *父菜单 
	 */
	private Integer parentId; 
	/**
	 *创建时间 
	 */
	private Date createTime; 
	
	public SysDepartment() { 
	  super();
	}
	
	/**
	 * 获取部门ID 
	 */
	public Integer getDepId() {
		return depId;
	}
	
	/**
	 * 设置部门ID 
	 */
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	
	/**
	 * 获取部门名称 
	 */
	public String getDepName() {
		return depName;
	}
	
	/**
	 * 设置部门名称 
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	/**
	 * 获取父菜单 
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置父菜单 
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取创建时间 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置创建时间 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depId == null) ? 0 : depId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysDepartment other = (SysDepartment) obj;
		if (depId == null) {
			if (other.depId != null)
				return false;
		} else if (!depId.equals(other.getDepId()))
		    return false;
	    return true;
	}
	


}
