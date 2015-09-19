package com.sxit.mgt.report.controller;

import java.util.Map;

import javax.validation.Valid;

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
import com.sxit.mgt.report.service.LogLabelService;
import com.sxit.mgt.report.vo.LogLabelModel;
import com.sxit.model.report.LogLabel;

/**
 * @公司:深讯信科
 * @功能:标签设置 Action
 * @作者:张如兵
 * @日期:2015-04-13 16:30:54
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/report")
public class LogLabelAction extends BaseAction {

	@Autowired
	private LogLabelService logLabelService;

	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelManage")
	public String manage(Integer parentId,Model model) {
		
		LogLabel logLabel = logLabelService.getLogLabelById(parentId);
		
		if(logLabel!=null){
			model.addAttribute("lableId",logLabel.getLabelId());
			model.addAttribute("lableName",logLabel.getLabelName());
		}else{
			model.addAttribute("lableId",0);
			model.addAttribute("lableName","");
		}

		return "report/logLabel/manage";
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelList")
	public @ResponseBody
	JSONMessage list(@ModelAttribute SearchVo vo,Integer parentId, PageVo pagevo) {

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
		
		Page page = logLabelService.getLogLabelList(pagevo, map);

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
	 * @param labelId
	 * @return
	 */
	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer labelId) {
		String message = "";
		if (labelId == null) {
			message = "标签设置ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabel logLabel = logLabelService.getLogLabelById(labelId);
		if (logLabel == null) {
			message = "未找到该标签设置";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", logLabel);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelAdd")
	public @ResponseBody
	ResultMessage add(@Valid @ModelAttribute LogLabelModel logLabelModel,
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
		LogLabel logLabel = new LogLabel();
		BeanUtils.copyProperties(logLabelModel, logLabel);
		logLabelService.insert(logLabel);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param labelId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @ModelAttribute LogLabelModel logLabelModel,
			@RequestParam Integer labelId, Errors errors) {
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
		if (labelId == null) {
			message = "标签设置ID不能空";
			return ResultMessage.errorMsg(message);
		}

		LogLabel logLabel = logLabelService.getLogLabelById(labelId);
		if (logLabel == null) {
			message = "未找到该标签设置";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(logLabelModel, logLabel,
				logLabelModel.colset);

		logLabelService.update(logLabel);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param labelId
	 * @return
	 */
	@AuthPassport(rightCode = "logLabel_manage")
	@RequestMapping(value = "/logLabelDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer labelId) {

		if (labelId == null) {
			return ResultMessage.errorMsg("标签设置ID不能空");
		}

		LogLabel logLabel = logLabelService.getLogLabelById(labelId);
		if (logLabel == null) {
			return ResultMessage.errorMsg("未找到该标签设置");
		}

		// 判断状态
		logLabelService.delete(labelId);

		return ResultMessage.successMsg("删除成功");
	}

}
