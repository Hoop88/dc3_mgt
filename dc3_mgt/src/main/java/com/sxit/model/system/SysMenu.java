package com.sxit.model.system;

import java.util.Date;
/**
 * @公司:深讯信科
 * @功能:菜单 Model
 * @作者:张如兵    
 * @日期:2015-06-17 20:08:05  
 * @版本:1.0
 * @修改:
 */
 
public class SysMenu {

  	/**
	 *菜单ID 
	 */
	private Integer menuId; 
	/**
	 *功能ID 
	 */
	private Integer functionId; 
	/**
	 *菜单名称 
	 */
	private String menuName; 
	/**
	 *导航信息 
	 */
	private String navigation; 
	/**
	 *菜单地址 
	 */
	private String action; 
	/**
	 *菜单层级 
	 */
	private Integer menuLevel; 
	/**
	 *菜单样式 
	 */
	private String menuClass; 
	/**
	 *顶层隐藏菜单 
	 */
	private Integer topMenu; 
	/**
	 *导航栏菜单 
	 */
	private Integer barMenu; 
	/**
	 *父菜单 
	 */
	private Integer parentId; 
	/**
	 *排序 
	 */
	private Integer sort; 
	
	public SysMenu() { 
	  super();
	}
	
	/**
	 * 获取菜单ID 
	 */
	public Integer getMenuId() {
		return menuId;
	}
	
	/**
	 * 设置菜单ID 
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	/**
	 * 获取功能ID 
	 */
	public Integer getFunctionId() {
		return functionId;
	}
	
	/**
	 * 设置功能ID 
	 */
	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}
	
	/**
	 * 获取菜单名称 
	 */
	public String getMenuName() {
		return menuName;
	}
	
	/**
	 * 设置菜单名称 
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	/**
	 * 获取导航信息 
	 */
	public String getNavigation() {
		return navigation;
	}
	
	/**
	 * 设置导航信息 
	 */
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
	/**
	 * 获取菜单地址 
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * 设置菜单地址 
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * 获取菜单层级 
	 */
	public Integer getMenuLevel() {
		return menuLevel;
	}
	
	/**
	 * 设置菜单层级 
	 */
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	
	/**
	 * 获取菜单样式 
	 */
	public String getMenuClass() {
		return menuClass;
	}
	
	/**
	 * 设置菜单样式 
	 */
	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}
	
	/**
	 * 获取顶层隐藏菜单 
	 */
	public Integer getTopMenu() {
		return topMenu;
	}
	
	/**
	 * 设置顶层隐藏菜单 
	 */
	public void setTopMenu(Integer topMenu) {
		this.topMenu = topMenu;
	}
	
	/**
	 * 获取导航栏菜单 
	 */
	public Integer getBarMenu() {
		return barMenu;
	}
	
	/**
	 * 设置导航栏菜单 
	 */
	public void setBarMenu(Integer barMenu) {
		this.barMenu = barMenu;
	}
	
	/**
	 * 获取父菜单 
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置父菜单 
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取排序 
	 */
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置排序 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		   SysMenu other = (SysMenu) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.getMenuId()))
		    return false;
	    return true;
	}
	


}
