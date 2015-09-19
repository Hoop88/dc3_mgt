package com.sxit.mgt.report.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.report.dao.WeixinMonthDao;
import com.sxit.model.report.WzMemberMonthStatic;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:日统计 Service
 * @作者:张如兵    
 * @日期:2015-04-14 17:03:32  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class WeixinMonthService {

	@Autowired
	private WeixinMonthDao weixinMonthDao;




	/**
	 * 分页列表 日统计
	 **/
	public Page<WzMemberMonthStatic> getWeixinMonthList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return weixinMonthDao.getWeixinMonthList(map);
	}

}


