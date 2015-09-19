package com.sxit.model.caseManage;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:案场用户 Model
 * @作者:张如兵    
 * @日期:2015-08-05 14:00:18  
 * @版本:1.0
 * @修改:
 */
 
public class TcasUser {

  	/**
	 *用户ID 
	 */
	private Long userId; 
	/**
	 *用户GUID 
	 */
	private String guid; 
	/**
	 *用户名称 
	 */
	private String userName; 
	/**
	 *登录名 
	 */
	private String loginName; 
	/**
	 *手机号码 
	 */
	private String mobile; 
	/**
	 *密码 
	 */
	private String password; 
	/**
	 *绑定的微信ID 
	 */
	private String openId; 
	/**
	 *状态 
	 */
	private Integer state; 
	/**
	 *用户类别 
	 */
	private Integer userType; 
	/**
	 *公司ID 
	 */
	private Long companyId; 
	/**
	 *工作状态  
	 */
	private Integer jobState; 
	/**
	 *离职时间 
	 */
	private String leaveDate; 
	/**
	 *角色ID 
	 */
	private Integer roleId; 
	/**
	 *角色名称 
	 */
	private String roleName; 
	/**
	 *创建时间 
	 */
	private Date createTime; 
	
	public TcasUser() { 
	  super();
	}
	
	/**
	 * 获取用户ID 
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置用户ID 
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取用户GUID 
	 */
	public String getGuid() {
		return guid;
	}
	
	/**
	 * 设置用户GUID 
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	/**
	 * 获取用户名称 
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置用户名称 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取登录名 
	 */
	public String getLoginName() {
		return loginName;
	}
	
	/**
	 * 设置登录名 
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * 获取手机号码 
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置手机号码 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取密码 
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置密码 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取绑定的微信ID 
	 */
	public String getOpenId() {
		return openId;
	}
	
	/**
	 * 设置绑定的微信ID 
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	/**
	 * 获取状态 
	 */
	public Integer getState() {
		return state;
	}
	
	/**
	 * 设置状态 
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	/**
	 * 获取用户类别 
	 */
	public Integer getUserType() {
		return userType;
	}
	
	/**
	 * 设置用户类别 
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	/**
	 * 获取公司ID 
	 */
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置公司ID 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 获取工作状态  
	 */
	public Integer getJobState() {
		return jobState;
	}
	
	/**
	 * 设置工作状态  
	 */
	public void setJobState(Integer jobState) {
		this.jobState = jobState;
	}
	
	/**
	 * 获取离职时间 
	 */
	public String getLeaveDate() {
		return leaveDate;
	}
	
	/**
	 * 设置离职时间 
	 */
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
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
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   TcasUser other = (TcasUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.getUserId()))
		    return false;
	    return true;
	}
	


}
