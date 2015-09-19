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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.utils.MyBeanUtils;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.mgt.system.service.SysParamService;
import com.sxit.mgt.system.dto.SysParamModel;
import com.sxit.model.system.SysParams;


/**
 * @公司:深讯信科
 * @功能:系统参数 Action
 * @作者:张如兵    
 * @日期:2015-07-20 14:00:23  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class SysParamAction extends BaseAction {
	
	@Autowired
	private SysParamService sysParamService;


	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysParam")
	@RequestMapping(value = "/sysParamList")
	public @ResponseBody ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = sysParamService.getSysParamList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}

	/**
	 * 明细
	 * 
	 * @param paramsId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysParam")
	@RequestMapping(value = "/sysParamDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long paramsId) {
		String message = "";
		if (paramsId == null) {
			message = "系统参数ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysParams sysParam = sysParamService.getSysParamById(paramsId);
		if (sysParam == null) {
			message = "未找到该系统参数";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", sysParam);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysParam")
	@RequestMapping(value = "/sysParamAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody SysParamModel sysParamModel, Errors errors) {
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
		SysParams sysParam = new SysParams();
		BeanUtils.copyProperties(sysParamModel, sysParam);
		//sysParam.setCreateTime(new Date());
		//sysParam.setState(1);
		sysParamService.insert(sysParam);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param paramsId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysParam")
	@RequestMapping(value = "/sysParamEdit")
	public @ResponseBody
	ResultMessage edit(@Valid  @RequestBody SysParamModel sysParamModel, 
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
		
		Long paramsId = 	 sysParamModel.getParamsId();
		String message = "";
		if (paramsId == null) {
			message = "系统参数ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysParams sysParam = sysParamService.getSysParamById(paramsId); 
		if (sysParam == null) {
			message = "未找到该系统参数";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(sysParamModel, sysParam,sysParamModel.colset);
		//sysParam.setModifyTime(new Date());

	        sysParamService.update(sysParam);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param paramsId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysParam")
	@RequestMapping(value = "/sysParamDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long paramsId) {

		if (paramsId == null) {
			return ResultMessage.errorMsg("系统参数ID不能空");
		}

		SysParams sysParam = sysParamService.getSysParamById(paramsId); 
		if (sysParam == null) {
			return ResultMessage.errorMsg("未找到该系统参数");
		}

		//判断状态
		//if(sysParam.getState()==2)
		//{
			sysParamService.delete(paramsId);
		//}else{
			
		//	sysParamService.updateToDelete(paramsId);
		//}

		return ResultMessage.successMsg("删除成功");
	}

}
