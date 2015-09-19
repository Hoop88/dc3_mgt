package com.sxit.mgt.system.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.mgt.system.dao.SysExportColumnDao;
import com.sxit.model.system.SysExportColumn;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:导出配置项 Service
 * @作者:张如兵
 * @日期:2015-07-20 14:49:55
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class SysExportColumnService {

	@Autowired
	private SysExportColumnDao sysExportColumnDao;

	/**
	 * 新增 导出配置项
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public int insert(SysExportColumn sysExportColumn) {
		return sysExportColumnDao.insert(sysExportColumn);
	}

	/**
	 * 批量新增 导出配置项
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public void insertList(List<SysExportColumn> list) {
		if (list.size() > 0) {
			sysExportColumnDao.insertList(list);
		}

	}

	/**
	 * 批量修改 导出配置项
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public void updateList(List<SysExportColumn> list) {
		if (list.size() > 0) {
			sysExportColumnDao.updateList(list);
		}
	}

	/**
	 * 修改 导出配置项
	 **/
	@CacheEvict(value = "exportMap", allEntries = true)
	@Transactional
	public int update(SysExportColumn sysExportColumn) {
		return sysExportColumnDao.update(sysExportColumn);
	}

	/**
	 * 是否存在 导出配置项
	 **/
	public int isHave(Integer columnId) {
		return sysExportColumnDao.isHave(columnId);
	}

	/**
	 * 删除导出配置项
	 **/
	@Transactional
	public int delete(Integer columnId) {
		return sysExportColumnDao.delete(columnId);
	}

	/**
	 * 标识删除导出配置项
	 **/
	@Transactional
	public int updateToDelete(Integer columnId) {
		return sysExportColumnDao.updateToDelete(columnId);
	}

	/**
	 * 分页列表 导出配置项
	 **/
	public Page<SysExportColumn> getSysExportColumnList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return sysExportColumnDao.getSysExportColumnList(map);
	}

	/**
	 * 配置项列表
	 *
	 */

	public List<SysExportColumn> getExportColumnListByExportId(Integer exportId) {
		return sysExportColumnDao.getExportColumnListByExportId(exportId);
	}

	/**
	 * 根据ID获取导出配置项
	 */
	public SysExportColumn getSysExportColumnById(Integer columnId) {
		return sysExportColumnDao.getSysExportColumnById(columnId);
	}

	/**
	 * ID Map 导出配置项
	 **/
	public Map<String, String> getIdMap() {
		Map<String, String> map = new HashMap();
		for (String id : sysExportColumnDao.getIdList()) {
			map.put(id, id);
		}
		return map;
	}

}
