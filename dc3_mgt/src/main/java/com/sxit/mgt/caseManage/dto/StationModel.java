package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:岗位 Model
 * @作者:张如兵    
 * @日期:2015-08-03 16:55:52  
 * @版本:1.0
 * @修改:
 */
 
public class StationModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *岗位GUID 
	 */
	 @NotBlank(message = "岗位GUID不能为空")
	private String stationGuid; 
	/**
	 *岗位名称 
	 */
	 @NotBlank(message = "岗位名称不能为空")
	private String stationName; 
	/**
	 *项目CODE 
	 */
	 @NotBlank(message = "项目CODE不能为空")
	private String projectCode; 
	/**
	 *父id 
	 */
	 @NotBlank(message = "父id不能为空")
	private String parentGuid; 
	
	public StationModel() { 
	  super();
	}
	
	public String getStationGuid() {
		return stationGuid;
	}
	
	public void setStationGuid(String stationGuid) {
	    colset.add("stationGuid");
		this.stationGuid = stationGuid;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String stationName) {
	    colset.add("stationName");
		this.stationName = stationName;
	}
	
	public String getProjectCode() {
		return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
	    colset.add("projectCode");
		this.projectCode = projectCode;
	}
	
	public String getParentGuid() {
		return parentGuid;
	}
	
	public void setParentGuid(String parentGuid) {
	    colset.add("parentGuid");
		this.parentGuid = parentGuid;
	}
	


}
