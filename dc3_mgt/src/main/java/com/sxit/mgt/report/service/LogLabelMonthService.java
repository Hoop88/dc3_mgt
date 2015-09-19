package com.sxit.mgt.report.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.report.dao.LogLabelMonthDao;
import com.sxit.model.report.LogLabelMonth;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:按月统计 Service
 * @作者:张如兵    
 * @日期:2015-04-14 10:40:48  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class LogLabelMonthService {

	@Autowired
	private LogLabelMonthDao logLabelMonthDao;

	/**
	 * 新增 按月统计
	 **/
	@Transactional
	public int insert(LogLabelMonth logLabelMonth) {
		return logLabelMonthDao.insert(logLabelMonth);
	}

	/**
	 * 批量新增 按月统计
	 **/
	@Transactional
	public void insertList(List<LogLabelMonth> list) {
		if(list.size()>0)
		{
			logLabelMonthDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 按月统计
	 **/
	@Transactional
	public void updateList(List<LogLabelMonth> list) {
		if(list.size()>0)
		{
		 logLabelMonthDao.updateList(list);
		}
	}

	/**
	 * 修改 按月统计
	 **/
	@Transactional
	public int update(LogLabelMonth logLabelMonth) {
		return logLabelMonthDao.update(logLabelMonth);
	}

	/**
	 * 是否存在 按月统计
	 **/
	public int isHave(String id) {
		return logLabelMonthDao.isHave(id);
	}

	/**
	 *  删除按月统计
	 **/
	@Transactional
	public int delete(String id){
	       return logLabelMonthDao.delete(id);
	}


	/**
	 *  标识删除按月统计
	 **/
	@Transactional
	public int updateToDelete(String id){
	       return logLabelMonthDao.updateToDelete(id);
	}

	/**
	 * 分页列表 按月统计
	 **/
	public Page<LogLabelMonth> getLogLabelMonthList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return logLabelMonthDao.getLogLabelMonthList(map);
	}

	/**
	 * 已经存在的列表 按月统计
	 **/
	public List<LogLabelMonth> getHaveLogLabelMonthList(List<LogLabelMonth> list) {
		return logLabelMonthDao.getHaveLogLabelMonthList(list);
	}

	/**
	 * 根据ID获取按月统计
	 */
	public LogLabelMonth getLogLabelMonthById(String id){
	       return logLabelMonthDao.getLogLabelMonthById(id);
	}

	/**
	 * ID Map 按月统计
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:logLabelMonthDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


