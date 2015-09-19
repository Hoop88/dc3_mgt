package com.sxit.mgt.system.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.system.dao.SysExportColumnDao;
import com.sxit.mgt.system.dao.SysExportDao;
import com.sxit.model.system.SysExport;
import com.sxit.model.system.SysExportColumn;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:导出配置 Service
 * @作者:张如兵    
 * @日期:2015-07-20 14:45:36  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class SysExportService {

	@Autowired
	private SysExportDao sysExportDao;
	@Autowired
	private SysExportColumnDao sysExportColumnDao;
	/**
	 * 新增 导出配置
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public int insert(SysExport sysExport) {
		return sysExportDao.insert(sysExport);
	}

	/**
	 * 批量新增 导出配置
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public void insertList(List<SysExport> list) {
		if(list.size()>0)
		{
			sysExportDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 导出配置
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public void updateList(List<SysExport> list) {
		if(list.size()>0)
		{
		 sysExportDao.updateList(list);
		}
	}

	/**
	 * 修改 导出配置
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public int update(SysExport sysExport) {
		return sysExportDao.update(sysExport);
	}

	/**
	 * 是否存在 导出配置
	 **/
	public int isHave(Integer exportId) {
		return sysExportDao.isHave(exportId);
	}

	/**
	 *  删除导出配置
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public int delete(Integer exportId){
	       return sysExportDao.delete(exportId);
	}


	/**
	 *  标识删除导出配置
	 **/
	@Transactional
	public int updateToDelete(Integer exportId){
	       return sysExportDao.updateToDelete(exportId);
	}

	/**
	 * 分页列表 导出配置
	 **/
	public Page<SysExport> getSysExportList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return sysExportDao.getSysExportList(map);
	}

	/**
	 * 已经存在的列表 导出配置
	 **/
	public List<SysExport> getHaveSysExportList(List<SysExport> list) {
		return sysExportDao.getHaveSysExportList(list);
	}

	/**
	 * 根据ID获取导出配置
	 */
	public SysExport getSysExportById(Integer exportId){
	       return sysExportDao.getSysExportById(exportId);
	}

	/**
	 * ID Map 导出配置
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:sysExportDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}
	
	/**
	 * 获取导出的mappper
	 * 
	 * @return
	 */
	
	@Cacheable(value = "exportMap")
	public LinkedHashMap<String, List<SysExportColumn>> getExportMap() {

		LinkedHashMap<String, List<SysExportColumn>> map = new LinkedHashMap();

		List<SysExport> list = sysExportDao.getAllExportList();

		for (SysExport exp : list) {
			List<SysExportColumn> colist = sysExportColumnDao
					.getExportColumnListByExportId(exp.getExportId());
			map.put(exp.getExportCode(), colist);
		}
		return map;
	}

}


