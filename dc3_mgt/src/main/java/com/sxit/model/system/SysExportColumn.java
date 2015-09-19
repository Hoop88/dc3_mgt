package com.sxit.model.system;

import java.io.Serializable;
import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:导出配置项 Model
 * @作者:张如兵    
 * @日期:2015-07-20 14:49:55  
 * @版本:1.0
 * @修改:
 */
 
public class SysExportColumn  implements Serializable{

  	/**
	 * 
	 */
	private static final long serialVersionUID = -1182085009796636634L;

	/**
	 *值ID  
	 */
	private Integer columnId;
	
  	/**
	 *导出 ID  
	 */
	private Integer exportId; 
	/**
	 *导出编码 
	 */
	private String exportCode; 
	/**
	 *字段值 
	 */
	private String columnValue; 
	/**
	 *字段名 
	 */
	private String columnName; 
	/**
	 *字段类别 
	 */
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
	private Integer orderNum; 
	
	public SysExportColumn() { 
	  super();
	}
	
	/**
	 * 获取值ID  
	 */
	public Integer getColumnId() {
		return columnId;
	}
	
	/**
	 * 设置值ID  
	 */
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	
	public Integer getExportId() {
		return exportId;
	}

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
	 * 获取字段值 
	 */
	public String getColumnValue() {
		return columnValue;
	}
	
	/**
	 * 设置字段值 
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	
	/**
	 * 获取字段名 
	 */
	public String getColumnName() {
		return columnName;
	}
	
	/**
	 * 设置字段名 
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	/**
	 * 获取字段类别 
	 */
	public Integer getColumnType() {
		return columnType;
	}
	
	/**
	 * 设置字段类别 
	 */
	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}
	
	/**
	 * 获取map的key 
	 */
	public String getMapKey() {
		return mapKey;
	}
	
	/**
	 * 设置map的key 
	 */
	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}
	
	/**
	 * 获取时间格式 
	 */
	public String getDateFormat() {
		return dateFormat;
	}
	
	/**
	 * 设置时间格式 
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	/**
	 * 获取排序 
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	
	/**
	 * 设置排序 
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnId == null) ? 0 : columnId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysExportColumn other = (SysExportColumn) obj;
		if (columnId == null) {
			if (other.columnId != null)
				return false;
		} else if (!columnId.equals(other.getColumnId()))
		    return false;
	    return true;
	}
	


}
