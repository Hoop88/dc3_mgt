package com.sxit.model.caseManage;

import java.util.List;

import com.sxit.common.dto.TreeStringNode;
import com.sxit.mgt.caseManage.dto.CheckCompanyVo;

/**
 * @公司:深讯信科
 * @功能:案场项目 Model
 * @作者:张如兵
 * @日期:2015-07-23 21:47:43
 * @版本:1.0
 * @修改:
 */

public class TcasProject {

	/**
	 * 项目ID
	 */
	private Long projectId;
	/**
	 * 项目GUID
	 */
	private String projectGuid;
	/**
	 * 项目code
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;

	/**
	 * 市
	 */
	private String city;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 项目父CODE
	 */
	private String parentCode;
	/**
	 * 父ID
	 */
	private Long parentId;
	/**
	 * 项目类别
	 */
	private Integer projectType;
	/**
	 * 地址公司ID
	 */
	private Long companyId;
	
	/**
	 * 项目经理岗位ID
	 */
	private String pmStationGuid;

	/**
	 * 二级项目
	 */
	private List<TcasProject> children;
	
	
	/**
	 * 项目的岗位
	 */
	private List<TreeStringNode> projectStationTree;
	
	/**
	 * 代理公司列表
	 */
	private List<CheckCompanyVo> proxyCompanyList;
	
	
	
	public TcasProject() {
		super();
	}

	/**
	 * 获取项目ID
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * 设置项目ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * 获取项目GUID
	 */
	public String getProjectGuid() {
		return projectGuid;
	}

	/**
	 * 设置项目GUID
	 */
	public void setProjectGuid(String projectGuid) {
		this.projectGuid = projectGuid;
	}

	/**
	 * 获取项目code
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * 设置项目code
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * 获取项目名称
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 设置项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 获取市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置市
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * 获取项目父CODE
	 */
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * 设置项目父CODE
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * 获取父ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取项目类别
	 */
	public Integer getProjectType() {
		return projectType;
	}

	/**
	 * 设置项目类别
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	/**
	 * 获取地址公司ID
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 设置地址公司ID
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getPmStationGuid() {
		return pmStationGuid;
	}

	public void setPmStationGuid(String pmStationGuid) {
		this.pmStationGuid = pmStationGuid;
	}

	public List<TcasProject> getChildren() {
		return children;
	}

	public void setChildren(List<TcasProject> children) {
		this.children = children;
	}

	public List<TreeStringNode> getProjectStationTree() {
		return projectStationTree;
	}

	public void setProjectStationTree(List<TreeStringNode> projectStationTree) {
		this.projectStationTree = projectStationTree;
	}

	public List<CheckCompanyVo> getProxyCompanyList() {
		return proxyCompanyList;
	}

	public void setProxyCompanyList(List<CheckCompanyVo> proxyCompanyList) {
		this.proxyCompanyList = proxyCompanyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		TcasProject other = (TcasProject) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.getProjectId()))
			return false;
		return true;
	}

}
