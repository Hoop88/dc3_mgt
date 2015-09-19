package com.sxit.api.base.dao;

import java.util.List;
import java.util.Map;

import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.LogApi;

/**
 * @公司:深讯信科
 * @功能:接口日志 Dao
 * @作者:张如兵    
 * @日期:2015-05-16 11:52:49  
 * @版本:1.0
 * @修改:
 */
 
public interface ApiDao {

        /**
	 *  新增接口日志
	 **/
	public int insert(LogApi api);
        /**
	 *  修改接口日志
	 **/
	public int update(LogApi api);
	/**
	 *  批量新增接口日志
	 **/
	public void insertList(List<LogApi> list);
	/**
	 *  批量更新接口日志
	 **/
	public void updateList(List<LogApi> list);
	/**
	 *  是否存在接口日志
	 **/
	public int isHave(Integer id);

	/**
	 *  删除接口日志
	 **/
	public int delete(Integer id);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer id);

	/**
	 *  已经存在接口日志列表
	 **/
	public List<LogApi> getHaveApiList(List<LogApi> list);
	/**
	 *  分页列表接口日志列表
	 **/
	public Page<LogApi> getApiList(Map map);

	/**
	 * 根据ID获取接口日志
	 */
	public LogApi getApiById(Integer id);

	/**
	 *  接口日志ID列表
	 **/
	public List<String> getIdList();

}


