package com.sxit.common.mail;

import java.util.Properties;

public class MailBean {
	private String mailServerHost; // 主机IP
	private String mailServerPort; // 主机端口
	private String fromAddress; // 发送者
	private String[] toAddress; // 接受者
	// 登陆邮件服务器的用户名密码
	private String userName;
	private String password;
	
	private boolean isValidate; // 是否验证身份
	private String subject;// 邮件主题
	private String content;// 邮件内容
	private String[] attachFileName; // 附件的文件名
	
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", this.isValidate ? "true" : "false");
		return p;
	}
	
	public static MailBean getDefalutEmailBean(){
		MailBean mail = new MailBean();
		mail.setMailServerHost(MailConfiguration.getValue("mailServerHost"));
		mail.setMailServerPort(MailConfiguration.getValue("mailServerPort"));
		mail.setUserName(MailConfiguration.getValue("userName"));
		mail.setPassword(MailConfiguration.getValue("password"));
		mail.setFromAddress(MailConfiguration.getValue("fromAddress"));
		mail.setValidate(true);
		return mail;
	}
	
	public String getMailServerHost() {
		return mailServerHost;
	}
	
	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}
	
	public String getMailServerPort() {
		return mailServerPort;
	}
	
	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}
	
	public String getFromAddress() {
		return fromAddress;
	}
	
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public String[] getToAddress() {
		return toAddress;
	}
	
	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
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
	
	public boolean isValidate() {
		return isValidate;
	}
	
	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String[] getAttachFileName() {
		return attachFileName;
	}
	
	public void setAttachFileName(String[] attachFileName) {
		this.attachFileName = attachFileName;
	}
	
}
