package com.sxit.mgt.report.dao;

import java.util.Map;

import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.WzMemberDayStatic;

/**
 * @公司:深讯信科
 * @功能:日统计 Dao
 * @作者:张如兵
 * @日期:2015-04-14 17:03:24
 * @版本:1.0
 * @修改:
 */

public interface WeixinDayDao {

	/**
	 * 分页列表日统计列表
	 **/
	public Page<WzMemberDayStatic> getWeixinDayList(Map map);

	/**
	 * 统计
	 **/
	public WzMemberDayStatic getWeixinDaySum(Map map);
	
	/**
	 * 获取最后一次统计
	 **/
	public WzMemberDayStatic getLastDaySum(Integer accountId);
	
	
	

}
