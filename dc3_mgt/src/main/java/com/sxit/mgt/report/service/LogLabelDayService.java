package com.sxit.mgt.report.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.report.dao.LogLabelDayDao;
import com.sxit.model.report.LogLabelDay;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:按日统计 Service
 * @作者:张如兵    
 * @日期:2015-04-14 10:44:43  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class LogLabelDayService {

	@Autowired
	private LogLabelDayDao logLabelDayDao;

	/**
	 * 新增 按日统计
	 **/
	@Transactional
	public int insert(LogLabelDay logLabelDay) {
		return logLabelDayDao.insert(logLabelDay);
	}

	/**
	 * 批量新增 按日统计
	 **/
	@Transactional
	public void insertList(List<LogLabelDay> list) {
		if(list.size()>0)
		{
			logLabelDayDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 按日统计
	 **/
	@Transactional
	public void updateList(List<LogLabelDay> list) {
		if(list.size()>0)
		{
		 logLabelDayDao.updateList(list);
		}
	}

	/**
	 * 修改 按日统计
	 **/
	@Transactional
	public int update(LogLabelDay logLabelDay) {
		return logLabelDayDao.update(logLabelDay);
	}

	/**
	 * 是否存在 按日统计
	 **/
	public int isHave(String id) {
		return logLabelDayDao.isHave(id);
	}

	/**
	 *  删除按日统计
	 **/
	@Transactional
	public int delete(String id){
	       return logLabelDayDao.delete(id);
	}


	/**
	 *  标识删除按日统计
	 **/
	@Transactional
	public int updateToDelete(String id){
	       return logLabelDayDao.updateToDelete(id);
	}

	/**
	 * 分页列表 按日统计
	 **/
	public Page<LogLabelDay> getLogLabelDayList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return logLabelDayDao.getLogLabelDayList(map);
	}

	/**
	 * 已经存在的列表 按日统计
	 **/
	public List<LogLabelDay> getHaveLogLabelDayList(List<LogLabelDay> list) {
		return logLabelDayDao.getHaveLogLabelDayList(list);
	}

	/**
	 * 根据ID获取按日统计
	 */
	public LogLabelDay getLogLabelDayById(String id){
	       return logLabelDayDao.getLogLabelDayById(id);
	}

	/**
	 * ID Map 按日统计
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:logLabelDayDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


