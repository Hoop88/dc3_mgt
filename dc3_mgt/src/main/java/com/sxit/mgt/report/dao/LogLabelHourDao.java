package com.sxit.mgt.report.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.LogLabelHour;

/**
 * @公司:深讯信科
 * @功能:按时段统计 Dao
 * @作者:张如兵    
 * @日期:2015-04-14 10:51:22  
 * @版本:1.0
 * @修改:
 */
 
public interface LogLabelHourDao {

        /**
	 *  新增按时段统计
	 **/
	public int insert(LogLabelHour logLabelHour);
        /**
	 *  修改按时段统计
	 **/
	public int update(LogLabelHour logLabelHour);
	/**
	 *  批量新增按时段统计
	 **/
	public void insertList(List<LogLabelHour> list);
	/**
	 *  批量更新按时段统计
	 **/
	public void updateList(List<LogLabelHour> list);
	/**
	 *  是否存在按时段统计
	 **/
	public int isHave(String id);

	/**
	 *  删除按时段统计
	 **/
	public int delete(String id);

	/**
	 * 标识删除
	 */
	public int updateToDelete(String id);

	/**
	 *  已经存在按时段统计列表
	 **/
	public List<LogLabelHour> getHaveLogLabelHourList(List<LogLabelHour> list);
	/**
	 *  分页列表按时段统计列表
	 **/
	public Page<LogLabelHour> getLogLabelHourList(Map map);

	/**
	 * 根据ID获取按时段统计
	 */
	public LogLabelHour getLogLabelHourById(String id);

	/**
	 *  按时段统计ID列表
	 **/
	public List<String> getIdList();

}


