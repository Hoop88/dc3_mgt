package com.sxit.mgt.caseManage.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:项目管理 Model
 * @作者:张如兵
 * @日期:2015-07-24 11:32:23
 * @版本:1.0
 * @修改:
 */

public class ProjectManageModel {

	public Set<String> colset = new HashSet<String>(0);
	/**
	 * 项目ID
	 */
	@NotNull(message = "项目ID   不能为空")
	private Long projectId;
	/**
	 * 项目GUID
	 */
	@NotBlank(message = "项目GUID 不能为空")
	private String projectGuid;
	/**
	 * 项目code
	 */
	@NotBlank(message = "项目code不能为空")
	private String projectCode;
	/**
	 * 项目名称
	 */
	@NotBlank(message = "项目名称不能为空")
	private String projectName;
	/**
	 * 市
	 */
	@NotBlank(message = "市不能为空")
	private String city;
	/**
	 * 状态
	 */
	@NotNull(message = "状态 不能为空")
	private Integer state;
	/**
	 * 项目父CODE
	 */
	@NotBlank(message = "项目父CODE不能为空")
	private String parentCode;
	/**
	 * 项目类别
	 */
	@NotNull(message = "项目类别 不能为空")
	private Integer projectType;

	/**
	 * 项目经理岗位ID
	 */
	private String pmStationGuid;
	
	/**
	 * 代理公司列表
	 */
	private List<CheckCompanyVo> proxyCompanyList;

	public ProjectManageModel() {
		super();
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		colset.add("projectId");
		this.projectId = projectId;
	}

	public String getProjectGuid() {
		return projectGuid;
	}

	public void setProjectGuid(String projectGuid) {
		colset.add("projectGuid");
		this.projectGuid = projectGuid;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		colset.add("projectCode");
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		colset.add("projectName");
		this.projectName = projectName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		colset.add("city");
		this.city = city;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		colset.add("state");
		this.state = state;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		colset.add("parentCode");
		this.parentCode = parentCode;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		colset.add("projectType");
		this.projectType = projectType;
	}

	public String getPmStationGuid() {
		return pmStationGuid;
	}

	public void setPmStationGuid(String pmStationGuid) {
		colset.add("pmStationGuid");
		this.pmStationGuid = pmStationGuid;
	}

	public List<CheckCompanyVo> getProxyCompanyList() {
		return proxyCompanyList;
	}

	public void setProxyCompanyList(List<CheckCompanyVo> proxyCompanyList) {
		colset.add("proxyCompanyList");
		this.proxyCompanyList = proxyCompanyList;
	}

}
