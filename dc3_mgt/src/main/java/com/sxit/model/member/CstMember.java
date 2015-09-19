package com.sxit.model.member;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @公司:深讯信科
 * @功能:用户 Model
 * @作者:张如兵    
 * @日期:2015-03-05 18:07:48  
 * @版本:1.0
 * @修改:
 */
 

@JsonIgnoreProperties(ignoreUnknown = true)
public class CstMember {

  	/**
	 * 
	 */
	private Long memguid; 
	/**
	 * 
	 */
	private String orimemguid; 
	/**
	 *客户UID 
	 */
	private Long cstguid; 
	/**
	 *原始guid，当对应GUID找不到UID时 
	 */
	private String oricstguid; 
	/**
	 * 
	 */
	private String buguid; 
	/**
	 *会员号 
	 */
	private String memcode; 
	/**
	 *密码 
	 */
	private String logpwd; 
	/**
	 * 
	 */
	private String memstation; 
	/**
	 * 
	 */
	private String specialtype; 
	/**
	 * 
	 */
	private String joinpath; 
	/**
	 * 
	 */
	private Date joindate; 
	/**
	 * 
	 */
	private Integer issendjoinnote; 
	/**
	 *累计积分 
	 */
	private Float ljpoint; 
	/**
	 * 
	 */
	private Date applydate; 
	/**
	 * 
	 */
	private String shr; 
	/**
	 * 
	 */
	private Date shdate; 
	/**
	 * 
	 */
	private Float ljsjpoint; 
	/**
	 *制卡状态 
	 */
	private String cardstatus; 
	/**
	 * 
	 */
	private String makecardreason; 
	/**
	 * 
	 */
	private Date postcarddate; 
	/**
	 * 
	 */
	private String tjr; 
	/**
	 * 
	 */
	private String tjrmemcode; 
	/**
	 * 
	 */
	private String tjrrelation; 
	/**
	 * 
	 */
	private String tjremark; 
	/**
	 * 
	 */
	private String projname; 
	/**
	 * 
	 */
	private String xckid; 
	/**
	 * 
	 */
	private String xckpwd; 
	/**
	 * 
	 */
	private String saler; 
	/**
	 * 
	 */
	private String getmemlevelway; 
	/**
	 * 
	 */
	private Date holdlevelbegindate; 
	/**
	 * 
	 */
	private Date holdlevelenddate; 
	/**
	 * 
	 */
	private String oldmemcode; 
	/**
	 * 
	 */
	private Date makecarddate; 
	/**
	 * 
	 */
	private String memlevel; 
	/**
	 * 
	 */
	private String maxmemlevel; 
	
	
	
	/**
	 *会员状态
0 退会
1 正常
2 卡丢失
3 冻结 
	 */
	private Integer memstatus; 
	/**
	 *状态变更日期，即成为当前状态的日期 
	 */
	private Date statusdate; 
	/**
	 *状态原因，即变更为当前状态的原因或描述；如冻结原因、挂原因、制卡原因，或不填 
	 */
	private String statusreason; 
	/**
	 *状态处理人，即挂失人、冻结人等 
	 */
	private String statushr; 
	/**
	 * 
	 */
	private String oldstatus; 
	/**
	 * 
	 */
	private String tellist; 
	
	private String accountid; 
	
	private Date bindDate; 
	
	public CstMember() { 
	  super();
	}
	
	/**
	 * 获取 
	 */
	public Long getMemguid() {
		return memguid;
	}
	
	/**
	 * 设置 
	 */
	public void setMemguid(Long memguid) {
		this.memguid = memguid;
	}
	
	/**
	 * 获取 
	 */
	public String getOrimemguid() {
		return orimemguid;
	}
	
	/**
	 * 设置 
	 */
	public void setOrimemguid(String orimemguid) {
		this.orimemguid = orimemguid;
	}
	
	/**
	 * 获取客户UID 
	 */
	public Long getCstguid() {
		return cstguid;
	}
	
	/**
	 * 设置客户UID 
	 */
	public void setCstguid(Long cstguid) {
		this.cstguid = cstguid;
	}
	
	/**
	 * 获取原始guid，当对应GUID找不到UID时 
	 */
	public String getOricstguid() {
		return oricstguid;
	}
	
	/**
	 * 设置原始guid，当对应GUID找不到UID时 
	 */
	public void setOricstguid(String oricstguid) {
		this.oricstguid = oricstguid;
	}
	
	/**
	 * 获取 
	 */
	public String getBuguid() {
		return buguid;
	}
	
	/**
	 * 设置 
	 */
	public void setBuguid(String buguid) {
		this.buguid = buguid;
	}
	
