package com.sxit.model.caseManage;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:岗位 Model
 * @作者:张如兵    
 * @日期:2015-08-03 16:55:52  
 * @版本:1.0
 * @修改:
 */
 
public class TcasStation {

  	/**
	 *岗位GUID 
	 */
	private String stationGuid; 
	/**
	 *岗位名称 
	 */
	private String stationName; 
	/**
	 *项目CODE 
	 */
	private String projectCode; 
	/**
	 *父id 
	 */
	private String parentGuid; 
	/**
	 * 
	 */
	private Date createTime; 
	
	public TcasStation() { 
	  super();
	}
	
	/**
	 * 获取岗位GUID 
	 */
	public String getStationGuid() {
		return stationGuid;
	}
	
	/**
	 * 设置岗位GUID 
	 */
	public void setStationGuid(String stationGuid) {
		this.stationGuid = stationGuid;
	}
	
	/**
	 * 获取岗位名称 
	 */
	public String getStationName() {
		return stationName;
	}
	
	/**
	 * 设置岗位名称 
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	/**
	 * 获取项目CODE 
	 */
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * 设置项目CODE 
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	/**
	 * 获取父id 
	 */
	public String getParentGuid() {
		return parentGuid;
	}
	
	/**
	 * 设置父id 
	 */
	public void setParentGuid(String parentGuid) {
		this.parentGuid = parentGuid;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stationGuid == null) ? 0 : stationGuid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   TcasStation other = (TcasStation) obj;
		if (stationGuid == null) {
			if (other.stationGuid != null)
				return false;
		} else if (!stationGuid.equals(other.getStationGuid()))
		    return false;
	    return true;
	}
	

}
