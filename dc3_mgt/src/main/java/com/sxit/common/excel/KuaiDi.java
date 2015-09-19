package com.sxit.common.excel;

import java.util.Date;

public class KuaiDi {

	private Integer billId;
	private String sendId;
	private String sendCorp;
	private Date sendTime;
	private String sendInfo;

	public Integer getBillId() {
		return billId;
	}

	@XslImport(name = "订单ID", columnNum = 1, notNull = true, type = DataEnum.Int, maxLength = 100)
	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getSendId() {
		return sendId;
	}

	@XslImport(name = "快递单号", columnNum = 2, regex = "", notNull = true, type = DataEnum.String, maxLength = 100)
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	@XslImport(name = "发货时间", columnNum = 3, notNull = true, type = DataEnum.Date)
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendCorp() {
		return sendCorp;
	}

	@XslImport(name = "快递公司", columnNum = 4, notNull = true, type = DataEnum.Map, mapName = "corpMap")
	public void setSendCorp(String sendCorp) {
		this.sendCorp = sendCorp;
	}

	public String getSendInfo() {
		return sendInfo;
	}

	@XslImport(name = "备注", columnNum = 8, notNull = false, type = DataEnum.String, maxLength = 100)
	public void setSendInfo(String sendInfo) {
		this.sendInfo = sendInfo;
	}

	/**
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$ 手机号码
	}

}
