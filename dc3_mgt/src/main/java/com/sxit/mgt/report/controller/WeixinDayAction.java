package com.sxit.mgt.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.pagehelper.JSONMessage;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.report.service.WeixinDayService;
import com.sxit.model.report.WzMemberDayStatic;


/**
 * @公司:深讯信科
 * @功能:日统计 Action
 * @作者:张如兵
 * @日期:2015-04-14 17:03:24
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/report")
public class WeixinDayAction extends BaseAction {

	@Autowired
	private WeixinDayService weixinDayService;

	@AuthPassport(rightCode = "weixinDay_manage")
	@RequestMapping(value = "/weixinDayManage")
	public String manage(Model model) {
		
		//性能有影响 
		WzMemberDayStatic dayCount = weixinDayService.getWeixinDaySum(95);
		model.addAttribute("dayCount", dayCount);
		
		return "report/weixinDay/manage";
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "weixinDay_manage")
	@RequestMapping(value = "/weixinDayList")
	public @ResponseBody
	JSONMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		Page page = weixinDayService.getWeixinDayList(pagevo, vo.getMap());

		JSONMessage message = new JSONMessage();

		message.setLocal(false);
		message.setData(page);
		message.setSuccess(true);
		message.setTotal(page.getTotal());
		message.setPage(page.getPageNum());

		return message;
	}

}
