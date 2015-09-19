package com.sxit.model.system;

/**
 * 
 * @author agu
 * 
 */
public class BaseUser {
  	/**
	 *用户ID 
	 */
	private Integer userId; 
	/**
	 *登陆账号 
	 */
	private String userName; 

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
	 * 用户类别
	 */
	private Integer userType; 
	

	public BaseUser() {

	}

	public BaseUser(SysUser user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.name =  user.getName();
		this.mobile = user.getMobile();
		this.logo = user.getLogo();
		this.mail = user.getMail();
		this.post = user.getPost();
		this.depId = user.getDepId();
		this.depName = user.getDepName();
		this.userType=user.getUserType();
	}

	public BaseUser(Integer userId, String userName, String name,
			String mobile, String logo, String mail, String post,
			Integer depId, String depName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.mobile = mobile;
		this.logo = logo;
		this.mail = mail;
		this.post = post;
		this.depId = depId;
		this.depName = depName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}



}
