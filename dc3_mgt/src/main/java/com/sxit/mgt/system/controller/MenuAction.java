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
import com.sxit.mgt.system.dto.MenuModel;
import com.sxit.mgt.system.service.MenuService;
import com.sxit.model.system.SysMenu;


/**
 * @公司:深讯信科
 * @功能:系统菜单 Action
 * @作者:张如兵    
 * @日期:2015-06-17 16:46:49  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class MenuAction extends BaseAction {
	
	@Autowired
	private MenuService menuService;



	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuManage")
	public String manage() {
		return "system/menu/manage";
	}
	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuList")
	public @ResponseBody JSONMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = menuService.getMenuList(pagevo, vo.getMap());

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
	 * @param menuId
	 * @return
	 */
	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer menuId) {
		String message = "";
		if (menuId == null) {
			message = "系统菜单ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysMenu menu = menuService.getMenuById(menuId);
		if (menu == null) {
			message = "未找到该系统菜单";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", menu);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuAdd")
	public @ResponseBody
	ResultMessage add(@Valid @ModelAttribute MenuModel menuModel, Errors errors) {
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
		SysMenu menu = new SysMenu();
		BeanUtils.copyProperties(menuModel, menu);
		menuService.insert(menu);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param menuId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @ModelAttribute MenuModel menuModel, @RequestParam Integer menuId,
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
		if (menuId == null) {
			message = "系统菜单ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysMenu menu = menuService.getMenuById(menuId); 
		if (menu == null) {
			message = "未找到该系统菜单";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(menuModel, menu,menuModel.colset);


	        menuService.update(menu);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param menuId
	 * @return
	 */
	@AuthPassport(rightCode = "menu_manage")
	@RequestMapping(value = "/menuDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer menuId) {

		if (menuId == null) {
			return ResultMessage.errorMsg("系统菜单ID不能空");
		}

		SysMenu menu = menuService.getMenuById(menuId); 
		if (menu == null) {
			return ResultMessage.errorMsg("未找到该系统菜单");
		}


			menuService.delete(menuId);
	

		return ResultMessage.successMsg("删除成功");
	}

}
