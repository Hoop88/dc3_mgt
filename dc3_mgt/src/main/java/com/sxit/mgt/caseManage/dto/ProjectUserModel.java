package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:项目用户 Model
 * @作者:张如兵    
 * @日期:2015-08-10 09:09:35  
 * @版本:1.0
 * @修改:
 */
 
public class ProjectUserModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *主键 
	 */
	// @NotNull(message = "主键不能为空")
	private Long id; 
	/**
	 *用户ID 
	 */
	// @NotNull(message = "用户ID不能为空")
	private Long userId; 
	/**
	 *姓名 
	 */
	// @NotBlank(message = "姓名不能为空")
	private String userName; 
	/**
	 *项目code 
	 */
	// @NotBlank(message = "项目code不能为空")
	private String projectCode; 
	/**
	 * 
	 */
	// @NotNull(message = "不能为空")
	private Long projectId; 
	/**
	 *删除标识 
	 */
	// @NotNull(message = "删除标识不能为空")
	private Integer flag; 
	/**
	 *首选 
	 */
	// @NotNull(message = "首选不能为空")
	private Integer firstChoice; 
	/**
	 * 
	 */
	// @NotBlank(message = "不能为空")
	private String mobile; 
	/**
	 *角色 
	 */
	// @NotBlank(message = "角色不能为空")
	private String roleId; 
	/**
	 *角色名称 
	 */
	// @NotBlank(message = "角色名称不能为空")
	private String roleName; 
	/**
	 *所属公司 
	 */
	// @NotNull(message = "所属公司不能为空")
	private Long companyId; 
	/**
	 *状态 
	 */
	// @NotNull(message = "状态不能为空")
	private Integer state; 
	/**
	 *创建时间 
	 */
	// @NotNull(message = "创建时间不能为空")
	private Date createTime; 
	
	public ProjectUserModel() { 
	  super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
	    colset.add("id");
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
	    colset.add("userId");
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
	    colset.add("userName");
		this.userName = userName;
	}
	
	public String getProjectCode() {
		return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
	    colset.add("projectCode");
		this.projectCode = projectCode;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
	    colset.add("projectId");
		this.projectId = projectId;
	}
	
	public Integer getFlag() {
		return flag;
	}
	
	public void setFlag(Integer flag) {
	    colset.add("flag");
		this.flag = flag;
	}
	
	public Integer getFirstChoice() {
		return firstChoice;
	}
	
	public void setFirstChoice(Integer firstChoice) {
	    colset.add("firstChoice");
		this.firstChoice = firstChoice;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
	    colset.add("mobile");
		this.mobile = mobile;
	}
	
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
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
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
	    colset.add("companyId");
		this.companyId = companyId;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
	    colset.add("state");
		this.state = state;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    colset.add("createTime");
		this.createTime = createTime;
	}
	


}
