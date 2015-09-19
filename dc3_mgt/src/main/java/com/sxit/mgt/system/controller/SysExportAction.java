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
import com.sxit.common.memery.ExportMap;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.mgt.system.service.SysExportService;
import com.sxit.mgt.system.dto.SysExportModel;
import com.sxit.model.system.SysExport;


/**
 * @公司:深讯信科
 * @功能:导出配置 Action
 * @作者:张如兵    
 * @日期:2015-07-20 14:45:36  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class SysExportAction extends BaseAction {
	
	@Autowired
	private SysExportService sysExportService;



	@AuthPassport(rightCode = "sysExport_manage")
	@RequestMapping(value = "/sysExportManage")
	public String manage() {
		return "system/sysExport/manage";
	}
	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportList")
	public @ResponseBody ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = sysExportService.getSysExportList(pagevo, vo.getMap());
		
		
		return ResultMessage.successPage(page);
	}

	/**
	 * 明细
	 * 
	 * @param exportId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer exportId) {
		String message = "";
		if (exportId == null) {
			message = "导出配置ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysExport sysExport = sysExportService.getSysExportById(exportId);
		if (sysExport == null) {
			message = "未找到该导出配置";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", sysExport);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody SysExportModel sysExportModel, Errors errors) {
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
		SysExport sysExport = new SysExport();
		BeanUtils.copyProperties(sysExportModel, sysExport);
		//sysExport.setCreateTime(new Date());
		//sysExport.setState(1);
		sysExportService.insert(sysExport);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param exportId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportEdit")
	public @ResponseBody
	ResultMessage edit(@Valid  @RequestBody SysExportModel sysExportModel, 
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
		
		Integer exportId = 	 sysExportModel.getExportId();
		String message = "";
		if (exportId == null) {
			message = "导出配置ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysExport sysExport = sysExportService.getSysExportById(exportId); 
		if (sysExport == null) {
			message = "未找到该导出配置";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(sysExportModel, sysExport,sysExportModel.colset);
		//sysExport.setModifyTime(new Date());

	        sysExportService.update(sysExport);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param exportId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer exportId) {

		if (exportId == null) {
			return ResultMessage.errorMsg("导出配置ID不能空");
		}

		SysExport sysExport = sysExportService.getSysExportById(exportId); 
		if (sysExport == null) {
			return ResultMessage.errorMsg("未找到该导出配置");
		}

		//判断状态
		//if(sysExport.getState()==2)
		//{
			sysExportService.delete(exportId);
		//}else{
			
		//	sysExportService.updateToDelete(exportId);
		//}

		return ResultMessage.successMsg("删除成功");
	}

}
