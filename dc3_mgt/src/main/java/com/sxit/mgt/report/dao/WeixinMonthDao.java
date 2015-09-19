package com.sxit.mgt.report.dao;

import java.util.Map;

import com.sxit.common.pagehelper.Page;
import com.sxit.model.report.WzMemberMonthStatic;

/**
 * @公司:深讯信科
 * @功能:日统计 Dao
 * @作者:张如兵    
 * @日期:2015-04-14 17:03:32  
 * @版本:1.0
 * @修改:
 */
 
public interface WeixinMonthDao {

    
	/**
	 *  分页列表日统计列表
	 **/
	public Page<WzMemberMonthStatic> getWeixinMonthList(Map map);


}


