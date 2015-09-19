package com.sxit.api.base.vo;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sxit.common.config.InterfaceConfig;
import com.sxit.common.security.DESCoder;
import com.sxit.common.security.MD5;

public class RequestVo {

	@NotBlank(message = "命令字不能为空")
	private String command;

	private String content;

	private String imei; // imei

	private String modelNum; // 型号

	@NotBlank(message = "系统版本号不能为空")
	private String versionNum;

	@NotBlank(message = "应用编号")
	private String appCode;
	
	@NotBlank(message = "应用版本号不能为空")
	private String appVersion;

	@NotBlank(message = "请求时间不能为空")
	private String time;

	@NotBlank(message = "验证码不能为空")
	private String vercode;

	private int isdes = 1; // 是否des加密

	public RequestVo() {
		super();
	}

	public RequestVo(String command, String content, String versionNum,
			String appVersion) {
		this.command = command;
		this.versionNum = versionNum;
		this.appVersion = appVersion;
		this.content = content;
		this.time = System.currentTimeMillis() + "";
	}

	/**
	 * 加密内容
	 * 
	 * @return
	 */
	public RequestVo desContent() {
		if (StringUtils.isNotBlank(content)) {
			this.content = DESCoder.encrypt(content, InterfaceConfig.deskey);
		}
		return this;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getVercode() {
		String md5String = getMd5String();
		this.vercode = MD5.md5(md5String, InterfaceConfig.md5key);
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public int getIsdes() {
		return isdes;
	}

	public void setIsdes(int isdes) {
		this.isdes = isdes;
	}

	/**
	 * 获取验证串
	 * 
	 * @return
	 */
	@JsonIgnore
	public String getMd5String() {
		StringBuffer sb = new StringBuffer();
		sb.append(command);
		if (content != null) {
			sb.append(content);
		}
		if (versionNum != null) {
			sb.append(versionNum);
		}
		if (appCode != null) {
			sb.append(appCode);
		}
		if (appVersion != null) {
			sb.append(appVersion);
		}
		sb.append(time);
		sb.append(isdes);
		return sb.toString();
	}

	/**
	 * 验证
	 * 
	 * @param md5String
	 * @param time
	 * @param verifyCode
	 * @return
	 */
	public boolean verify() {
		String md5String = this.getMd5String();
		String md5code = MD5.md5(md5String, InterfaceConfig.md5key);

		// 验证MD5
		if (InterfaceConfig.useMd5) {
			if (!md5code.equals(this.vercode)) {
				return false;
			}
		}

		// 验证超时
		if (InterfaceConfig.checkTime) {
			long systime = System.currentTimeMillis();

			long reqtime = 0;
			if (StringUtils.isNumeric(this.time)) {
				reqtime = Long.parseLong(this.time);
			}

			if (systime - reqtime > InterfaceConfig.delayTime) {
				return false;
			}
		}

		return true;
	}

}
