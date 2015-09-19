package com.sxit.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * 身份验证
 * 功能： [功能描述]        <p>
 * 作者： mhpi          <br>
 * 公司： 深讯信科                  <br>
 * 日期： 2012-9-21       <br>
 */
public class MyAuthenticator extends Authenticator{
	private String userName;
	private String password;
	
	public MyAuthenticator() {
	}
	
	public MyAuthenticator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
