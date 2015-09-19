package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysExport;

/**
 * @公司:深讯信科
 * @功能:导出配置 Dao
 * @作者:张如兵    
 * @日期:2015-07-20 14:45:36  
 * @版本:1.0
 * @修改:
 */
 
public interface SysExportDao {

        /**
	 *  新增导出配置
	 **/
	public int insert(SysExport sysExport);
        /**
	 *  修改导出配置
	 **/
	public int update(SysExport sysExport);
	/**
	 *  批量新增导出配置
	 **/
	public void insertList(List<SysExport> list);
	/**
	 *  批量更新导出配置
	 **/
	public void updateList(List<SysExport> list);
	/**
	 *  是否存在导出配置
	 **/
	public int isHave(Integer exportId);

	/**
	 *  删除导出配置
	 **/
	public int delete(Integer exportId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer exportId);

	/**
	 *  已经存在导出配置列表
	 **/
	public List<SysExport> getHaveSysExportList(List<SysExport> list);
	/**
	 *  分页列表导出配置列表
	 **/
	public Page<SysExport> getSysExportList(Map map);

	/**
	 * 根据ID获取导出配置
	 */
	public SysExport getSysExportById(Integer exportId);

	/**
	 *  导出配置ID列表
	 **/
	public List<String> getIdList();

	/**
	 * 获取
	 * @return
	 */
	public List<SysExport> getAllExportList();
}


