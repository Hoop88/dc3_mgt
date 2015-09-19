package com.sxit.mgt.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.sxit.mgt.system.service.SysExportColumnService;
import com.sxit.mgt.system.dto.SysExportColumnModel;
import com.sxit.model.system.SysExportColumn;


/**
 * @公司:深讯信科
 * @功能:导出配置项 Action
 * @作者:张如兵    
 * @日期:2015-07-20 14:49:55  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class SysExportColumnAction extends BaseAction {
	
	@Autowired
	private SysExportColumnService sysExportColumnService;



	@AuthPassport(rightCode = "sysExportColumn_manage")
	@RequestMapping(value = "/sysExportColumnManage")
	public String manage() {
		return "system/sysExportColumn/manage";
	}
	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportColumnList")
	public @ResponseBody ResultMessage list(@RequestParam Integer exportId) {
		String message = "";
		if (exportId == null) {
			message = "导出配置ID不能空";
			return ResultMessage.errorMsg(message);
		}
		//列表查询
		List<SysExportColumn> list = sysExportColumnService.getExportColumnListByExportId(exportId);
		return ResultMessage.successMsg("success", list);
	}

	/**
	 * 明细
	 * 
	 * @param columnId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportColumnDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer columnId) {
		String message = "";
		if (columnId == null) {
			message = "导出配置项ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysExportColumn sysExportColumn = sysExportColumnService.getSysExportColumnById(columnId);
		if (sysExportColumn == null) {
			message = "未找到该导出配置项";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", sysExportColumn);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportColumnAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody SysExportColumnModel sysExportColumnModel, Errors errors) {
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
		SysExportColumn sysExportColumn = new SysExportColumn();
		BeanUtils.copyProperties(sysExportColumnModel, sysExportColumn);
		//sysExportColumn.setCreateTime(new Date());
		//sysExportColumn.setState(1);
		sysExportColumnService.insert(sysExportColumn);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param columnId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportColumnEdit")
	public @ResponseBody
	ResultMessage edit(@Valid  @RequestBody SysExportColumnModel sysExportColumnModel, 
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
		
		Integer columnId = 	 sysExportColumnModel.getColumnId();
		String message = "";
		if (columnId == null) {
			message = "导出配置项ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysExportColumn sysExportColumn = sysExportColumnService.getSysExportColumnById(columnId); 
		if (sysExportColumn == null) {
			message = "未找到该导出配置项";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(sysExportColumnModel, sysExportColumn,sysExportColumnModel.colset);
		//sysExportColumn.setModifyTime(new Date());

	        sysExportColumnService.update(sysExportColumn);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param columnId
	 * @return
	 */
	@AuthPassport(rightCode = "System.SysExport")
	@RequestMapping(value = "/sysExportColumnDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer columnId) {

		if (columnId == null) {
			return ResultMessage.errorMsg("导出配置项ID不能空");
		}

		SysExportColumn sysExportColumn = sysExportColumnService.getSysExportColumnById(columnId); 
		if (sysExportColumn == null) {
			return ResultMessage.errorMsg("未找到该导出配置项");
		}

		//判断状态
		//if(sysExportColumn.getState()==2)
		//{
			sysExportColumnService.delete(columnId);
		//}else{
			
		//	sysExportColumnService.updateToDelete(columnId);
		//}

		return ResultMessage.successMsg("删除成功");
	}

}
