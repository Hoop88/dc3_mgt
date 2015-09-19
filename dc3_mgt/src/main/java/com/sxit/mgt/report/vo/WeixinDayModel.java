package com.sxit.mgt.report.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:日统计 Model
 * @作者:张如兵    
 * @日期:2015-04-18 14:50:17  
 * @版本:1.0
 * @修改:
 */
 
public class WeixinDayModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *day+accountId 
	 */
	 @NotBlank(message = "day+accountId不能为空")
	private String id; 
	/**
	 *记录日期 
	 */
	 @NotBlank(message = "记录日期不能为空")
	private String day; 
	/**
	 *新关注 
	 */
	 @NotNull(message = "新关注不能为空")
	private Integer newsubscribe; 
	/**
	 *取消关注 
	 */
	 @NotNull(message = "取消关注不能为空")
	private Integer unsubscribe; 
	/**
	 *净增关注 
	 */
	 @NotNull(message = "净增关注不能为空")
	private Integer subscribe; 
	/**
	 *粉丝关注 
	 */
	 @NotNull(message = "粉丝关注不能为空")
	private Integer countsubscribe; 
	/**
	 *新入会 
	 */
	 @NotNull(message = "新入会不能为空")
	private Integer newadd; 
	/**
	 *累计入会 
	 */
	 @NotNull(message = "累计入会不能为空")
	private Integer countadd; 
	/**
	 *老会员绑定 
	 */
	 @NotNull(message = "老会员绑定不能为空")
	private Integer oldbind; 
	/**
	 *累计老会员绑定 
	 */
	 @NotNull(message = "累计老会员绑定不能为空")
	private Integer countoldbind; 
	/**
	 *累计绑定会员 
	 */
	 @NotNull(message = "累计绑定会员不能为空")
	private Integer countbind; 
	/**
	 *微信会员 
	 */
	 @NotNull(message = "微信会员不能为空")
	private Integer weixinmember; 
	/**
	 *公众账号主键id 
	 */
	 @NotNull(message = "公众账号主键id不能为空")
	private Long accountid; 
	
	public WeixinDayModel() { 
	  super();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
	    colset.add("id");
		this.id = id;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
	    colset.add("day");
		this.day = day;
	}
	
	public Integer getNewsubscribe() {
		return newsubscribe;
	}
	
	public void setNewsubscribe(Integer newsubscribe) {
	    colset.add("newsubscribe");
		this.newsubscribe = newsubscribe;
	}
	
	public Integer getUnsubscribe() {
		return unsubscribe;
	}
	
	public void setUnsubscribe(Integer unsubscribe) {
	    colset.add("unsubscribe");
		this.unsubscribe = unsubscribe;
	}
	
	public Integer getSubscribe() {
		return subscribe;
	}
	
	public void setSubscribe(Integer subscribe) {
	    colset.add("subscribe");
		this.subscribe = subscribe;
	}
	
	public Integer getCountsubscribe() {
		return countsubscribe;
	}
	
	public void setCountsubscribe(Integer countsubscribe) {
	    colset.add("countsubscribe");
		this.countsubscribe = countsubscribe;
	}
	
	public Integer getNewadd() {
		return newadd;
	}
	
	public void setNewadd(Integer newadd) {
	    colset.add("newadd");
		this.newadd = newadd;
	}
	
	public Integer getCountadd() {
		return countadd;
	}
	
	public void setCountadd(Integer countadd) {
	    colset.add("countadd");
		this.countadd = countadd;
	}
	
	public Integer getOldbind() {
		return oldbind;
	}
	
	public void setOldbind(Integer oldbind) {
	    colset.add("oldbind");
		this.oldbind = oldbind;
	}
	
	public Integer getCountoldbind() {
		return countoldbind;
	}
	
	public void setCountoldbind(Integer countoldbind) {
	    colset.add("countoldbind");
		this.countoldbind = countoldbind;
	}
	
	public Integer getCountbind() {
		return countbind;
	}
	
	public void setCountbind(Integer countbind) {
	    colset.add("countbind");
		this.countbind = countbind;
	}
	
	public Integer getWeixinmember() {
		return weixinmember;
	}
	
	public void setWeixinmember(Integer weixinmember) {
	    colset.add("weixinmember");
		this.weixinmember = weixinmember;
	}
	
	public Long getAccountid() {
		return accountid;
	}
	
	public void setAccountid(Long accountid) {
	    colset.add("accountid");
		this.accountid = accountid;
	}
	


}
