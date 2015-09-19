package com.sxit.mgt.report.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.report.dao.WeixinDayDao;
import com.sxit.model.report.WzMemberDayStatic;

/**
 * @公司:深讯信科
 * @功能:日统计 Service
 * @作者:张如兵    
 * @日期:2015-04-14 17:03:24  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class WeixinDayService {

	@Autowired
	private WeixinDayDao weixinDayDao;


	/**
	 * 分页列表 日统计
	 **/
	public Page<WzMemberDayStatic> getWeixinDayList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return weixinDayDao.getWeixinDayList(map);
	}

	/**
	 * 统计最新的数据
	 * @return
	 */
	public WzMemberDayStatic getWeixinDaySum(Integer accountId)
	{
		return weixinDayDao.getLastDaySum(accountId);
	}
}


