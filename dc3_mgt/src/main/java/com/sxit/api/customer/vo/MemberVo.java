package com.sxit.api.customer.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @公司:深讯信科
 * @功能:用户 Model
 * @作者:张如兵
 * @日期:2015-03-05 18:07:48
 * @版本:1.0
 * @修改:
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberVo {

	/** 会员GUID */
	private Integer memguid;

	@JsonProperty("buGUID")
	private String buguid;

	/**
	 * 客户UID
	 */
	@JsonProperty("cstGUID")
	private Long cstguid;

	@JsonProperty("oriMemGUID")
	private String orimemguid;

	/**
	 * 原始guid，当对应GUID找不到UID时
	 */
	@JsonProperty("oriCstGUID")
	private String oricstguid;
	/**
	 * 
	 */
	@JsonProperty("joinPath")
	private String joinpath;
	/**
	 * 
	 */
	@JsonProperty("joinDate")
	private Date joindate;

	@JsonProperty("ljPoint")
	private Float ljpoint;

	@JsonProperty("applyDate")
	private Date applydate;

	/**
	 * 会员号
	 */
	@JsonProperty("memCode")
	private String memcode;

	/**
	 * 
	 */
	@JsonProperty("memstation")
	private String memstation;

	@JsonProperty("memLevel")
	private String memlevel;

	/**
	 * 会员状态 0 退会 1 正常 2 卡丢失 3 冻结
	 */
	@JsonProperty("memStatus")
	private String memstatus;

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMemguid() {
		return memguid;
	}

	public void setMemguid(Integer memguid) {
		this.memguid = memguid;
	}

	public String getBuguid() {
		return buguid;
	}

	public void setBuguid(String buguid) {
		this.buguid = buguid;
	}

	public Long getCstguid() {
		return cstguid;
	}

	public void setCstguid(Long cstguid) {
		this.cstguid = cstguid;
	}

	public String getOricstguid() {
		return oricstguid;
	}

	public void setOricstguid(String oricstguid) {
		this.oricstguid = oricstguid;
	}

	public String getJoinpath() {
		return joinpath;
	}

	public void setJoinpath(String joinpath) {
		this.joinpath = joinpath;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Float getLjpoint() {
		return ljpoint;
	}

	public void setLjpoint(Float ljpoint) {
		this.ljpoint = ljpoint;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getMemcode() {
		return memcode;
	}

	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}

	public String getMemstation() {
		return memstation;
	}

	public void setMemstation(String memstation) {
		this.memstation = memstation;
	}

	public String getMemlevel() {
		return memlevel;
	}

	public void setMemlevel(String memlevel) {
		this.memlevel = memlevel;
	}

	public String getMemstatus() {
		return memstatus;
	}

	public Integer toMemstatus() {

		// 会员状态 0 退会 1 正常 2 卡丢失 3 冻结

		if ("正式会员".equals(memstatus)) {
			return 1;
		} else if ("卡丢失".equals(memstatus)) {
			return 2;
		} else if ("退会".equals(memstatus)) {
			return 0;
		} else {
			return 3;
		}
	}

	public void setMemstatus(String memstatus) {
		this.memstatus = memstatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memguid == null) ? 0 : memguid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		MemberVo other = (MemberVo) obj;
		if (memguid == null) {
			if (other.memguid != null)
				return false;
		} else if (!memguid.equals(other.getMemguid()))
			return false;
		return true;
	}

}
