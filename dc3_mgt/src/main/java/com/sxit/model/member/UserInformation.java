package com.sxit.model.member;

public class UserInformation {
	
	/**
	 * 客户ID
	 */
	private String cstGUID;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 证件类型
	 */
	private String cardType;
	/**
	 * 证件号码
	 */
	private String cardID;
	/**
	 * 手机号码
	 */
	private String  mobile;
	/**
	 * 固定电话
	 */
	private String homeTel;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 微信昵称
	 */
	private String nickName;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 会员ID
	 */
	private String memCode;
	/**
	 * 会员等级
	 */
	private String maxMemLevel;
	/**
	 * 所属城市
	 */
	private String belongAreaName;
	/**
	 * 入会日期
	 */
	private String joinDate;
	/**
	 * 入会渠道
	 */
	private String joinPath;
	/**
	 * 奖励积分
	 */
	private String point;
	/**
	 * 升级积分
	 */
	private String sjPoint;
	/**
	 * 会员ID
	 * @return
	 */
	private String memGUID;
	/**
	 * 微信ID
	 */
	private String openId;
	
	private Float ljsjPoint;
	private Float ljPoint;
	/**
	 * 姓名
	 */
	private String cstName;
	/**
	 * 是否业主
	 */
	private String memStation;
	public String getCstGUID() {
		return cstGUID;
	}
	public void setCstGUID(String cstGUID) {
		this.cstGUID = cstGUID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public String getMaxMemLevel() {
		return maxMemLevel;
	}
	public void setMaxMemLevel(String maxMemLevel) {
		this.maxMemLevel = maxMemLevel;
	}
	public String getBelongAreaName() {
		return belongAreaName;
	}
	public void setBelongAreaName(String belongAreaName) {
		this.belongAreaName = belongAreaName;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getJoinPath() {
		return joinPath;
	}
	public void setJoinPath(String joinPath) {
		this.joinPath = joinPath;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getSjPoint() {
		return sjPoint;
	}
	public void setSjPoint(String sjPoint) {
		this.sjPoint = sjPoint;
	}
	public String getMemGUID() {
		return memGUID;
	}
	public void setMemGUID(String memGUID) {
		this.memGUID = memGUID;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	public String getCstName() {
		return cstName;
	}
	public void setCstName(String cstName) {
		this.cstName = cstName;
	}
	public String getMemStation() {
		return memStation;
	}
	public void setMemStation(String memStation) {
		this.memStation = memStation;
	}
	public void setLjsjPoint(Float ljsjPoint) {
		this.ljsjPoint = ljsjPoint;
	}
	public void setLjPoint(Float ljPoint) {
		this.ljPoint = ljPoint;
	}
	public Float getLjsjPoint() {
		return ljsjPoint;
	}
	public Float getLjPoint() {
		return ljPoint;
	}

}
