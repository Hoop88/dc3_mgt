package com.sxit.mgt.report.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.LogLabel;

/**
 * @公司:深讯信科
 * @功能:标签设置 Dao
 * @作者:张如兵    
 * @日期:2015-04-13 16:30:54  
 * @版本:1.0
 * @修改:
 */
 
public interface LogLabelDao {

        /**
	 *  新增标签设置
	 **/
	public int insert(LogLabel logLabel);
        /**
	 *  修改标签设置
	 **/
	public int update(LogLabel logLabel);
	/**
	 *  批量新增标签设置
	 **/
	public void insertList(List<LogLabel> list);
	/**
	 *  批量更新标签设置
	 **/
	public void updateList(List<LogLabel> list);
	/**
	 *  是否存在标签设置
	 **/
	public int isHave(Integer labelId);

	/**
	 *  删除标签设置
	 **/
	public int delete(Integer labelId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer labelId);

	/**
	 *  已经存在标签设置列表
	 **/
	public List<LogLabel> getHaveLogLabelList(List<LogLabel> list);
	/**
	 *  分页列表标签设置列表
	 **/
	public Page<LogLabel> getLogLabelList(Map map);

	/**
	 * 根据ID获取标签设置
	 */
	public LogLabel getLogLabelById(Integer labelId);

	/**
	 *  标签设置ID列表
	 **/
	public List<LogLabel> getLabelList(Integer parentId);

}


