package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxit.model.common.CheckBoxVo;

/**
 * @公司:深讯信科
 * @功能:城市公司 Model
 * @作者:张如兵    
 * @日期:2015-07-22 17:32:53  
 * @版本:1.0
 * @修改:
 */
 
public class CompanyModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *主键 
	 */
	private Long companyId; 
	/**
	 *公司名称 
	 */
	 @NotBlank(message = "公司名称不能为空")
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
	 * 二级项目关联项目   针对代理公司
	 */
	private List<CheckBoxVo> projectList;
	
	/**
	 * 案场经理岗位id
	 */
	private String acStationGuid;
	
	public CompanyModel() { 
	  super();
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
	    colset.add("companyId");
		this.companyId = companyId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
	    colset.add("companyName");
		this.companyName = companyName;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setGuid(String guid) {
	    colset.add("guid");
		this.guid = guid;
	}
	
	public Integer getCompanyType() {
		return companyType;
	}
	
	public void setCompanyType(Integer companyType) {
	    colset.add("companyType");
		this.companyType = companyType;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
	    colset.add("state");
		this.state = state;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    colset.add("createTime");
		this.createTime = createTime;
	}



	public String getProjectCode() {
		
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		colset.add("projectCode");
		this.projectCode = projectCode;
	}

	public String getAcStationGuid() {
		return acStationGuid;
	}

	public void setAcStationGuid(String acStationGuid) {
	    colset.add("acStationGuid");
		this.acStationGuid = acStationGuid;
	}

	public List<CheckBoxVo> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CheckBoxVo> projectList) {
		colset.add("projectList");
		this.projectList = projectList;
	}
	


}
