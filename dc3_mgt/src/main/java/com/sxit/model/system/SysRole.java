package com.sxit.model.system;

import java.util.Date;
import java.util.List;
/**
 * @公司:深讯信科
 * @功能:角色 Model
 * @作者:张如兵    
 * @日期:2015-07-16 08:38:18  
 * @版本:1.0
 * @修改:
 */
 
public class SysRole {

  	/**
	 *角色ID 
	 */
	private Integer roleId; 
	/**
	 *角色名称 
	 */
	private String roleName; 
	/**
	 *角色类别 
	 */
	private Integer roleType; 
	/**
	 *描述 
	 */
	private String description; 
	/**
	 *标识 
	 */
	private Integer roleFlag; 
	/**
	 *创建时间 
	 */
	private Date createTime; 
	
	private List<IdVo> idList;
	
	public SysRole() { 
	  super();
	}
	
	/**
	 * 获取角色ID 
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置角色ID 
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 获取角色名称 
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * 设置角色名称 
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * 获取角色类别 
	 */
	public Integer getRoleType() {
		return roleType;
	}
	
	/**
	 * 设置角色类别 
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	
	/**
	 * 获取描述 
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 设置描述 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取标识 
	 */
	public Integer getRoleFlag() {
		return roleFlag;
	}
	
	/**
	 * 设置标识 
	 */
	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
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
	
	public List<IdVo> getIdList() {
		return idList;
	}

	public void setIdList(List<IdVo> idList) {
		this.idList = idList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysRole other = (SysRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.getRoleId()))
		    return false;
	    return true;
	}

}
