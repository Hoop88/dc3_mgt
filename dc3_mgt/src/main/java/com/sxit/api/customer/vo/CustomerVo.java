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
public class CustomerVo {

	/** 会员GUID */
	private Integer cstguid;

	@JsonProperty("cstName")
	private String cstname;

	@JsonProperty("cstType")
	private String csttype;

	@JsonProperty("cardType")
	private String cardtype;

	@JsonProperty("cardID")
	private String cardid;

	@JsonProperty("cardID15")
	private String cardid15;

	@JsonProperty("mobileTel")
	private String mobiletel;
	
	@JsonProperty("homeTel")
	private String hometel;

	@JsonProperty("email")
	private String email;

	@JsonProperty("address")
	private String address;

	@JsonProperty("province")
	private String province;

	@JsonProperty("city")
	private String city;

	@JsonProperty("regional")
	private String regional;

	@JsonProperty("road")
	private String road;

	public Integer getCstguid() {
		return cstguid;
	}

	public void setCstguid(Integer cstguid) {
		this.cstguid = cstguid;
	}

	public String getCstname() {
		return cstname;
	}

	public void setCstname(String cstname) {
		this.cstname = cstname;
	}

	public String getCsttype() {
		return csttype;
	}


	public Integer toCsttype() {
		
		if ("个人".equals(csttype)) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public void setCsttype(String csttype) {
		this.csttype = csttype;
	}

	public String getCardtype() {
		return cardtype;
	}
	
	public Integer toCardtype() {
		if ("身份证".equals(csttype)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardid15() {
		return cardid15;
	}

	public void setCardid15(String cardid15) {
		this.cardid15 = cardid15;
	}

	public String getMobiletel() {
		return mobiletel;
	}

	public void setMobiletel(String mobiletel) {
		this.mobiletel = mobiletel;
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public CustomerVo() {
		super();
		// TODO Auto-generated constructor stub
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		CustomerVo other = (CustomerVo) obj;
		if (cstguid == null) {
			if (other.cstguid != null)
				return false;
		} else if (!cstguid.equals(other.getCstguid()))
			return false;
		return true;
	}

}
