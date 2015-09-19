package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysMenu;

/**
 * @公司:深讯信科
 * @功能:系统菜单 Dao
 * @作者:张如兵    
 * @日期:2015-06-17 16:46:49  
 * @版本:1.0
 * @修改:
 */
 
public interface MenuDao {

        /**
	 *  新增系统菜单
	 **/
	public int insert(SysMenu menu);
        /**
	 *  修改系统菜单
	 **/
	public int update(SysMenu menu);
	/**
	 *  批量新增系统菜单
	 **/
	public void insertList(List<SysMenu> list);
	/**
	 *  批量更新系统菜单
	 **/
	public void updateList(List<SysMenu> list);
	/**
	 *  是否存在系统菜单
	 **/
	public int isHave(Integer menuId);

	/**
	 *  删除系统菜单
	 **/
	public int delete(Integer menuId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer menuId);

	/**
	 *  已经存在系统菜单列表
	 **/
	public List<SysMenu> getHaveMenuList(List<SysMenu> list);
	/**
	 *  分页列表系统菜单列表
	 **/
	public Page<SysMenu> getMenuList(Map map);

	/**
	 * 根据ID获取系统菜单
	 */
	public SysMenu getMenuById(Integer menuId);

	/**
	 *  系统菜单ID列表
	 **/
	public List<String> getIdList();

}


