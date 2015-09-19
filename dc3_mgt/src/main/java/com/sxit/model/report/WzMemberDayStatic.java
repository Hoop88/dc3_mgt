package com.sxit.model.report;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:日统计 Model
 * @作者:张如兵    
 * @日期:2015-04-18 14:50:17  
 * @版本:1.0
 * @修改:
 */
 
public class WzMemberDayStatic {

  	/**
	 *day+accountId 
	 */
	private String id; 
	/**
	 *记录日期 
	 */
	private String day; 
	/**
	 *新关注 
	 */
	private Integer newsubscribe; 
	/**
	 *取消关注 
	 */
	private Integer unsubscribe; 
	/**
	 *净增关注 
	 */
	private Integer subscribe; 
	/**
	 *粉丝关注 
	 */
	private Integer countsubscribe; 
	/**
	 *新入会 
	 */
	private Integer newadd; 
	/**
	 *累计入会 
	 */
	private Integer countadd; 
	/**
	 *老会员绑定 
	 */
	private Integer oldbind; 
	/**
	 *累计老会员绑定 
	 */
	private Integer countoldbind; 
	/**
	 *累计绑定会员 
	 */
	private Integer countbind; 
	/**
	 *微信会员 
	 */
	private Integer weixinmember; 
	/**
	 *公众账号主键id 
	 */
	private Long accountid; 
	
	public WzMemberDayStatic() { 
	  super();
	}
	
	/**
	 * 获取day+accountId 
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置day+accountId 
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取记录日期 
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * 设置记录日期 
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * 获取新关注 
	 */
	public Integer getNewsubscribe() {
		return newsubscribe;
	}
	
	/**
	 * 设置新关注 
	 */
	public void setNewsubscribe(Integer newsubscribe) {
		this.newsubscribe = newsubscribe;
	}
	
	/**
	 * 获取取消关注 
	 */
	public Integer getUnsubscribe() {
		return unsubscribe;
	}
	
	/**
	 * 设置取消关注 
	 */
	public void setUnsubscribe(Integer unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	
	/**
	 * 获取净增关注 
	 */
	public Integer getSubscribe() {
		return subscribe;
	}
	
	/**
	 * 设置净增关注 
	 */
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	
	/**
	 * 获取粉丝关注 
	 */
	public Integer getCountsubscribe() {
		return countsubscribe;
	}
	
	/**
	 * 设置粉丝关注 
	 */
	public void setCountsubscribe(Integer countsubscribe) {
		this.countsubscribe = countsubscribe;
	}
	
	/**
	 * 获取新入会 
	 */
	public Integer getNewadd() {
		return newadd;
	}
	
	/**
	 * 设置新入会 
	 */
	public void setNewadd(Integer newadd) {
		this.newadd = newadd;
	}
	
	/**
	 * 获取累计入会 
	 */
	public Integer getCountadd() {
		return countadd;
	}
	
	/**
	 * 设置累计入会 
	 */
	public void setCountadd(Integer countadd) {
		this.countadd = countadd;
	}
	
	/**
	 * 获取老会员绑定 
	 */
	public Integer getOldbind() {
		return oldbind;
	}
	
	/**
	 * 设置老会员绑定 
	 */
	public void setOldbind(Integer oldbind) {
		this.oldbind = oldbind;
	}
	
	/**
	 * 获取累计老会员绑定 
	 */
	public Integer getCountoldbind() {
		return countoldbind;
	}
	
	/**
	 * 设置累计老会员绑定 
	 */
	public void setCountoldbind(Integer countoldbind) {
		this.countoldbind = countoldbind;
	}
	
	/**
	 * 获取累计绑定会员 
	 */
	public Integer getCountbind() {
		return countbind;
	}
	
	/**
	 * 设置累计绑定会员 
	 */
	public void setCountbind(Integer countbind) {
		this.countbind = countbind;
	}
	
	/**
	 * 获取微信会员 
	 */
	public Integer getWeixinmember() {
		return weixinmember;
	}
	
	/**
	 * 设置微信会员 
	 */
	public void setWeixinmember(Integer weixinmember) {
		this.weixinmember = weixinmember;
	}
	
	/**
	 * 获取公众账号主键id 
	 */
	public Long getAccountid() {
		return accountid;
	}
	
	/**
	 * 设置公众账号主键id 
	 */
	public void setAccountid(Long accountid) {
		this.accountid = accountid;
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
		   WzMemberDayStatic other = (WzMemberDayStatic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
		    return false;
	    return true;
	}
	


}
