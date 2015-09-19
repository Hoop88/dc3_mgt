package com.sxit.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxit.model.common.CheckBoxVo;
/**
 * @公司:深讯信科
 * @功能:用户 Model
 * @作者:张如兵    
 * @日期:2015-06-17 18:26:11  
 * @版本:1.0
 * @修改:
 */
 
public class SysUser {

  	/**
	 *用户ID 
	 */
	private Integer userId; 
	/**
	 *登陆账号 
	 */
	private String userName; 
	/**
	 *登陆密码 
	 */
	private String password; 
	/**
	 *姓名 
	 */
	private String name; 
	/**
	 *联系电话 
	 */
	private String mobile; 
	/**
	 *头像 
	 */
	private String logo; 
	/**
	 *电子邮件 
	 */
	private String mail; 
	/**
	 *备注 
	 */
	private String remark; 
	/**
	 *职务 
	 */
	private String post; 
	/**
	 *部门ID 
	 */
	private Integer depId; 
	/**
	 *部门名称 
	 */
	private String depName; 
	/**
	 *用户状态： 0 禁用  1 正常  2 已删除 3 冻结 
	 */
	private Integer state; 
	/**
	 *创建时间 
	 */
	private Date createTime; 
	/**
	 *最后修改时间 
	 */
	private Date modifyTime; 
	/**
	 *用户类别 
	 */
	private Integer userType; 
	
	
	private List<CheckBoxVo> roleList;
	
	public SysUser() { 
	  super();
	}
	
	/**
	 * 获取用户ID 
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * 设置用户ID 
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取登陆账号 
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置登陆账号 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取登陆密码 
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置登陆密码 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取姓名 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置姓名 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取联系电话 
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置联系电话 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取头像 
	 */
	public String getLogo() {
		return logo;
	}
	
	/**
	 * 设置头像 
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	/**
	 * 获取电子邮件 
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * 设置电子邮件 
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * 获取备注 
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * 设置备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取职务 
	 */
	public String getPost() {
		return post;
	}
	
	/**
	 * 设置职务 
	 */
	public void setPost(String post) {
		this.post = post;
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
	 * 获取用户状态： 0 禁用  1 正常  2 已删除 3 冻结 
	 */
	public Integer getState() {
		return state;
	}
	
	/**
	 * 设置用户状态： 0 禁用  1 正常  2 已删除 3 冻结 
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
	
	/**
	 * 获取最后修改时间 
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	
	/**
	 * 设置最后修改时间 
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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
	
	public List<CheckBoxVo> getRoleList() {
		if(roleList==null)
		{
			return new ArrayList();
		}
		return roleList;
	}

	public void setRoleList(List<CheckBoxVo> roleList) {
		this.roleList = roleList;
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
		   SysUser other = (SysUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.getUserId()))
		    return false;
	    return true;
	}


	


}
