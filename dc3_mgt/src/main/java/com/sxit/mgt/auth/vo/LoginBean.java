package com.sxit.mgt.auth.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:登录 Model
 * @作者:张如兵
 * @日期:2015-03-02 15:50:48
 * @版本:1.0
 * @修改:
 */

public class LoginBean {

	/**
	 * 登陆账号
	 */
	@NotBlank(message = "登陆账号不能为空")
	private String userName;

	/**
	 * 登陆密码
	 */
	@NotBlank(message = "登陆密码不能为空")
	private String password;

	/**
	 * 验证码
	 */
	@NotBlank(message = "验证码不能为空")
	private String randnum;

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRandnum() {
		return randnum;
	}

	public void setRandnum(String randnum) {
		this.randnum = randnum;
	}

	
	
	
}
