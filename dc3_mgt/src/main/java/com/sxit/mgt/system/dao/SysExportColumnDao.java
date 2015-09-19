package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysExportColumn;

/**
 * @公司:深讯信科
 * @功能:导出配置项 Dao
 * @作者:张如兵    
 * @日期:2015-07-20 14:49:55  
 * @版本:1.0
 * @修改:
 */
 
public interface SysExportColumnDao {

        /**
	 *  新增导出配置项
	 **/
	public int insert(SysExportColumn sysExportColumn);
        /**
	 *  修改导出配置项
	 **/
	public int update(SysExportColumn sysExportColumn);
	/**
	 *  批量新增导出配置项
	 **/
	public void insertList(List<SysExportColumn> list);
	/**
	 *  批量更新导出配置项
	 **/
	public void updateList(List<SysExportColumn> list);
	/**
	 *  是否存在导出配置项
	 **/
	public int isHave(Integer columnId);

	/**
	 *  删除导出配置项
	 **/
	public int delete(Integer columnId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer columnId);

	/**
	 *  配置项列表
	 **/
	public List<SysExportColumn> getExportColumnListByExportId(Integer exportId);
	/**
	 *  分页列表导出配置项列表
	 **/
	public Page<SysExportColumn> getSysExportColumnList(Map map);

	/**
	 * 根据ID获取导出配置项
	 */
	public SysExportColumn getSysExportColumnById(Integer columnId);

	/**
	 *  导出配置项ID列表
	 **/
	public List<String> getIdList();
	


}


