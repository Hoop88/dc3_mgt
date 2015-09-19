package com.sxit.model.caseManage;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:团队 Model
 * @作者:张如兵    
 * @日期:2015-08-13 18:05:00  
 * @版本:1.0
 * @修改:
 */
 
public class TcasTeam {

  	/**
	 *ID  
	 */
	private Long teamId; 
	/**
	 *团队GUID 
	 */
	private String teamGuid; 
	/**
	 *团队名称 
	 */
	private String teamName; 
	/**
	 *项目CODE 
	 */
	private String projectCode; 
	/**
	 *代理公司ID 
	 */
	private Long companyId; 
	/**
	 * 
	 */
	private String parentGuid; 
	/**
	 * 
	 */
	private String parentName; 
	/**
	 *状态 
	 */
	private Integer state; 
	
	private Date createTime;
	
	public TcasTeam() { 
	  super();
	}
	
	/**
	 * 获取ID  
	 */
	public Long getTeamId() {
		return teamId;
	}
	
	/**
	 * 设置ID  
	 */
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	
	/**
	 * 获取团队GUID 
	 */
	public String getTeamGuid() {
		return teamGuid;
	}
	
	/**
	 * 设置团队GUID 
	 */
	public void setTeamGuid(String teamGuid) {
		this.teamGuid = teamGuid;
	}
	
	/**
	 * 获取团队名称 
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * 设置团队名称 
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	 * 获取代理公司ID 
	 */
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置代理公司ID 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 获取 
	 */
	public String getParentGuid() {
		return parentGuid;
	}
	
	/**
	 * 设置 
	 */
	public void setParentGuid(String parentGuid) {
		this.parentGuid = parentGuid;
	}
	
	/**
	 * 获取 
	 */
	public String getParentName() {
		return parentName;
	}
	
	/**
	 * 设置 
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取状态 
	 */
	public Integer getState() {
		return state;
	}
	
	/**
	 * 设置状态 
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   TcasTeam other = (TcasTeam) obj;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.getTeamId()))
		    return false;
	    return true;
	}
	


}
