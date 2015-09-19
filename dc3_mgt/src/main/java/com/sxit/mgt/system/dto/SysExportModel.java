package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:导出配置 Model
 * @作者:张如兵    
 * @日期:2015-07-20 14:45:36  
 * @版本:1.0
 * @修改:
 */
 
public class SysExportModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *导出 ID  
	 */
	private Integer exportId; 
	/**
	 *导出编码 
	 */
	 @NotBlank(message = "导出编码不能为空")
	private String exportCode; 
	/**
	 *导出名称 
	 */
	 @NotBlank(message = "导出名称不能为空")
	private String name; 
	
	public SysExportModel() { 
	  super();
	}
	
	public Integer getExportId() {
		return exportId;
	}
	
	public void setExportId(Integer exportId) {
	    colset.add("exportId");
		this.exportId = exportId;
	}
	
	public String getExportCode() {
		return exportCode;
	}
	
	public void setExportCode(String exportCode) {
	    colset.add("exportCode");
		this.exportCode = exportCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
	    colset.add("name");
		this.name = name;
	}
	


}