	/**
	 * 获取会员号 
	 */
	public String getMemcode() {
		return memcode;
	}
	
	/**
	 * 设置会员号 
	 */
	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}
	
	/**
	 * 获取密码 
	 */
	public String getLogpwd() {
		return logpwd;
	}
	
	/**
	 * 设置密码 
	 */
	public void setLogpwd(String logpwd) {
		this.logpwd = logpwd;
	}
	
	/**
	 * 获取 
	 */
	public String getMemstation() {
		return memstation;
	}
	
	/**
	 * 设置 
	 */
	public void setMemstation(String memstation) {
		this.memstation = memstation;
	}
	
	/**
	 * 获取 
	 */
	public String getSpecialtype() {
		return specialtype;
	}
	
	/**
	 * 设置 
	 */
	public void setSpecialtype(String specialtype) {
		this.specialtype = specialtype;
	}
	
	/**
	 * 获取 
	 */
	public String getJoinpath() {
		return joinpath;
	}
	
	/**
	 * 设置 
	 */
	public void setJoinpath(String joinpath) {
		this.joinpath = joinpath;
	}
	
	/**
	 * 获取 
	 */
	public Date getJoindate() {
		return joindate;
	}
	
	/**
	 * 设置 
	 */
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	/**
	 * 获取 
	 */
	public Integer getIssendjoinnote() {
		return issendjoinnote;
	}
	
	/**
	 * 设置 
	 */
	public void setIssendjoinnote(Integer issendjoinnote) {
		this.issendjoinnote = issendjoinnote;
	}
	
	/**
	 * 获取累计积分 
	 */
	public Float getLjpoint() {
		return ljpoint;
	}
	
	/**
	 * 设置累计积分 
	 */
	public void setLjpoint(Float ljpoint) {
		this.ljpoint = ljpoint;
	}
	
	/**
	 * 获取 
	 */
	public Date getApplydate() {
		return applydate;
	}
	
	/**
	 * 设置 
	 */
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}
	
	/**
	 * 获取 
	 */
	public String getShr() {
		return shr;
	}
	
	/**
	 * 设置 
	 */
	public void setShr(String shr) {
		this.shr = shr;
	}
	
	/**
	 * 获取 
	 */
	public Date getShdate() {
		return shdate;
	}
	
	/**
	 * 设置 
	 */
	public void setShdate(Date shdate) {
		this.shdate = shdate;
	}
	
	/**
	 * 获取 
	 */
	public Float getLjsjpoint() {
		return ljsjpoint;
	}
	
	/**
	 * 设置 
	 */
	public void setLjsjpoint(Float ljsjpoint) {
		this.ljsjpoint = ljsjpoint;
	}
	
	/**
	 * 获取制卡状态 
	 */
	public String getCardstatus() {
		return cardstatus;
	}
	
	/**
	 * 设置制卡状态 
	 */
	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}
	
	/**
	 * 获取 
	 */
	public String getMakecardreason() {
		return makecardreason;
	}
	
	/**
	 * 设置 
	 */
	public void setMakecardreason(String makecardreason) {
		this.makecardreason = makecardreason;
	}
	
	/**
	 * 获取 
	 */
	public Date getPostcarddate() {
		return postcarddate;
	}
	
	/**
	 * 设置 
	 */
	public void setPostcarddate(Date postcarddate) {
		this.postcarddate = postcarddate;
	}
	
	/**
	 * 获取 
	 */
	public String getTjr() {
		return tjr;
	}
	
	/**
	 * 设置 
	 */
	public void setTjr(String tjr) {
		this.tjr = tjr;
	}
	
	/**
	 * 获取 
	 */
	public String getTjrmemcode() {
		return tjrmemcode;
	}
	
	/**
	 * 设置 
	 */
	public void setTjrmemcode(String tjrmemcode) {
		this.tjrmemcode = tjrmemcode;
	}
	
	/**
	 * 获取 
	 */
	public String getTjrrelation() {
		return tjrrelation;
	}
	
	/**
	 * 设置 
	 */
	public void setTjrrelation(String tjrrelation) {
		this.tjrrelation = tjrrelation;
	}
	
	/**
	 * 获取 
	 */
	public String getTjremark() {
		return tjremark;
	}
	
	/**
	 * 设置 
	 */
	public void setTjremark(String tjremark) {
		this.tjremark = tjremark;
	}
	
	/**
	 * 获取 
	 */
	public String getProjname() {
		return projname;
	}
	
	/**
	 * 设置 
	 */
	public void setProjname(String projname) {
		this.projname = projname;
	}
	
	/**
	 * 获取 
	 */
	public String getXckid() {
		return xckid;
	}
	
	/**
	 * 设置 
	 */
	public void setXckid(String xckid) {
		this.xckid = xckid;
	}
	
	/**
	 * 获取 
	 */
	public String getXckpwd() {
		return xckpwd;
	}
	
	/**
	 * 设置 
	 */
	public void setXckpwd(String xckpwd) {
		this.xckpwd = xckpwd;
	}
	
	/**
	 * 获取 
	 */
	public String getSaler() {
		return saler;
	}
	
	/**
	 * 设置 
	 */
	public void setSaler(String saler) {
		this.saler = saler;
	}
	
	/**
	 * 获取 
	 */
	public String getGetmemlevelway() {
		return getmemlevelway;
	}
	
	/**
	 * 设置 
	 */
	public void setGetmemlevelway(String getmemlevelway) {
		this.getmemlevelway = getmemlevelway;
	}
	
	/**
	 * 获取 
	 */
	public Date getHoldlevelbegindate() {
		return holdlevelbegindate;
	}
	
	/**
	 * 设置 
	 */
	public void setHoldlevelbegindate(Date holdlevelbegindate) {
		this.holdlevelbegindate = holdlevelbegindate;
	}
	
	/**
	 * 获取 
	 */
	public Date getHoldlevelenddate() {
		return holdlevelenddate;
	}
	
	/**
	 * 设置 
	 */
	public void setHoldlevelenddate(Date holdlevelenddate) {
		this.holdlevelenddate = holdlevelenddate;
	}
	
	/**
	 * 获取 
	 */
	public String getOldmemcode() {
		return oldmemcode;
	}
	
	/**
	 * 设置 
	 */
	public void setOldmemcode(String oldmemcode) {
		this.oldmemcode = oldmemcode;
	}
	
	/**
	 * 获取 
	 */
	public Date getMakecarddate() {
		return makecarddate;
	}
	
	/**
	 * 设置 
	 */
	public void setMakecarddate(Date makecarddate) {
		this.makecarddate = makecarddate;
	}
	
	/**
	 * 获取 
	 */
	public String getMemlevel() {
		return memlevel;
	}
	
	/**
	 * 设置 
	 */
	public void setMemlevel(String memlevel) {
		this.memlevel = memlevel;
	}
	
	/**
	 * 获取 
	 */
	public String getMaxmemlevel() {
		return maxmemlevel;
	}
	
	/**
	 * 设置 
	 */
	public void setMaxmemlevel(String maxmemlevel) {
		this.maxmemlevel = maxmemlevel;
	}
	
	/**
	 * 获取会员状态
0 退会
1 正常
2 卡丢失
3 冻结 
	 */
	public Integer getMemstatus() {
		return memstatus;
	}
	
	/**
	 * 设置会员状态
0 退会
1 正常
2 卡丢失
3 冻结 
	 */
	public void setMemstatus(Integer memstatus) {
		this.memstatus = memstatus;
	}
	
	/**
	 * 获取状态变更日期，即成为当前状态的日期 
	 */
	public Date getStatusdate() {
		return statusdate;
	}
	
	/**
	 * 设置状态变更日期，即成为当前状态的日期 
	 */
	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}
	
	/**
	 * 获取状态原因，即变更为当前状态的原因或描述；如冻结原因、挂原因、制卡原因，或不填 
	 */
	public String getStatusreason() {
		return statusreason;
	}
	
	/**
	 * 设置状态原因，即变更为当前状态的原因或描述；如冻结原因、挂原因、制卡原因，或不填 
	 */
	public void setStatusreason(String statusreason) {
		this.statusreason = statusreason;
	}
	
	/**
	 * 获取状态处理人，即挂失人、冻结人等 
	 */
	public String getStatushr() {
		return statushr;
	}
	
	/**
	 * 设置状态处理人，即挂失人、冻结人等 
	 */
	public void setStatushr(String statushr) {
		this.statushr = statushr;
	}
	
	/**
	 * 获取 
	 */
	public String getOldstatus() {
		return oldstatus;
	}
	
	/**
	 * 设置 
	 */
	public void setOldstatus(String oldstatus) {
		this.oldstatus = oldstatus;
	}
	
	/**
	 * 获取 
	 */
	public String getTellist() {
		return tellist;
	}
	
	/**
	 * 设置 
	 */
	public void setTellist(String tellist) {
		this.tellist = tellist;
	}
	
	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Date getBindDate() {
		return bindDate;
	}

	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
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
		if (this == obj) return true;
		if (obj == null) return false;
		   CstMember other = (CstMember) obj;
		if (memguid == null) {
			if (other.memguid != null)
				return false;
		} else if (!memguid.equals(other.getMemguid()))
		    return false;
	    return true;
	}
	


}
