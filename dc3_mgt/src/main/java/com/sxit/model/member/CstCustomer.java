package com.sxit.model.member;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @公司:深讯信科
 * @功能:用户 Model
 * @作者:张如兵    
 * @日期:2015-03-05 16:02:52  
 * @版本:1.0
 * @修改:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CstCustomer {

  	/**
	 * 
	 */
	private Long cstguid; 
	/**
	 *客户姓名 
	 */
	private String cstname; 
	/**
	 *性别 
	 */
	private Integer gender; 
	/**
	 *生日 
	 */
	private Date birthdate; 
	/**
	 *语言 
	 */
	private String language; 
	/**
	 *客户类型 
	 */
	private Integer csttype; 
	/**
	 *证件类型 
	 */
	private Integer cardtype; 
	/**
	 *证件号码 
	 */
	private String cardid; 
	/**
	 *手机 
	 */
	private String mobiletel; 
	/**
	 *办公电话 
	 */
	private String officetel; 
	/**
	 *家庭电话 
	 */
	private String hometel; 
	/**
	 *传真 
	 */
	private String fax; 
	/**
	 *邮箱 
	 */
	private String email; 
	/**
	 *邮编 
	 */
	private String postcode; 
	/**
	 *住址 
	 */
	private String address; 
	/**
	 *国家 
	 */
	private String country; 
	/**
	 *省份 
	 */
	private String province; 
	/**
	 *城市 
	 */
	private String city; 
	/**
	 *区 
	 */
	private String regional; 
	/**
	 *路 
	 */
	private String road; 
	/**
	 *国籍 
	 */
	private String nationality; 
	/**
	 *籍贯 
	 */
	private String nativeplace; 
	/**
	 * 
	 */
	private String srctype; 
	/**
	 *最后修改时间 
	 */
	private Date lastmodifytime; 
	/**
	 *原始GUID，即在明源的GUID 
	 */
	private String origuid; 
	/**
	 * 
	 */
	private String creditevaluate; 
	/**
	 *客户编号 
	 */
	private String cstcode; 
	/**
	 * 
	 */
	private String company; 
	/**
	 * 
	 */
	private String position; 
	/**
	 * 
	 */
	private Float incoming; 
	/**
	 *工作单位地址 
	 */
	private String workaddr; 
	/**
	 *地址编号 
	 */
	private String companytel; 
	/**
	 *民族 
	 */
	private String race; 
	/**
	 *宗教信仰 
	 */
	private String religion; 
	/**
	 *政治面貌 
	 */
	private String political; 
	/**
	 *是否已婚 
	 */
	private Integer ismerried; 
	/**
	 *最后跟进时间 
	 */
	private Date lasttouchtime; 
	/**
	 *最后一次跟进记录，以JSON格式存储 
	 */
	private String recenttouch; 
	/**
	 * 
	 */
	private Date lastassigntime; 
	/**
	 *最后一次分配记录 
	 */
	private String recentassign; 
	/**
	 *最后预约时间 
	 */
	private Date lastappointtime; 
	/**
	 *最近一次预约记录 
	 */
	private String recentappoint; 
	/**
	 *认知途径 
	 */
	private String cognichannel; 
	/**
	 *客户状态 
	 */
	private Integer status; 
	/**
	 * 
	 */
	private Long memguid; 
	/**
	 * 
	 */
	private String staffguid; 
	/**
	 * 
	 */
	private String ownerguid; 
	/**
	 * 
	 */
	private Date createtime; 
	/**
	 * 
	 */
	private String cardid15; 
	/**
	 *1 身份证有效 手机有效、2 身份证有效 手机无效、3 身份证无效 手机有效 、4 身份证手机均无效（level为4的不应再往表里入了） 
	 */
	private Integer level; 
	/**
	 * 
	 */
	private Integer conflict; 
	/**
	 * 
	 */
	private String contact; 
	/**
	 *1.明源数据、2.物业数据 
	 */
	private Integer soutype; 
	/**
	 *被合并客户的id串,英文逗号隔开 
	 */
	private String oldcstguidlist; 
	/**
	 *基准客户的id，合并之后的新客户id 
	 */
	private String newcstguid; 
	
	public CstCustomer() { 
	  super();
	}
	
	/**
	 * 获取 
	 */
	public Long getCstguid() {
		return cstguid;
	}
	
	/**
	 * 设置 
	 */
	public void setCstguid(Long cstguid) {
		this.cstguid = cstguid;
	}
	
	/**
	 * 获取客户姓名 
	 */
	public String getCstname() {
		return cstname;
	}
	
	/**
	 * 设置客户姓名 
	 */
	public void setCstname(String cstname) {
		this.cstname = cstname;
	}
	
	/**
	 * 获取性别 
	 */
	public Integer getGender() {
		return gender;
	}
	
	/**
	 * 设置性别 
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取生日 
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	
	/**
	 * 设置生日 
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * 获取语言 
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * 设置语言 
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * 获取客户类型 
	 */
	public Integer getCsttype() {
		return csttype;
	}
	
	/**
	 * 设置客户类型 
	 */
	public void setCsttype(Integer csttype) {
		this.csttype = csttype;
	}
	
	/**
	 * 获取证件类型 
	 */
	public Integer getCardtype() {
		return cardtype;
	}
	
	/**
	 * 设置证件类型 
	 */
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	
	/**
	 * 获取证件号码 
	 */
	public String getCardid() {
		return cardid;
	}
	
	/**
	 * 设置证件号码 
	 */
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	
	/**
	 * 获取手机 
	 */
	public String getMobiletel() {
		return mobiletel;
	}
	
	/**
	 * 设置手机 
	 */
	public void setMobiletel(String mobiletel) {
		this.mobiletel = mobiletel;
	}
	
	/**
	 * 获取办公电话 
	 */
	public String getOfficetel() {
		return officetel;
	}
	
	/**
	 * 设置办公电话 
	 */
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	
	/**
	 * 获取家庭电话 
	 */
	public String getHometel() {
		return hometel;
	}
	
	/**
	 * 设置家庭电话 
	 */
	public void setHometel(String hometel) {
		this.hometel = hometel;
	}
	
	/**
	 * 获取传真 
	 */
	public String getFax() {
		return fax;
	}
	
	/**
	 * 设置传真 
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * 获取邮箱 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置邮箱 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取邮编 
	 */
	public String getPostcode() {
		return postcode;
	}
	
	/**
	 * 设置邮编 
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	/**
	 * 获取住址 
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置住址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取国家 
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * 设置国家 
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * 获取省份 
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * 设置省份 
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * 获取城市 
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 设置城市 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 获取区 
	 */
	public String getRegional() {
		return regional;
	}
	
	/**
	 * 设置区 
	 */
	public void setRegional(String regional) {
		this.regional = regional;
	}
	
	/**
	 * 获取路 
	 */
	public String getRoad() {
		return road;
	}
	
	/**
	 * 设置路 
	 */
	public void setRoad(String road) {
		this.road = road;
	}
	
	/**
	 * 获取国籍 
	 */
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * 设置国籍 
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * 获取籍贯 
	 */
	public String getNativeplace() {
		return nativeplace;
	}
	
	/**
	 * 设置籍贯 
	 */
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	/**
	 * 获取 
	 */
	public String getSrctype() {
		return srctype;
	}
	
	/**
	 * 设置 
	 */
	public void setSrctype(String srctype) {
		this.srctype = srctype;
	}
	
	/**
	 * 获取最后修改时间 
	 */
	public Date getLastmodifytime() {
		return lastmodifytime;
	}
	
	/**
	 * 设置最后修改时间 
	 */
	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}
	
	/**
	 * 获取原始GUID，即在明源的GUID 
	 */
	public String getOriguid() {
		return origuid;
	}
	
	/**
	 * 设置原始GUID，即在明源的GUID 
	 */
	public void setOriguid(String origuid) {
		this.origuid = origuid;
	}
	
	/**
	 * 获取 
	 */
	public String getCreditevaluate() {
		return creditevaluate;
	}
	
	/**
	 * 设置 
	 */
	public void setCreditevaluate(String creditevaluate) {
		this.creditevaluate = creditevaluate;
	}
	
	/**
	 * 获取客户编号 
	 */
	public String getCstcode() {
		return cstcode;
	}
	
	/**
	 * 设置客户编号 
	 */
	public void setCstcode(String cstcode) {
		this.cstcode = cstcode;
	}
	
	/**
	 * 获取 
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * 设置 
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * 获取 
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * 设置 
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * 获取 
	 */
	public Float getIncoming() {
		return incoming;
	}
	
	/**
	 * 设置 
	 */
	public void setIncoming(Float incoming) {
		this.incoming = incoming;
	}
	
	/**
	 * 获取工作单位地址 
	 */
	public String getWorkaddr() {
		return workaddr;
	}
	
	/**
	 * 设置工作单位地址 
	 */
	public void setWorkaddr(String workaddr) {
		this.workaddr = workaddr;
	}
	
	/**
	 * 获取地址编号 
	 */
	public String getCompanytel() {
		return companytel;
	}
	
	/**
	 * 设置地址编号 
	 */
	public void setCompanytel(String companytel) {
		this.companytel = companytel;
	}
	
	/**
	 * 获取民族 
	 */
	public String getRace() {
		return race;
	}
	
	/**
	 * 设置民族 
	 */
	public void setRace(String race) {
		this.race = race;
	}
	
	/**
	 * 获取宗教信仰 
	 */
	public String getReligion() {
		return religion;
	}
	
	/**
	 * 设置宗教信仰 
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	/**
	 * 获取政治面貌 
	 */
	public String getPolitical() {
		return political;
	}
	
	/**
	 * 设置政治面貌 
	 */
	public void setPolitical(String political) {
		this.political = political;
	}
	
	/**
	 * 获取是否已婚 
	 */
	public Integer getIsmerried() {
		return ismerried;
	}
	
	/**
	 * 设置是否已婚 
	 */
	public void setIsmerried(Integer ismerried) {
		this.ismerried = ismerried;
	}
	
	/**
	 * 获取最后跟进时间 
	 */
	public Date getLasttouchtime() {
		return lasttouchtime;
	}
	
	/**
	 * 设置最后跟进时间 
	 */
	public void setLasttouchtime(Date lasttouchtime) {
		this.lasttouchtime = lasttouchtime;
	}
	
	/**
	 * 获取最后一次跟进记录，以JSON格式存储 
	 */
	public String getRecenttouch() {
		return recenttouch;
	}
	
	/**
	 * 设置最后一次跟进记录，以JSON格式存储 
	 */
	public void setRecenttouch(String recenttouch) {
		this.recenttouch = recenttouch;
	}
	
	/**
	 * 获取 
	 */
	public Date getLastassigntime() {
		return lastassigntime;
	}
	
	/**
	 * 设置 
	 */
	public void setLastassigntime(Date lastassigntime) {
		this.lastassigntime = lastassigntime;
	}
	
	/**
	 * 获取最后一次分配记录 
	 */
	public String getRecentassign() {
		return recentassign;
	}
	
	/**
	 * 设置最后一次分配记录 
	 */
	public void setRecentassign(String recentassign) {
		this.recentassign = recentassign;
	}
	
	/**
	 * 获取最后预约时间 
	 */
	public Date getLastappointtime() {
		return lastappointtime;
	}
	
	/**
	 * 设置最后预约时间 
	 */
	public void setLastappointtime(Date lastappointtime) {
		this.lastappointtime = lastappointtime;
	}
	
	/**
	 * 获取最近一次预约记录 
	 */
	public String getRecentappoint() {
		return recentappoint;
	}
	
	/**
	 * 设置最近一次预约记录 
	 */
	public void setRecentappoint(String recentappoint) {
		this.recentappoint = recentappoint;
	}
	
	/**
	 * 获取认知途径 
	 */
	public String getCognichannel() {
		return cognichannel;
	}
	
	/**
	 * 设置认知途径 
	 */
	public void setCognichannel(String cognichannel) {
		this.cognichannel = cognichannel;
	}
	
	/**
	 * 获取客户状态 
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置客户状态 
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getStaffguid() {
		return staffguid;
	}
	
	/**
	 * 设置 
	 */
	public void setStaffguid(String staffguid) {
		this.staffguid = staffguid;
	}
	
	/**
	 * 获取 
	 */
	public String getOwnerguid() {
		return ownerguid;
	}
	
	/**
	 * 设置 
	 */
	public void setOwnerguid(String ownerguid) {
		this.ownerguid = ownerguid;
	}
	
	/**
	 * 获取 
	 */
	public Date getCreatetime() {
		return createtime;
	}
	
	/**
	 * 设置 
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	/**
	 * 获取 
	 */
	public String getCardid15() {
		return cardid15;
	}
	
	/**
	 * 设置 
	 */
	public void setCardid15(String cardid15) {
		this.cardid15 = cardid15;
	}
	
	/**
	 * 获取1 身份证有效 手机有效、2 身份证有效 手机无效、3 身份证无效 手机有效 、4 身份证手机均无效（level为4的不应再往表里入了） 
	 */
	public Integer getLevel() {
		return level;
	}
	
	/**
	 * 设置1 身份证有效 手机有效、2 身份证有效 手机无效、3 身份证无效 手机有效 、4 身份证手机均无效（level为4的不应再往表里入了） 
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	/**
	 * 获取 
	 */
	public Integer getConflict() {
		return conflict;
	}
	
	/**
	 * 设置 
	 */
	public void setConflict(Integer conflict) {
		this.conflict = conflict;
	}
	
	/**
	 * 获取 
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * 设置 
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * 获取1.明源数据、2.物业数据 
	 */
	public Integer getSoutype() {
		return soutype;
	}
	
	/**
	 * 设置1.明源数据、2.物业数据 
	 */
	public void setSoutype(Integer soutype) {
		this.soutype = soutype;
	}
	
	/**
	 * 获取被合并客户的id串,英文逗号隔开 
	 */
	public String getOldcstguidlist() {
		return oldcstguidlist;
	}
	
	/**
	 * 设置被合并客户的id串,英文逗号隔开 
	 */
	public void setOldcstguidlist(String oldcstguidlist) {
		this.oldcstguidlist = oldcstguidlist;
	}
	
	/**
	 * 获取基准客户的id，合并之后的新客户id 
	 */
	public String getNewcstguid() {
		return newcstguid;
	}
	
	/**
	 * 设置基准客户的id，合并之后的新客户id 
	 */
	public void setNewcstguid(String newcstguid) {
		this.newcstguid = newcstguid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cstguid == null) ? 0 : cstguid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   CstCustomer other = (CstCustomer) obj;
		if (cstguid == null) {
			if (other.cstguid != null)
				return false;
		} else if (!cstguid.equals(other.getCstguid()))
		    return false;
	    return true;
	}
	


}
