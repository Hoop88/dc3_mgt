package com.sxit.model.member;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:积分商城 Model
 * @作者:甘志强    
 * @日期:2015-03-17 15:56:45  
 * @版本:1.0
 * @修改:
 */
 
public class VirtualGoodsExchange {

  	/**
	 *兑换id 
	 */
	private Long exchangeId; 
	/**
	 *兑换编号 
	 */
	private String exchangeNo; 
	/**
	 *客户id 
	 */
	private Long cstGuid; 
	/**
	 *虚拟商品id 
	 */
	private Long goodsId; 
	/**
	 *兑换时间 
	 */
	private Date createTime; 
	/**
	 *兑换数量 
	 */
	private Integer goodsNum; 
	/**
	 *虚拟商品名称 
	 */
	private String goodsName; 
	/**
	 *消耗积分 
	 */
	private Double totalPiont; 
	/**
	 *虚拟商品积分单价 
	 */
	private Double point; 
	/**
	 *兑换码，多个，以','分开 
	 */
	private String exchangeCode; 
	/**
	 *客户姓名 
	 */
	private String cstName; 
	/**
	 *手机号 
	 */
	private String mobile; 
	/**
	 *会员卡号 
	 */
	private String memberCode; 
	/**
	 *城市编号 
	 */
	private String cityId; 
	/**
	 *城市名称 
	 */
	private String cityName; 
	
	public VirtualGoodsExchange() { 
	  super();
	}
	
	/**
	 * 获取兑换id 
	 */
	public Long getExchangeId() {
		return exchangeId;
	}
	
	/**
	 * 设置兑换id 
	 */
	public void setExchangeId(Long exchangeId) {
		this.exchangeId = exchangeId;
	}
	
	/**
	 * 获取兑换编号 
	 */
	public String getExchangeNo() {
		return exchangeNo;
	}
	
	/**
	 * 设置兑换编号 
	 */
	public void setExchangeNo(String exchangeNo) {
		this.exchangeNo = exchangeNo;
	}
	
	/**
	 * 获取客户id 
	 */
	public Long getCstGuid() {
		return cstGuid;
	}
	
	/**
	 * 设置客户id 
	 */
	public void setCstGuid(Long cstGuid) {
		this.cstGuid = cstGuid;
	}
	
	/**
	 * 获取虚拟商品id 
	 */
	public Long getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置虚拟商品id 
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	/**
	 * 获取兑换时间 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置兑换时间 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取兑换数量 
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}
	
	/**
	 * 设置兑换数量 
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	/**
	 * 获取虚拟商品名称 
	 */
	public String getGoodsName() {
		return goodsName;
	}
	
	/**
	 * 设置虚拟商品名称 
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	/**
	 * 获取消耗积分 
	 */
	public Double getTotalPiont() {
		return totalPiont;
	}
	
	/**
	 * 设置消耗积分 
	 */
	public void setTotalPiont(Double totalPiont) {
		this.totalPiont = totalPiont;
	}
	
	/**
	 * 获取虚拟商品积分单价 
	 */
	public Double getPoint() {
		return point;
	}
	
	/**
	 * 设置虚拟商品积分单价 
	 */
	public void setPoint(Double point) {
		this.point = point;
	}
	
	/**
	 * 获取兑换码，多个，以','分开 
	 */
	public String getExchangeCode() {
		return exchangeCode;
	}
	
	/**
	 * 设置兑换码，多个，以','分开 
	 */
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	
	/**
	 * 获取客户姓名 
	 */
	public String getCstName() {
		return cstName;
	}
	
	/**
	 * 设置客户姓名 
	 */
	public void setCstName(String cstName) {
		this.cstName = cstName;
	}
	
	/**
	 * 获取手机号 
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置手机号 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取会员卡号 
	 */
	public String getMemberCode() {
		return memberCode;
	}
	
	/**
	 * 设置会员卡号 
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	
	/**
	 * 获取城市编号 
	 */
	public String getCityId() {
		return cityId;
	}
	
	/**
	 * 设置城市编号 
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	/**
	 * 获取城市名称 
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * 设置城市名称 
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exchangeId == null) ? 0 : exchangeId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   VirtualGoodsExchange other = (VirtualGoodsExchange) obj;
		if (exchangeId == null) {
			if (other.exchangeId != null)
				return false;
		} else if (!exchangeId.equals(other.getExchangeId()))
		    return false;
	    return true;
	}
	


}
