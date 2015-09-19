package com.sxit.mgt.report.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.LogLabelDay;

/**
 * @公司:深讯信科
 * @功能:按日统计 Dao
 * @作者:张如兵    
 * @日期:2015-04-14 10:44:43  
 * @版本:1.0
 * @修改:
 */
 
public interface LogLabelDayDao {

        /**
	 *  新增按日统计
	 **/
	public int insert(LogLabelDay logLabelDay);
        /**
	 *  修改按日统计
	 **/
	public int update(LogLabelDay logLabelDay);
	/**
	 *  批量新增按日统计
	 **/
	public void insertList(List<LogLabelDay> list);
	/**
	 *  批量更新按日统计
	 **/
	public void updateList(List<LogLabelDay> list);
	/**
	 *  是否存在按日统计
	 **/
	public int isHave(String id);

	/**
	 *  删除按日统计
	 **/
	public int delete(String id);

	/**
	 * 标识删除
	 */
	public int updateToDelete(String id);

	/**
	 *  已经存在按日统计列表
	 **/
	public List<LogLabelDay> getHaveLogLabelDayList(List<LogLabelDay> list);
	/**
	 *  分页列表按日统计列表
	 **/
	public Page<LogLabelDay> getLogLabelDayList(Map map);

	/**
	 * 根据ID获取按日统计
	 */
	public LogLabelDay getLogLabelDayById(String id);

	/**
	 *  按日统计ID列表
	 **/
	public List<String> getIdList();

}


