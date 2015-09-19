package com.sxit.mgt.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.sxit.common.utils.MyBeanUtils;

import com.sxit.common.pagehelper.JSONData;
import com.sxit.common.pagehelper.JSONMessage;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.system.dto.FunctionModel;
import com.sxit.mgt.system.service.FunctionService;
import com.sxit.model.system.SysFunction;


/**
 * @公司:深讯信科
 * @功能:系统功能 Action
 * @作者:张如兵    
 * @日期:2015-06-17 16:45:33  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class FunctionAction extends BaseAction {
	
	@Autowired
	private FunctionService functionService;



	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionManage")
	public String manage() {
		return "system/function/manage";
	}
	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionList")
	public @ResponseBody JSONMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = functionService.getFunctionList(pagevo, vo.getMap());

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
	 * @param functionId
	 * @return
	 */
	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer functionId) {
		String message = "";
		if (functionId == null) {
			message = "系统功能ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysFunction function = functionService.getFunctionById(functionId);
		if (function == null) {
			message = "未找到该系统功能";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", function);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionAdd")
	public @ResponseBody
	ResultMessage add(@Valid @ModelAttribute FunctionModel functionModel, Errors errors) {
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
		SysFunction function = new SysFunction();
		BeanUtils.copyProperties(functionModel, function);
		functionService.insert(function);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param functionId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @ModelAttribute FunctionModel functionModel, @RequestParam Integer functionId,
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

		String message = "";
		if (functionId == null) {
			message = "系统功能ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysFunction function = functionService.getFunctionById(functionId); 
		if (function == null) {
			message = "未找到该系统功能";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(functionModel, function,functionModel.colset);

	        functionService.update(function);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param functionId
	 * @return
	 */
	@AuthPassport(rightCode = "function_manage")
	@RequestMapping(value = "/functionDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer functionId) {

		if (functionId == null) {
			return ResultMessage.errorMsg("系统功能ID不能空");
		}

		SysFunction function = functionService.getFunctionById(functionId); 
		if (function == null) {
			return ResultMessage.errorMsg("未找到该系统功能");
		}

		//判断状态

			functionService.delete(functionId);


		return ResultMessage.successMsg("删除成功");
	}

}
