package com.sxit.model.member;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:客户合并 Model
 * @作者:张如兵    
 * @日期:2015-05-16 17:40:10  
 * @版本:1.0
 * @修改:
 */
 
public class CstAuth {

  	/**
	 * 
	 */
	private Long contactid; 
	/**
	 *客户ID 
	 */
	private Long cstguid; 
	/**
	 *移动电话 
	 */
	private String mobiletel; 
	/**
	 *邮箱 
	 */
	private String email; 
	/**
	 *微信openid 
	 */
	private String wxopenid; 
	/**
	 *微信用户unionid 
	 */
	private String wxunionid; 
	/**
	 *密码 
	 */
	private String passwd; 
	/**
	 *状态（0：有效，1：无效） 
	 */
	private Integer status; 
	/**
	 *最后修改时间 
	 */
	private Date lastupdatetime; 
	/**
	 * 
	 */
	private String accountid; 
	
	public CstAuth() { 
	  super();
	}
	
	/**
	 * 获取 
	 */
	public Long getContactid() {
		return contactid;
	}
	
	/**
	 * 设置 
	 */
	public void setContactid(Long contactid) {
		this.contactid = contactid;
	}
	
	/**
	 * 获取客户ID 
	 */
	public Long getCstguid() {
		return cstguid;
	}
	
	/**
	 * 设置客户ID 
	 */
	public void setCstguid(Long cstguid) {
		this.cstguid = cstguid;
	}
	
	/**
	 * 获取移动电话 
	 */
	public String getMobiletel() {
		return mobiletel;
	}
	
	/**
	 * 设置移动电话 
	 */
	public void setMobiletel(String mobiletel) {
		this.mobiletel = mobiletel;
	}
	
	/**
	 * 获取邮箱 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置邮箱 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取微信openid 
	 */
	public String getWxopenid() {
		return wxopenid;
	}
	
	/**
	 * 设置微信openid 
	 */
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}
	
	/**
	 * 获取微信用户unionid 
	 */
	public String getWxunionid() {
		return wxunionid;
	}
	
	/**
	 * 设置微信用户unionid 
	 */
	public void setWxunionid(String wxunionid) {
		this.wxunionid = wxunionid;
	}
	
	/**
	 * 获取密码 
	 */
	public String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置密码 
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * 获取状态（0：有效，1：无效） 
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置状态（0：有效，1：无效） 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取最后修改时间 
	 */
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	
	/**
	 * 设置最后修改时间 
	 */
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	
	/**
	 * 获取 
	 */
	public String getAccountid() {
		return accountid;
	}
	
	/**
	 * 设置 
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactid == null) ? 0 : contactid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   CstAuth other = (CstAuth) obj;
		if (contactid == null) {
			if (other.contactid != null)
				return false;
		} else if (!contactid.equals(other.getContactid()))
		    return false;
	    return true;
	}
	


}
