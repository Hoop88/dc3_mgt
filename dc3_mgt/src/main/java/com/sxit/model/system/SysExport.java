package com.sxit.model.system;

import java.io.Serializable;
import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:导出配置 Model
 * @作者:张如兵    
 * @日期:2015-07-20 14:45:36  
 * @版本:1.0
 * @修改:
 */
 
public class SysExport  implements Serializable{

  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *导出 ID  
	 */
	private Integer exportId; 
	/**
	 *导出编码 
	 */
	private String exportCode; 
	/**
	 *导出名称 
	 */
	private String name; 
	
	public SysExport() { 
	  super();
	}
	
	/**
	 * 获取导出 ID  
	 */
	public Integer getExportId() {
		return exportId;
	}
	
	/**
	 * 设置导出 ID  
	 */
	public void setExportId(Integer exportId) {
		this.exportId = exportId;
	}
	
	/**
	 * 获取导出编码 
	 */
	public String getExportCode() {
		return exportCode;
	}
	
	/**
	 * 设置导出编码 
	 */
	public void setExportCode(String exportCode) {
		this.exportCode = exportCode;
	}
	
	/**
	 * 获取导出名称 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置导出名称 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exportId == null) ? 0 : exportId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysExport other = (SysExport) obj;
		if (exportId == null) {
			if (other.exportId != null)
				return false;
		} else if (!exportId.equals(other.getExportId()))
		    return false;
	    return true;
	}
	


}
