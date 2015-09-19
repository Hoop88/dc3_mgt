package com.sxit.mgt.system.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.system.dao.SysParamDao;
import com.sxit.model.system.SysParams;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:系统参数 Service
 * @作者:张如兵    
 * @日期:2015-07-20 14:00:23  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class SysParamService {

	@Autowired
	private SysParamDao sysParamDao;

	/**
	 * 新增 系统参数
	 **/
	@Transactional
	public int insert(SysParams sysParam) {
		return sysParamDao.insert(sysParam);
	}

	/**
	 * 批量新增 系统参数
	 **/
	@Transactional
	public void insertList(List<SysParams> list) {
		if(list.size()>0)
		{
			sysParamDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 系统参数
	 **/
	@Transactional
	public void updateList(List<SysParams> list) {
		if(list.size()>0)
		{
		 sysParamDao.updateList(list);
		}
	}

	/**
	 * 修改 系统参数
	 **/
	@Transactional
	public int update(SysParams sysParam) {
		return sysParamDao.update(sysParam);
	}

	/**
	 * 是否存在 系统参数
	 **/
	public int isHave(Long paramsId) {
		return sysParamDao.isHave(paramsId);
	}

	/**
	 *  删除系统参数
	 **/
	@Transactional
	public int delete(Long paramsId){
	       return sysParamDao.delete(paramsId);
	}


	/**
	 *  标识删除系统参数
	 **/
	@Transactional
	public int updateToDelete(Long paramsId){
	       return sysParamDao.updateToDelete(paramsId);
	}

	/**
	 * 分页列表 系统参数
	 **/
	public Page<SysParams> getSysParamList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return sysParamDao.getSysParamList(map);
	}

	/**
	 * 已经存在的列表 系统参数
	 **/
	public List<SysParams> getHaveSysParamList(List<SysParams> list) {
		return sysParamDao.getHaveSysParamList(list);
	}

	/**
	 * 根据ID获取系统参数
	 */
	public SysParams getSysParamById(Long paramsId){
	       return sysParamDao.getSysParamById(paramsId);
	}

	/**
	 * ID Map 系统参数
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:sysParamDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


