package com.sxit.mgt.upload.vo;

/**
 * 文件上传返回的(ajax)信息
 * @author lifodai
 * @date 2015-03-20
 */
public class UploadRes {
	
	public static final Integer SUCESS = 0 ;
	
	public static final Integer ERROR = -1 ;
	
	private Integer code;
	private String fileName;
	private String path;

	public UploadRes(Integer code, String fileName, String path) {
		this.code = code;
		this.fileName = fileName;
		this.path = path;
	}

	public UploadRes(Integer code) {
		super();
		this.code = code;
	}

	public UploadRes() {
		super();
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
