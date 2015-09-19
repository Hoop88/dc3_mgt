package com.sxit.mgt.report.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.pagehelper.JSONMessage;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.utils.MyBeanUtils;
import com.sxit.mgt.report.service.LogLabelMonthService;
import com.sxit.mgt.report.service.LogLabelService;
import com.sxit.mgt.report.vo.LogLabelMonthModel;
import com.sxit.model.report.LogLabel;
import com.sxit.model.report.LogLabelMonth;

/**
 * @公司:深讯信科
 * @功能:按月统计 Action
 * @作者:张如兵
 * @日期:2015-04-14 10:40:48
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/report")
public class LogLabelMonthAction extends BaseAction {

	@Autowired
	private LogLabelMonthService logLabelMonthService;

	@Autowired
	private LogLabelService logLabelService;

	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthManage")
	public String manage(Integer parentId, Model model) {

		LogLabel logLabel = logLabelService.getLogLabelById(parentId);

		if (logLabel != null) {
			model.addAttribute("lableId", logLabel.getLabelId());
			model.addAttribute("lableName", logLabel.getLabelName());
		} else {
			model.addAttribute("lableId", 0);
			model.addAttribute("lableName", "");
			parentId = 0;
		}

		Map map = logLabelService.getLabelMap(parentId);
		model.addAttribute("labelmap", map);
	
		Map monthMap = new LinkedHashMap();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df1  = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df2  = new SimpleDateFormat("yyyy年MM月");
		

		
		for(int i=0;i<7;i++)
		{
		 String d1=	df1.format(cal.getTime());
		 String d2=	df2.format(cal.getTime());
		 
		 monthMap.put(d1, d2);
		 cal.add(Calendar.MONTH, -1);
		}
		
		model.addAttribute("monthMap", monthMap);
		
		return "report/logLabelMonth/manage";
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthList")
	public @ResponseBody
	JSONMessage list(@ModelAttribute SearchVo vo, Integer parentId,String month,Integer labelId,
			PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		if (parentId == null) {
			parentId = 0;
		}
		
		Map map = vo.getMap();

		map.put("parentId", parentId);
		
		if(StringUtils.isNotBlank(month))
		{
			if(month.length()==7)
			{
				String y = month.substring(0,4);
				String m = month.substring(5, 7);
				map.put("year", y);
				map.put("month", m);
			}
		}
		
		if(labelId!=null && labelId>0)
		{
			map.put("labelId", labelId);
		}

		Page page = logLabelMonthService.getLogLabelMonthList(pagevo, map);

		JSONMessage message = new JSONMessage();

		message.setLocal(false);
		message.setData(page);
		message.setSuccess(true);
		message.setTotal(page.getTotal());
		message.setPage(page.getPageNum());

		return message;
	}

	/**
	 * 明细
	 * 
	 * @param id
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam String id) {
		String message = "";
		if (id == null) {
			message = "按月统计ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabelMonth logLabelMonth = logLabelMonthService
				.getLogLabelMonthById(id);
		if (logLabelMonth == null) {
			message = "未找到该按月统计";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", logLabelMonth);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthAdd")
	public @ResponseBody
	ResultMessage add(
			@Valid @ModelAttribute LogLabelMonthModel logLabelMonthModel,
			Errors errors) {
		// 判断验证是否通过
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (FieldError e : errors.getFieldErrors()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(e.getDefaultMessage());
				break;
			}
			return ResultMessage.errorMsg(sb.toString());
		}
		LogLabelMonth logLabelMonth = new LogLabelMonth();
		BeanUtils.copyProperties(logLabelMonthModel, logLabelMonth);

		logLabelMonthService.insert(logLabelMonth);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param id
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthEdit")
	public @ResponseBody
	ResultMessage edit(
			@Valid @ModelAttribute LogLabelMonthModel logLabelMonthModel,
			@RequestParam String id, Errors errors) {
		// 判断验证是否通过
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (FieldError e : errors.getFieldErrors()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(e.getDefaultMessage());
				break;
			}
			return ResultMessage.errorMsg(sb.toString());
		}

		String message = "";
		if (id == null) {
			message = "按月统计ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabelMonth logLabelMonth = logLabelMonthService
				.getLogLabelMonthById(id);
		if (logLabelMonth == null) {
			message = "未找到该按月统计";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(logLabelMonthModel, logLabelMonth,
				logLabelMonthModel.colset);

		logLabelMonthService.update(logLabelMonth);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelMonth_manage")
	@RequestMapping(value = "/logLabelMonthDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam String id) {

		if (id == null) {
			return ResultMessage.errorMsg("按月统计ID不能空");
		}

		LogLabelMonth logLabelMonth = logLabelMonthService
				.getLogLabelMonthById(id);
		if (logLabelMonth == null) {
			return ResultMessage.errorMsg("未找到该按月统计");
		}

		logLabelMonthService.delete(id);

		return ResultMessage.successMsg("删除成功");
	}

}
