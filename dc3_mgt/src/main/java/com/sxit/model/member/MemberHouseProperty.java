package com.sxit.model.member;

import java.io.Serializable;

public class MemberHouseProperty implements Serializable {
	
	private String absolutelyFloor;  //实际楼层
	private String roomNo;           //楼层号码
	private String projAddress;      //项目地址
	private String projName;		 //项目名称
	private String status;           //房产状态
	private String planUrl;          //平面图地址
	private String roomUID;          //房屋id 主键
	private String bldArea;          //建筑面积
	private String tnArea;           //套内面积
	private String roomGUID;         //房屋关联id
	private String cstName;          //客户姓名
	private String relation;         //与业主的关系:1,配偶;2,子女;3,父母;4,朋友;5,亲戚;6,租户;7,业主
	private String binderState;      //绑定状态：1，已绑定；2，已解绑
	private String binderID;         //绑定id
	private String bldName;          //楼栋名称
	private String cstGUID;          //客户GUID
	private String city;			 //所属城市
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlanUrl() {
		return planUrl;
	}
	public void setPlanUrl(String planUrl) {
		this.planUrl = planUrl;
	}
	public String getAbsolutelyFloor() {
		return absolutelyFloor;
	}
	public void setAbsolutelyFloor(String absolutelyFloor) {
		this.absolutelyFloor = absolutelyFloor;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getProjAddress() {
		return projAddress;
	}
	public void setProjAddress(String projAddress) {
		this.projAddress = projAddress;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomUID() {
		return roomUID;
	}
	public void setRoomUID(String roomUID) {
		this.roomUID = roomUID;
	}
	public String getBldArea() {
		return bldArea;
	}
	public void setBldArea(String bldArea) {
		this.bldArea = bldArea;
	}
	public String getTnArea() {
		return tnArea;
	}
	public void setTnArea(String tnArea) {
		this.tnArea = tnArea;
	}
	public String getRoomGUID() {
		return roomGUID;
	}
	public void setRoomGUID(String roomGUID) {
		this.roomGUID = roomGUID;
	}
	public String getCstName() {
		return cstName;
	}
	public void setCstName(String cstName) {
		this.cstName = cstName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getBinderState() {
		return binderState;
	}
	public void setBinderState(String binderState) {
		this.binderState = binderState;
	}
	public String getBinderID() {
		return binderID;
	}
	public void setBinderID(String binderID) {
		this.binderID = binderID;
	}
	public String getBldName() {
		return bldName;
	}
	public void setBldName(String bldName) {
		this.bldName = bldName;
	}
	public String getCstGUID() {
		return cstGUID;
	}
	public void setCstGUID(String cstGUID) {
		this.cstGUID = cstGUID;
	}
}
