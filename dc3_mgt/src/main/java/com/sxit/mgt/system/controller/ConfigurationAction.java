package com.sxit.mgt.system.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.mgt.auth.vo.EMenu;
import com.sxit.mgt.auth.vo.EMenuMap;

@Controller
@RequestMapping("")
public class ConfigurationAction extends BaseAction {

	/**
	 * 跳转到第一个有权限的子菜单
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/configuration")
	public String manage() {
		
		EMenuMap menuMap =(EMenuMap) this.get("menuMap");
		
		if(menuMap==null)
		{
			return "auth/nopower";
		}
		
		HashMap<String, EMenu> map1 = menuMap.getLevel1MenuMap();
		
		EMenu memu = map1.get("108"); // 一级菜单 - 配置管理
		
		if(memu==null)
		{
			return "auth/nopower";
		}
		
		List<EMenu>list = memu.getMenuItems();
		
		if(list==null)
		{
			return "auth/nopower";
		}
		
		if(list.size()==0)
		{
			return "auth/nopower";
		}
		
		EMenu to_menu = list.get(0);
		
        return "redirect:" + to_menu.getHref();
	}
	
	/**
	 * 跳转到第一个有权限的子菜单
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/system/userMgt")
	public String userMgt() {
		
		EMenuMap menuMap =(EMenuMap) this.get("menuMap");
		
		if(menuMap==null)
		{
			return "auth/nopower";
		}
		
		HashMap<String, EMenu> map2 = menuMap.getLevel2MenuMap();
		
		EMenu memu = map2.get("10801"); // 二级菜单 - 用户管理
		
		if(memu==null)
		{
			return "auth/nopower";
		}
		
		List<EMenu>list = memu.getMenuItems();
		
		if(list==null)
		{
			return "auth/nopower";
		}
		
		EMenu to_menu = list.get(0);
		
        return "redirect:" + to_menu.getHref();
	}
	
}
