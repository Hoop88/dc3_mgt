package com.sxit.mgt.report.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.LogLabelMonth;

/**
 * @公司:深讯信科
 * @功能:按月统计 Dao
 * @作者:张如兵    
 * @日期:2015-04-14 10:40:48  
 * @版本:1.0
 * @修改:
 */
 
public interface LogLabelMonthDao {

        /**
	 *  新增按月统计
	 **/
	public int insert(LogLabelMonth logLabelMonth);
        /**
	 *  修改按月统计
	 **/
	public int update(LogLabelMonth logLabelMonth);
	/**
	 *  批量新增按月统计
	 **/
	public void insertList(List<LogLabelMonth> list);
	/**
	 *  批量更新按月统计
	 **/
	public void updateList(List<LogLabelMonth> list);
	/**
	 *  是否存在按月统计
	 **/
	public int isHave(String id);

	/**
	 *  删除按月统计
	 **/
	public int delete(String id);

	/**
	 * 标识删除
	 */
	public int updateToDelete(String id);

	/**
	 *  已经存在按月统计列表
	 **/
	public List<LogLabelMonth> getHaveLogLabelMonthList(List<LogLabelMonth> list);
	/**
	 *  分页列表按月统计列表
	 **/
	public Page<LogLabelMonth> getLogLabelMonthList(Map map);

	/**
	 * 根据ID获取按月统计
	 */
	public LogLabelMonth getLogLabelMonthById(String id);

	/**
	 *  按月统计ID列表
	 **/
	public List<String> getIdList();

}


