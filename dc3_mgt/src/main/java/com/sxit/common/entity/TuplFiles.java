package com.sxit.common.entity;


/**
 * 文件(图片)上传相关的信息
 * @author lifodai
 * @date 2015-03-20
 */
public class TuplFiles {

	/**
	 * 保存文件名
	 */
	private String fileName;
	/**
	 * 上传文件名.
	 */
	private String originalName;
	/**
	 * 图片路径
	 */
	private String path ;
	
	/**
	 * 文件大小
	 */
	private Long size ;
	
	public TuplFiles(String fileName, String originalName, String path,
			Long size, String extName) {
		this.fileName = fileName;
		this.originalName = originalName;
		this.path = path;
		this.size = size;
		this.extName = extName;
	}
	/**
	 * 扩展名
	 */
	private String extName ;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	
	public String getPath() {
		path = path.replace("\\", "/") ;
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
}
