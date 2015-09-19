package com.sxit.model.caseManage;

import java.util.Date;
import java.util.List;

import com.sxit.model.common.CheckBoxVo;
/**
 * @公司:深讯信科
 * @功能:城市公司 Model
 * @作者:张如兵    
 * @日期:2015-07-22 17:32:53  
 * @版本:1.0
 * @修改:
 */
 
public class TcasCompany {

  	/**
	 *主键 
	 */
	private Long companyId; 
	/**
	 *公司名称 
	 */
	private String companyName; 
	/**
	 *guid 
	 */
	private String guid; 
	/**
	 *公司类别 
	 */
	private Integer companyType; 
	/**
	 *状态  
	 */
	private Integer state; 
	/**
	 *时间 
	 */
	private Date createTime; 
	
	
	/**
	 * 一级项目  针对代理公司
	 */
	private String projectCode; 
	
	/**
	 * 案场经理岗位id
	 */
	private String acStationGuid;
	/**
	 * 二级项目关联项目   针对代理公司
	 */
	private List<CheckBoxVo> projectList;
	
	
	public TcasCompany() { 
	  super();
	}
	
	/**
	 * 获取主键 
	 */
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置主键 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 获取公司名称 
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * 设置公司名称 
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 获取guid 
	 */
	public String getGuid() {
		return guid;
	}
	
	/**
	 * 设置guid 
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	/**
	 * 获取公司类别 
	 */
	public Integer getCompanyType() {
		return companyType;
	}
	
	/**
	 * 设置公司类别 
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
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
	
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public List<CheckBoxVo> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CheckBoxVo> projectList) {
		this.projectList = projectList;
	}

	public String getAcStationGuid() {
		return acStationGuid;
	}

	public void setAcStationGuid(String acStationGuid) {
		this.acStationGuid = acStationGuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   TcasCompany other = (TcasCompany) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.getCompanyId()))
		    return false;
	    return true;
	}
	
}
