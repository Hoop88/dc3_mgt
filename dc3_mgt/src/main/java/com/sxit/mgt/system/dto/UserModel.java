package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:用户 Model
 * @作者:张如兵    
 * @日期:2015-06-17 16:59:56  
 * @版本:1.0
 * @修改:
 */
 
public class UserModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *用户ID 
	 */
	 @NotNull(message = "用户ID不能为空")
	private Integer userId; 
	/**
	 *登陆账号 
	 */
	 @NotBlank(message = "登陆账号不能为空")
	private String userName; 
	/**
	 *登陆密码 
	 */
	 @NotBlank(message = "登陆密码不能为空")
	private String password; 
	/**
	 *姓名 
	 */
	 @NotBlank(message = "姓名不能为空")
	private String name; 
	/**
	 *联系电话 
	 */
	 @NotBlank(message = "联系电话不能为空")
	private String mobile; 
	/**
	 *电子邮件 
	 */
	 @NotBlank(message = "电子邮件不能为空")
	private String mail; 
	/**
	 *备注 
	 */
	 @NotBlank(message = "备注不能为空")
	private String remark; 
	/**
	 *职务 
	 */
	 @NotBlank(message = "职务不能为空")
	private String post; 
	/**
	 *部门ID 
	 */
	 @NotNull(message = "部门ID不能为空")
	private Integer depId; 
	/**
	 *部门名称 
	 */
	 @NotBlank(message = "部门名称不能为空")
	private String depName; 
	/**
	 *用户状态： 0 禁用  1 正常  2 已删除 3 冻结 
	 */
	 @NotNull(message = "用户状态： 0 禁用  1 正常  2 已删除 3 冻结不能为空")
	private Integer state; 
	/**
	 *创建时间 
	 */
	 @NotNull(message = "创建时间不能为空")
	private Date createTime; 
	/**
	 *最后修改时间 
	 */
	 @NotNull(message = "最后修改时间不能为空")
	private Date modifyTime; 
	/**
	 *用户类别 
	 */
	 @NotNull(message = "用户类别不能为空")
	private Integer userType; 
	
	public UserModel() { 
	  super();
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
	    colset.add("password");
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
	    colset.add("name");
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
	    colset.add("mobile");
		this.mobile = mobile;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
	    colset.add("mail");
		this.mail = mail;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
	    colset.add("remark");
		this.remark = remark;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
	    colset.add("post");
		this.post = post;
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
	
	public Date getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Date modifyTime) {
	    colset.add("modifyTime");
		this.modifyTime = modifyTime;
	}
	
	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
	    colset.add("userType");
		this.userType = userType;
	}
	


}
