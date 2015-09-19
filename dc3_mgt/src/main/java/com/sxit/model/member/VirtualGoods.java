package com.sxit.model.member;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:商品管理 Model
 * @作者:甘志强    
 * @日期:2015-03-18 14:13:23  
 * @版本:1.0
 * @修改:
 */
 
public class VirtualGoods {

  	/**
	 *商品id 
	 */
	private Long goodsId; 
	/**
	 *虚拟商品名称 
	 */
	private String goodsName; 
	/**
	 *虚拟商品所需积分 
	 */
	private Double goodsPoint; 
	/**
	 *虚拟商品数量 
	 */
	private Integer goodsNum; 
	/**
	 *商品销售数量 
	 */
	private Integer goodsSalesNum; 
	/**
	 *虚拟商品缩略图 
	 */
	private String goodsImageThumb; 
	/**
	 *虚拟商品大图 
	 */
	private String goodsImage; 
	/**
	 *虚拟商品简介 
	 */
	private String goodsMark; 
	/**
	 *商品状态：0未审核，1已审核，2已下架 
	 */
	private Integer state; 
	/**
	 *创建时间 
	 */
	private Date createTime; 
	/**
	 *修改时间 
	 */
	private Date modifyTime; 
	/**
	 *修改人id 
	 */
	private Long modifyUserId; 
	/**
	 *修改人姓名 
	 */
	private String modifyUserName; 
	/**
	 *审核时间 
	 */
	private Date verifyTime; 
	/**
	 *审核人id 
	 */
	private Long verifyUserId; 
	/**
	 *审核人姓名 
	 */
	private String verifyUserName; 
	/**
	 *下架时间 
	 */
	private Date cancelTime; 
	/**
	 *下架人id 
	 */
	private Long cancelUserId; 
	/**
	 *下架人姓名 
	 */
	private String cancelUserName; 
	/**
	 *最后修改时间 
	 */
	private Date lastModifyTime; 
	
	public VirtualGoods() { 
	  super();
	}
	
	/**
	 * 获取商品id 
	 */
	public Long getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置商品id 
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
	 * 获取虚拟商品所需积分 
	 */
	public Double getGoodsPoint() {
		return goodsPoint;
	}
	
	/**
	 * 设置虚拟商品所需积分 
	 */
	public void setGoodsPoint(Double goodsPoint) {
		this.goodsPoint = goodsPoint;
	}
	
	/**
	 * 获取虚拟商品数量 
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}
	
	/**
	 * 设置虚拟商品数量 
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	/**
	 * 获取商品销售数量 
	 */
	public Integer getGoodsSalesNum() {
		return goodsSalesNum;
	}
	
	/**
	 * 设置商品销售数量 
	 */
	public void setGoodsSalesNum(Integer goodsSalesNum) {
		this.goodsSalesNum = goodsSalesNum;
	}
	
	/**
	 * 获取虚拟商品缩略图 
	 */
	public String getGoodsImageThumb() {
		return goodsImageThumb;
	}
	
	/**
	 * 设置虚拟商品缩略图 
	 */
	public void setGoodsImageThumb(String goodsImageThumb) {
		this.goodsImageThumb = goodsImageThumb;
	}
	
	/**
	 * 获取虚拟商品大图 
	 */
	public String getGoodsImage() {
		return goodsImage;
	}
	
	/**
	 * 设置虚拟商品大图 
	 */
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	
	/**
	 * 获取虚拟商品简介 
	 */
	public String getGoodsMark() {
		return goodsMark;
	}
	
	/**
	 * 设置虚拟商品简介 
	 */
	public void setGoodsMark(String goodsMark) {
		this.goodsMark = goodsMark;
	}
	
	/**
	 * 获取商品状态：0未审核，1已审核，2已下架 
	 */
	public Integer getState() {
		return state;
	}
	
	/**
	 * 设置商品状态：0未审核，1已审核，2已下架 
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	/**
	 * 获取创建时间 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置创建时间 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取修改时间 
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	
	/**
	 * 设置修改时间 
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	 * 获取修改人id 
	 */
	public Long getModifyUserId() {
		return modifyUserId;
	}
	
	/**
	 * 设置修改人id 
	 */
	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	
	/**
	 * 获取修改人姓名 
	 */
	public String getModifyUserName() {
		return modifyUserName;
	}
	
	/**
	 * 设置修改人姓名 
	 */
	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}
	
	/**
	 * 获取审核时间 
	 */
	public Date getVerifyTime() {
		return verifyTime;
	}
	
	/**
	 * 设置审核时间 
	 */
	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}
	
	/**
	 * 获取审核人id 
	 */
	public Long getVerifyUserId() {
		return verifyUserId;
	}
	
	/**
	 * 设置审核人id 
	 */
	public void setVerifyUserId(Long verifyUserId) {
		this.verifyUserId = verifyUserId;
	}
	
	/**
	 * 获取审核人姓名 
	 */
	public String getVerifyUserName() {
		return verifyUserName;
	}
	
	/**
	 * 设置审核人姓名 
	 */
	public void setVerifyUserName(String verifyUserName) {
		this.verifyUserName = verifyUserName;
	}
	
	/**
	 * 获取下架时间 
	 */
	public Date getCancelTime() {
		return cancelTime;
	}
	
	/**
	 * 设置下架时间 
	 */
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	
	/**
	 * 获取下架人id 
	 */
	public Long getCancelUserId() {
		return cancelUserId;
	}
	
	/**
	 * 设置下架人id 
	 */
	public void setCancelUserId(Long cancelUserId) {
		this.cancelUserId = cancelUserId;
	}
	
	/**
	 * 获取下架人姓名 
	 */
	public String getCancelUserName() {
		return cancelUserName;
	}
	
	/**
	 * 设置下架人姓名 
	 */
	public void setCancelUserName(String cancelUserName) {
		this.cancelUserName = cancelUserName;
	}
	
	/**
	 * 获取最后修改时间 
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	
	/**
	 * 设置最后修改时间 
	 */
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   VirtualGoods other = (VirtualGoods) obj;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.getGoodsId()))
		    return false;
	    return true;
	}
	


}
