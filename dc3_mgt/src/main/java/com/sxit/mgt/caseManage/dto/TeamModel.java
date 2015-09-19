package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:团队 Model
 * @作者:张如兵    
 * @日期:2015-08-13 17:51:39  
 * @版本:1.0
 * @修改:
 */
 
public class TeamModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *ID  
	 */
	 @NotNull(message = "ID 不能为空")
	private Long teamId; 
	/**
	 *团队GUID 
	 */
	 @NotBlank(message = "团队GUID不能为空")
	private String teamGuid; 
	/**
	 *团队名称 
	 */
	 @NotBlank(message = "团队名称不能为空")
	private String teamName; 
	/**
	 *项目CODE 
	 */
	 @NotBlank(message = "项目CODE不能为空")
	private String projectCode; 
	/**
	 *代理公司ID 
	 */
	 @NotNull(message = "代理公司ID不能为空")
	private Long companyId; 
	/**
	 * 
	 */
	 @NotBlank(message = "不能为空")
	private String parentGuid; 
	/**
	 * 
	 */
	 @NotBlank(message = "不能为空")
	private String parentName; 
	/**
	 *状态 
	 */
	 @NotNull(message = "状态不能为空")
	private Integer state; 
	
	public TeamModel() { 
	  super();
	}
	
	public Long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(Long teamId) {
	    colset.add("teamId");
		this.teamId = teamId;
	}
	
	public String getTeamGuid() {
		return teamGuid;
	}
	
	public void setTeamGuid(String teamGuid) {
	    colset.add("teamGuid");
		this.teamGuid = teamGuid;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
	    colset.add("teamName");
		this.teamName = teamName;
	}
	
	public String getProjectCode() {
		return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
	    colset.add("projectCode");
		this.projectCode = projectCode;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
	    colset.add("companyId");
		this.companyId = companyId;
	}
	
	public String getParentGuid() {
		return parentGuid;
	}
	
	public void setParentGuid(String parentGuid) {
	    colset.add("parentGuid");
		this.parentGuid = parentGuid;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
	    colset.add("parentName");
		this.parentName = parentName;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
	    colset.add("state");
		this.state = state;
	}
	


}
