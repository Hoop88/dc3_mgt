package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxit.model.common.CheckBoxVo;

/**
 * @公司:深讯信科
 * @功能:系统用户 Model
 * @作者:张如兵
 * @日期:2015-06-26 09:43:07
 * @版本:1.0
 * @修改:
 */

public class SysUserModel {

	public Set<String> colset = new HashSet<String>(0);
	/**
	 * 用户ID
	 */

	private Integer userId;
	/**
	 * 登陆账号
	 */
	@NotBlank(message = "登陆账号不能为空")
	private String userName;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	@NotBlank(message = "姓名不能为空")
	private String name;
	/**
	 * 联系电话
	 */

	private String mobile;
	/**
	 * 头像
	 */

	private String logo;
	/**
	 * 电子邮件
	 */

	private String mail;
	/**
	 * 备注
	 */

	private String remark;
	/**
	 * 职务
	 */

	private String post;
	/**
	 * 部门ID
	 */

	private Integer depId;
	/**
	 * 部门名称
	 */

	private String depName;
	/**
	 * 用户状态： 0 禁用 1 正常 2 已删除 3 冻结
	 */
	private Integer state;
	/**
	 * 创建时间
	 */

	private Date createTime;
	/**
	 * 最后修改时间
	 */

	private Date modifyTime;
	/**
	 * 用户类别
	 */
	@NotNull(message = "用户类别不能为空")
	private Integer userType;

	private List<CheckBoxVo> roleList;

	public SysUserModel() {
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		colset.add("logo");
		this.logo = logo;
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

	public List<CheckBoxVo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<CheckBoxVo> roleList) {
		colset.add("roleList");
		this.roleList = roleList;
	}

}
