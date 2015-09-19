package com.sxit.mgt.system.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @公司:深讯信科
 * @功能:导出配置项 Model
 * @作者:张如兵    
 * @日期:2015-07-20 14:49:55  
 * @版本:1.0
 * @修改:
 */
 
public class SysExportColumnModel {

  	public Set<String> colset = new HashSet<String>(0);
	/**
	 *值ID  
	 */
	private Integer columnId; 
	
	/**
	 *导出 ID 
	 */
	 @NotNull(message = "导出 ID不能为空")
	private Integer exportId; 
	/**
	 *导出编码 
	 */
	 @NotBlank(message = "导出编码不能为空")
	private String exportCode; 
	/**
	 *字段值 
	 */
	 @NotBlank(message = "字段值不能为空")
	private String columnValue; 
	/**
	 *字段名 
	 */
	 @NotBlank(message = "字段名不能为空")
	private String columnName; 
	/**
	 *字段类别 
	 */
	 @NotNull(message = "字段类别不能为空")
	private Integer columnType; 
	/**
	 *map的key 
	 */

	private String mapKey; 
	/**
	 *时间格式 
	 */
	private String dateFormat; 
	/**
	 *排序 
	 */
	 @NotNull(message = "排序不能为空")
	private Integer orderNum; 
	
	public SysExportColumnModel() { 
	  super();
	}
	
	public Integer getColumnId() {
		return columnId;
	}
	
	public void setColumnId(Integer columnId) {
	    colset.add("columnId");
		this.columnId = columnId;
	}
	
	public Integer getExportId() {
		return exportId;
	}

	public void setExportId(Integer exportId) {
		this.exportId = exportId;
	}

	public String getExportCode() {
		return exportCode;
	}
	
	public void setExportCode(String exportCode) {
	    colset.add("exportCode");
		this.exportCode = exportCode;
	}
	
	public String getColumnValue() {
		return columnValue;
	}
	
	public void setColumnValue(String columnValue) {
	    colset.add("columnValue");
		this.columnValue = columnValue;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
	    colset.add("columnName");
		this.columnName = columnName;
	}
	
	public Integer getColumnType() {
		return columnType;
	}
	
	public void setColumnType(Integer columnType) {
	    colset.add("columnType");
		this.columnType = columnType;
	}
	
	public String getMapKey() {
		return mapKey;
	}
	
	public void setMapKey(String mapKey) {
	    colset.add("mapKey");
		this.mapKey = mapKey;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}
	
	public void setDateFormat(String dateFormat) {
	    colset.add("dateFormat");
		this.dateFormat = dateFormat;
	}
	
	public Integer getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(Integer orderNum) {
	    colset.add("orderNum");
		this.orderNum = orderNum;
	}
	


}
