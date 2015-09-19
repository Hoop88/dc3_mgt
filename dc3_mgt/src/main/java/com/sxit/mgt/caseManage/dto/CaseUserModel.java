package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:案场用户 Model
 * @作者:张如兵    
 * @日期:2015-08-05 14:00:18  
 * @版本:1.0
 * @修改:
 */
 
public class CaseUserModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *用户ID 
	 */
	//@NotNull(message = "用户ID不能为空")
	private Long userId; 
	/**
	 *用户GUID 
	 */
	// @NotBlank(message = "用户GUID不能为空")
	private String guid; 
	/**
	 *用户名称 
	 */
	 @NotBlank(message = "用户名称不能为空")
	private String userName; 
	/**
	 *登录名 
	 */
	 @NotBlank(message = "登录名不能为空")
	private String loginName; 
	/**
	 *手机号码 
	 */
	// @NotBlank(message = "手机号码不能为空")
	private String mobile; 
	/**
	 *密码 
	 */
	// @NotBlank(message = "密码不能为空")
	private String password; 
	/**
	 *绑定的微信ID 
	 */
	// @NotBlank(message = "绑定的微信ID不能为空")
	private String openId; 
	/**
	 *状态 
	 */
	// @NotNull(message = "状态不能为空")
	private Integer state; 
	/**
	 *用户类别 
	 */
	 //@NotNull(message = "用户类别不能为空")
	private Integer userType; 
	/**
	 *公司ID 
	 */
	// @NotNull(message = "公司ID不能为空")
	private Long companyId; 
	/**
	 *工作状态  
	 */
	// @NotNull(message = "工作状态 不能为空")
	private Integer jobState; 
	/**
	 *离职时间 
	 */
	// @NotBlank(message = "离职时间不能为空")
	private String leaveDate; 
	/**
	 *角色ID 
	 */
	// @NotNull(message = "角色ID不能为空")
	private Integer roleId; 
	/**
	 *角色名称 
	 */
	// @NotBlank(message = "角色名称不能为空")
	private String roleName; 
	/**
	 *创建时间 
	 */
	// @NotNull(message = "创建时间不能为空")
	private Date createTime; 
	
	public CaseUserModel() { 
	  super();
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
	    colset.add("userId");
		this.userId = userId;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setGuid(String guid) {
	    colset.add("guid");
		this.guid = guid;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
	    colset.add("userName");
		this.userName = userName;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
	    colset.add("loginName");
		this.loginName = loginName;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
	    colset.add("mobile");
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if(StringUtils.isNotBlank(password))
		{
			colset.add("password");
		}
		this.password = password;
	}
	
	public String getOpenId() {
		return openId;
	}
	
	public void setOpenId(String openId) {
	    colset.add("openId");
		this.openId = openId;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
	    colset.add("state");
		this.state = state;
	}
	
	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
	    colset.add("userType");
		this.userType = userType;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
	    colset.add("companyId");
		this.companyId = companyId;
	}
	
	public Integer getJobState() {
		return jobState;
	}
	
	public void setJobState(Integer jobState) {
	    colset.add("jobState");
		this.jobState = jobState;
	}
	
	public String getLeaveDate() {
		return leaveDate;
	}
	
	public void setLeaveDate(String leaveDate) {
	    colset.add("leaveDate");
		this.leaveDate = leaveDate;
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
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    colset.add("createTime");
		this.createTime = createTime;
	}
	
}
