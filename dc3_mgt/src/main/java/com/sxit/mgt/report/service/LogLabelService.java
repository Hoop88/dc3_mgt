package com.sxit.mgt.report.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.report.dao.LogLabelDao;
import com.sxit.model.report.LogLabel;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:标签设置 Service
 * @作者:张如兵    
 * @日期:2015-04-13 16:30:54  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class LogLabelService {

	@Autowired
	private LogLabelDao logLabelDao;

	/**
	 * 新增 标签设置
	 **/
	@Transactional
	public int insert(LogLabel logLabel) {
		return logLabelDao.insert(logLabel);
	}

	/**
	 * 批量新增 标签设置
	 **/
	@Transactional
	public void insertList(List<LogLabel> list) {
		if(list.size()>0)
		{
			logLabelDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 标签设置
	 **/
	@Transactional
	public void updateList(List<LogLabel> list) {
		if(list.size()>0)
		{
		 logLabelDao.updateList(list);
		}
	}

	/**
	 * 修改 标签设置
	 **/
	@Transactional
	public int update(LogLabel logLabel) {
		return logLabelDao.update(logLabel);
	}

	/**
	 * 是否存在 标签设置
	 **/
	public int isHave(Integer labelId) {
		return logLabelDao.isHave(labelId);
	}

	/**
	 *  删除标签设置
	 **/
	@Transactional
	public int delete(Integer labelId){
	       return logLabelDao.delete(labelId);
	}


	/**
	 *  标识删除标签设置
	 **/
	@Transactional
	public int updateToDelete(Integer labelId){
	       return logLabelDao.updateToDelete(labelId);
	}

	/**
	 * 分页列表 标签设置
	 **/
	public Page<LogLabel> getLogLabelList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return logLabelDao.getLogLabelList(map);
	}

	/**
	 * 已经存在的列表 标签设置
	 **/
	public List<LogLabel> getHaveLogLabelList(List<LogLabel> list) {
		return logLabelDao.getHaveLogLabelList(list);
	}

	/**
	 * 根据ID获取标签设置
	 */
	public LogLabel getLogLabelById(Integer labelId){
	       return logLabelDao.getLogLabelById(labelId);
	}

	/**
	 * ID Map 标签设置
	 **/
	public Map<String,String> getLabelMap(Integer parentId){
		Map<String,String> map = new HashMap();
		for(LogLabel label:logLabelDao.getLabelList(parentId))
		{
			map.put(label.getLabelId().toString(), label.getLabelName());
		}
		return map;
	}

}


