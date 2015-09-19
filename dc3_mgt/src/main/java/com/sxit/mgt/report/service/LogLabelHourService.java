package com.sxit.mgt.report.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.report.dao.LogLabelHourDao;
import com.sxit.model.report.LogLabelHour;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:按时段统计 Service
 * @作者:张如兵    
 * @日期:2015-04-14 10:51:22  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class LogLabelHourService {

	@Autowired
	private LogLabelHourDao logLabelHourDao;

	/**
	 * 新增 按时段统计
	 **/
	@Transactional
	public int insert(LogLabelHour logLabelHour) {
		return logLabelHourDao.insert(logLabelHour);
	}

	/**
	 * 批量新增 按时段统计
	 **/
	@Transactional
	public void insertList(List<LogLabelHour> list) {
		if(list.size()>0)
		{
			logLabelHourDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 按时段统计
	 **/
	@Transactional
	public void updateList(List<LogLabelHour> list) {
		if(list.size()>0)
		{
		 logLabelHourDao.updateList(list);
		}
	}

	/**
	 * 修改 按时段统计
	 **/
	@Transactional
	public int update(LogLabelHour logLabelHour) {
		return logLabelHourDao.update(logLabelHour);
	}

	/**
	 * 是否存在 按时段统计
	 **/
	public int isHave(String id) {
		return logLabelHourDao.isHave(id);
	}

	/**
	 *  删除按时段统计
	 **/
	@Transactional
	public int delete(String id){
	       return logLabelHourDao.delete(id);
	}


	/**
	 *  标识删除按时段统计
	 **/
	@Transactional
	public int updateToDelete(String id){
	       return logLabelHourDao.updateToDelete(id);
	}

	/**
	 * 分页列表 按时段统计
	 **/
	public Page<LogLabelHour> getLogLabelHourList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return logLabelHourDao.getLogLabelHourList(map);
	}

	/**
	 * 已经存在的列表 按时段统计
	 **/
	public List<LogLabelHour> getHaveLogLabelHourList(List<LogLabelHour> list) {
		return logLabelHourDao.getHaveLogLabelHourList(list);
	}

	/**
	 * 根据ID获取按时段统计
	 */
	public LogLabelHour getLogLabelHourById(String id){
	       return logLabelHourDao.getLogLabelHourById(id);
	}

	/**
	 * ID Map 按时段统计
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:logLabelHourDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


