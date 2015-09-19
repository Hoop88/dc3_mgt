package com.sxit.mgt.auth.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sxit.model.system.SysMenu;

/**
 * 企业菜单
 * 
 * @author agu
 * 
 */
public class EMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 菜单ID.
	 */
	private Integer menuId;
	/**
	 * 菜单名称.
	 */
	private String menuName;
	/**
	 * 菜单css.
	 */
	private String className;
	/**
	 * 功能编号.
	 */
	private String navigation;
	/**
	 * 执行路径.
	 */
	private String href;
	
	/**
	 * 父ID
	 */
	private Integer parentId;
	/**
	 * 目标区域.
	 */
	private String openTarget;

	private List<EMenu> menuItems = new ArrayList(0);

	public EMenu() {
		super();
		// Auto-generated constructor stub
	}

	public EMenu(SysMenu menu) {
		super();
		// Auto-generated constructor stub
		this.menuId = menu.getMenuId();
		this.menuName = menu.getMenuName();
		this.className = menu.getMenuClass();
		this.href = menu.getAction();
		this.navigation = menu.getNavigation();
		this.parentId = menu.getParentId();
	}


	public EMenu(Integer menuId, String menuName, String className,
			String navigation, String href, Integer parentId, String openTarget,
			List<EMenu> menuItems) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.className = className;
		this.navigation = navigation;
		this.href = href;
		this.parentId = parentId;
		this.openTarget = openTarget;
		this.menuItems = menuItems;
	}

	public EMenu(Integer menuId, String menuName, String href,
			String openTarget) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.href = href;
		this.openTarget = openTarget;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public void addChildMenus(EMenu menu) {
		this.menuItems.add(menu);
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<EMenu> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<EMenu> menuItems) {
		this.menuItems = menuItems;
	}

}
