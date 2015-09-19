package com.sxit.mgt.report.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.sxit.common.utils.MyBeanUtils;

import com.sxit.common.pagehelper.JSONData;
import com.sxit.common.pagehelper.JSONMessage;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.report.service.LogLabelHourService;
import com.sxit.mgt.report.service.LogLabelService;
import com.sxit.mgt.report.vo.LogLabelHourModel;
import com.sxit.model.report.LogLabel;
import com.sxit.model.report.LogLabelHour;

/**
 * @公司:深讯信科
 * @功能:按时段统计 Action
 * @作者:张如兵
 * @日期:2015-04-14 10:51:22
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/report")
public class LogLabelHourAction extends BaseAction {

	@Autowired
	private LogLabelHourService logLabelHourService;
	
	@Autowired
	private LogLabelService logLabelService;

	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourManage")
	public String manage(Integer parentId,Model model) {
		
		LogLabel logLabel = logLabelService.getLogLabelById(parentId);
		
		if(logLabel!=null){
			model.addAttribute("lableId",logLabel.getLabelId());
			model.addAttribute("lableName",logLabel.getLabelName());
		}else{
			model.addAttribute("lableId",0);
			model.addAttribute("lableName","");
			parentId = 0;
		}
		
		Map map = logLabelService.getLabelMap(parentId);
		
		model.addAttribute("labelmap", map);

		return "report/logLabelHour/manage";
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourList")
	public @ResponseBody
	JSONMessage list(@ModelAttribute SearchVo vo,Integer parentId,Integer labelId, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}
		
		if(parentId==null)
		{
			parentId=0;
		}

		Map map =	vo.getMap();
		
		map.put("parentId", parentId);
		
		if(labelId!=null && labelId>0)
		{
			map.put("labelId", labelId);
		}
		if(StringUtils.isNotBlank(vo.getBeginDate()))
		{
			if(vo.getBeginDate().length()==10)
			{
				String date= vo.getBeginDate();
				String year1 = date.substring(0,4);
				String month1 = date.substring(5,7);
				String day1 = date.substring(8,10);
				map.put("year1", year1);
				map.put("month1", month1);
				map.put("day1", day1);
				
			}
		}
		if(StringUtils.isNotBlank(vo.getEndDate()))
		{
			if(vo.getEndDate().length()==10)
			{
				String date= vo.getEndDate();
				String year2 = date.substring(0,4);
				String month2 = date.substring(5,7);
				String day2 = date.substring(8,10);
				map.put("year2", year2);
				map.put("month2", month2);
				map.put("day2", day2);
			}
				
		}
		
		Page page = logLabelHourService
				.getLogLabelHourList(pagevo, map);

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
	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam String id) {
		String message = "";
		if (id == null) {
			message = "按时段统计ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabelHour logLabelHour = logLabelHourService.getLogLabelHourById(id);
		if (logLabelHour == null) {
			message = "未找到该按时段统计";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", logLabelHour);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourAdd")
	public @ResponseBody
	ResultMessage add(
			@Valid @ModelAttribute LogLabelHourModel logLabelHourModel,
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
		LogLabelHour logLabelHour = new LogLabelHour();
		BeanUtils.copyProperties(logLabelHourModel, logLabelHour);

		logLabelHourService.insert(logLabelHour);
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
	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourEdit")
	public @ResponseBody
	ResultMessage edit(
			@Valid @ModelAttribute LogLabelHourModel logLabelHourModel,
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
			message = "按时段统计ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabelHour logLabelHour = logLabelHourService.getLogLabelHourById(id);
		if (logLabelHour == null) {
			message = "未找到该按时段统计";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(logLabelHourModel, logLabelHour,
				logLabelHourModel.colset);

		logLabelHourService.update(logLabelHour);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@AuthPassport(rightCode = "logLabelHour_manage")
	@RequestMapping(value = "/logLabelHourDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam String id) {

		if (id == null) {
			return ResultMessage.errorMsg("按时段统计ID不能空");
		}

		LogLabelHour logLabelHour = logLabelHourService.getLogLabelHourById(id);
		if (logLabelHour == null) {
			return ResultMessage.errorMsg("未找到该按时段统计");
		}

		// 判断状态

		logLabelHourService.delete(id);

		return ResultMessage.successMsg("删除成功");
	}

}
