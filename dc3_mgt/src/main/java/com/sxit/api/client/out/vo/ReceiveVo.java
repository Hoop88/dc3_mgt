package com.sxit.api.client.out.vo;

import java.util.Date;

/**
 * 接收推荐和预约的数据
 * 
 * @author agu
 * 
 *         预约数据：时间，姓名，性别，联系方式，明源客户guid（客户带，非客户不带），明源项目guid
 *         推荐看房：明源项目guid，被推荐人姓名，被推荐人性别，被推荐人手机，推荐人明源客户guid，被推荐人手机号查出来的客户guid
 */
public class ReceiveVo {

	/**
	 * 数据中心ID.
	 */
	private String guid;
	/**
	 * 类别 1 推荐 2 预约
	 */
	private Integer type;
	/**
	 * 来源.
	 */
	private String dataFrom;
	/**
	 * 客户名称.
	 */
	private String customerName;
	/**
	 * 手机号码.
	 */
	private String mobile;
	/**
	 * 性别| 1 男  2 女.
	 */
	private Integer gender;
	/**
	 * 项目编号.
	 */
	private String projectCode;
	/**
	 * 推荐时间.
	 */
	private Date commendTime;
	/**
	 * 备注说明.
	 */
	private String remark;
	/**
	 * 是否预约.
	 */
	private Integer isReserve;
	/**
	 * 预约日期.
	 */
	private Date reserveDate;
	/**
	 * 预约时间.
	 */
	private String reserveTime;
	/**
	 * 指定代理公司 | 公司简写 公司ID 公司编码.
	 */
	private String corp;
	/**
	 * 指定置业顾问 | 姓名 手机号码.
	 */
	private String advise;



	public ReceiveVo(String guid, Integer type, String dataFrom,
			String customerName, String mobile, String projectCode,
			Date commendTime, String remark, Integer isReserve,
			Date reserveDate, String reserveTime, String corp, String advise) {
		super();
		this.guid = guid;
		this.type = type;
		this.dataFrom = dataFrom;
		this.customerName = customerName;
		this.mobile = mobile;
		this.projectCode = projectCode;
		this.commendTime = commendTime;
		this.remark = remark;
		this.isReserve = isReserve;
		this.reserveDate = reserveDate;
		this.reserveTime = reserveTime;
		this.corp = corp;
		this.advise = advise;
	}

	public ReceiveVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Date getCommendTime() {
		return commendTime;
	}

	public void setCommendTime(Date commendTime) {
		this.commendTime = commendTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(Integer isReserve) {
		this.isReserve = isReserve;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

}
