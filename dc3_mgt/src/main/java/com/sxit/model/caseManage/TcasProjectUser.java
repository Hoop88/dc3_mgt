package com.sxit.model.caseManage;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:项目用户 Model
 * @作者:张如兵    
 * @日期:2015-08-10 09:09:35  
 * @版本:1.0
 * @修改:
 */
 
public class TcasProjectUser {

  	/**
	 *主键 
	 */
	private Long id; 
	/**
	 *用户ID 
	 */
	private Long userId; 
	/**
	 *姓名 
	 */
	private String userName; 
	/**
	 *项目code 
	 */
	private String projectCode; 
	/**
	 * 
	 */
	private Long projectId; 
	
	/**
	 *是否绑定微信
	 */
	private Integer flag; 
	/**
	 *首选 
	 */
	private Integer firstChoice; 
	/**
	 * 
	 */
	private String mobile; 
	/**
	 *角色 
	 */
	private Integer roleId; 
	/**
	 *角色名称 
	 */
	private String roleName; 
	/**
	 *所属公司 
	 */
	private Long companyId; 
	/**
	 *状态 
	 */
	private Integer state; 
	
	/**
	 *创建时间 
	 */
	private Date createTime; 
	
	public TcasProjectUser() { 
	  super();
	}
	
	/**
	 * 获取主键 
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置主键 
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * 获取姓名 
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置姓名 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取项目code 
	 */
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * 设置项目code 
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	/**
	 * 获取 
	 */
	public Long getProjectId() {
		return projectId;
	}
	
	/**
	 * 设置 
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	/**
	 * 是否绑定微信
	 */
	public Integer getFlag() {
		return flag;
	}
	
	/**
	 * 是否绑定微信
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	/**
	 * 获取首选 
	 */
	public Integer getFirstChoice() {
		return firstChoice;
	}
	
	/**
	 * 设置首选 
	 */
	public void setFirstChoice(Integer firstChoice) {
		this.firstChoice = firstChoice;
	}
	
	/**
	 * 获取 
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取角色 
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置角色 
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
	 * 获取所属公司 
	 */
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置所属公司 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   TcasProjectUser other = (TcasProjectUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}
	


}
