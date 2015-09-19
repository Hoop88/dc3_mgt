package com.sxit.model.member;


/**
 * 
 * 功能： 活动
 * <p>
 * 作者： mhpi <br>
 * 公司： 深讯信科 <br>
 * 日期： 2014-9-22 <br>
 */
public class MemberActivity {
	/** ID */
	private Long id;
	/** 活动名称 */
	private String name;
	private String areaScopeName;
	/** 用户限制(喜悦,优悦,卓悦,非) */
	private Integer userScope;
	/** 报名时间 */
	private String signTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAreaScopeName() {
		return areaScopeName;
	}

	public void setAreaScopeName(String areaScopeName) {
		this.areaScopeName = areaScopeName;
	}

	public Integer getUserScope() {
		return userScope;
	}

	public void setUserScope(Integer userScope) {
		this.userScope = userScope;
	}


	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
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
		MemberActivity other = (MemberActivity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}

}
