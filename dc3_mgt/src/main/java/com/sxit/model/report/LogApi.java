package com.sxit.model.report;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:接口日志 Model
 * @作者:张如兵    
 * @日期:2015-05-16 11:44:39  
 * @版本:1.0
 * @修改:
 */
 
public class LogApi {

  	/**
	 *流失id 
	 */
	private Integer id; 
	/**
	 *用户ID 
	 */
	private String userId; 
	/**
	 *用户名 
	 */
	private String userName; 
	/**
	 *请求地址 
	 */
	private String reqUrl; 
	/**
	 *接口名称 
	 */
	private String intName; 
	/**
	 *请求数据(加密) 
	 */
	private String reqData; 
	/**
	 *返回数据(加密) 
	 */
	private String resData; 
	/**
	 *请求内容 
	 */
	private String reqContent; 
	/**
	 *返回内容 
	 */
	private String resContent; 
	/**
	 *异常信息 
	 */
	private String excData; 
	/**
	 *IP地址 
	 */
	private String ip; 
	/**
	 *imei 
	 */
	private String imei; 
	/**
	 *型号 
	 */
	private String modelNum; 
	/**
	 *版本号 
	 */
	private String versionNum; 
	/**
	 *应用程序编码 
	 */
	private String appCode; 
	/**
	 *应用程序版本 
	 */
	private String appVersion; 
	/**
	 *操作结果  
	 */
	private Integer result; 
	
	
	private Integer isdes; 
	/**
	 *时间 
	 */
	private Date createTime; 
	
	public LogApi() { 
	  super();
	}
	
	
	
	
	public LogApi(String reqUrl, String ip) {
		super();
		this.reqUrl = reqUrl;
		this.ip = ip;
	}




	/**
	 * 获取流失id 
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置流失id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 获取用户ID 
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置用户ID 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取用户名 
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置用户名 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取请求地址 
	 */
	public String getReqUrl() {
		return reqUrl;
	}
	
	/**
	 * 设置请求地址 
	 */
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	
	/**
	 * 获取接口名称 
	 */
	public String getIntName() {
		return intName;
	}
	
	/**
	 * 设置接口名称 
	 */
	public void setIntName(String intName) {
		this.intName = intName;
	}
	
	/**
	 * 获取请求数据(加密) 
	 */
	public String getReqData() {
		return reqData;
	}
	
	/**
	 * 设置请求数据(加密) 
	 */
	public void setReqData(String reqData) {
		this.reqData = reqData;
	}
	
	/**
	 * 获取返回数据(加密) 
	 */
	public String getResData() {
		return resData;
	}
	
	/**
	 * 设置返回数据(加密) 
	 */
	public void setResData(String resData) {
		this.resData = resData;
	}
	
	/**
	 * 获取请求内容 
	 */
	public String getReqContent() {
		return reqContent;
	}
	
	/**
	 * 设置请求内容 
	 */
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	
	/**
	 * 获取返回内容 
	 */
	public String getResContent() {
		return resContent;
	}
	
	/**
	 * 设置返回内容 
	 */
	public void setResContent(String resContent) {
		this.resContent = resContent;
	}
	
	/**
	 * 获取异常信息 
	 */
	public String getExcData() {
		return excData;
	}
	
	/**
	 * 设置异常信息 
	 */
	public void setExcData(String excData) {
		this.excData = excData;
	}
	
	/**
	 * 获取IP地址 
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置IP地址 
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 获取imei 
	 */
	public String getImei() {
		return imei;
	}
	
	/**
	 * 设置imei 
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	/**
	 * 获取型号 
	 */
	public String getModelNum() {
		return modelNum;
	}
	
	/**
	 * 设置型号 
	 */
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	
	/**
	 * 获取版本号 
	 */
	public String getVersionNum() {
		return versionNum;
	}
	
	/**
	 * 设置版本号 
	 */
	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}
	
	/**
	 * 获取应用程序编码 
	 */
	public String getAppCode() {
		return appCode;
	}
	
	/**
	 * 设置应用程序编码 
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	/**
	 * 获取应用程序版本 
	 */
	public String getAppVersion() {
		return appVersion;
	}
	
	/**
	 * 设置应用程序版本 
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	public Integer getIsdes() {
		return isdes;
	}




	public void setIsdes(Integer isdes) {
		this.isdes = isdes;
	}




	/**
	 * 获取操作结果  
	 */
	public Integer getResult() {
		return result;
	}
	
	/**
	 * 设置操作结果  
	 */
	public void setResult(Integer result) {
		this.result = result;
	}
	
	/**
	 * 获取时间 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置时间 
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
		   LogApi other = (LogApi) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}
	


}
