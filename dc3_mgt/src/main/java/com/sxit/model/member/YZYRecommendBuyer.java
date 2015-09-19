package com.sxit.model.member;

import java.util.Date;

public class YZYRecommendBuyer {
	private String id;
	private String projectId;
	private String projName;
	private String city;
	private String recommendName;
	private String recommendedName;
	private String recommendedMobile;
	private String recommendedSex;
	private String cstGUID;
	private String createTime;
	private String lockTime;
	private String creatTime;
	private String status;
	private String consultant;
	private Integer flag ;
	private Long sourceId ;
	private String sourceName ;
	private Date assignDate ;
	private Date arriveDate ;
	private Date offerBuyDate ;
	private Date signDate ;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRecommendedName() {
		return recommendedName;
	}

	public void setRecommendedName(String recommendedName) {
		this.recommendedName = recommendedName;
	}

	public String getRecommendedMobile() {
		return recommendedMobile;
	}

	public void setRecommendedMobile(String recommendedMobile) {
		this.recommendedMobile = recommendedMobile;
	}

	public String getRecommendedSex() {
		return recommendedSex;
	}

	public void setRecommendedSex(String recommendedSex) {
		this.recommendedSex = recommendedSex;
	}

	public String getCstGUID() {
		return cstGUID;
	}

	public void setCstGUID(String cstGUID) {
		this.cstGUID = cstGUID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLockTime() {
		return lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getRecommendName() {
		return recommendName;
	}

	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}

	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public Date getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public Date getOfferBuyDate() {
		return offerBuyDate;
	}
	public void setOfferBuyDate(Date offerBuyDate) {
		this.offerBuyDate = offerBuyDate;
	}

	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
}
