package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxit.model.system.IdVo;

/**
 * @公司:深讯信科
 * @功能:角色 Model
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:42  
 * @版本:1.0
 * @修改:
 */
 
public class RoleModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *角色ID 
	 */
	private Integer roleId; 
	/**
	 *角色名称 
	 */
	 @NotBlank(message = "角色名称不能为空")
	private String roleName; 
	/**
	 *角色类别 
	 */
	 @NotNull(message = "角色类别不能为空")
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
	
	public RoleModel() { 
	  super();
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
	    colset.add("roleId");
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
	    colset.add("roleName");
		this.roleName = roleName;
	}
	
	public Integer getRoleType() {
		return roleType;
	}
	
	public void setRoleType(Integer roleType) {
	    colset.add("roleType");
		this.roleType = roleType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
	    colset.add("description");
		this.description = description;
	}
	
	public Integer getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    colset.add("createTime");
		this.createTime = createTime;
	}

	public List<IdVo> getIdList() {
		return idList;
	}

	public void setIdList(List<IdVo> idList) {
		this.idList = idList;
	}
	


}
