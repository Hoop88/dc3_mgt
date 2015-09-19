package com.sxit.mgt.system.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.system.dao.MenuDao;
import com.sxit.model.system.SysMenu;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:系统菜单 Service
 * @作者:张如兵    
 * @日期:2015-06-17 16:46:49  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	/**
	 * 新增 系统菜单
	 **/
	@Transactional
	public int insert(SysMenu menu) {
		return menuDao.insert(menu);
	}

	/**
	 * 批量新增 系统菜单
	 **/
	@Transactional
	public void insertList(List<SysMenu> list) {
		if(list.size()>0)
		{
			menuDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 系统菜单
	 **/
	@Transactional
	public void updateList(List<SysMenu> list) {
		if(list.size()>0)
		{
		 menuDao.updateList(list);
		}
	}

	/**
	 * 修改 系统菜单
	 **/
	@Transactional
	public int update(SysMenu menu) {
		return menuDao.update(menu);
	}

	/**
	 * 是否存在 系统菜单
	 **/
	public int isHave(Integer menuId) {
		return menuDao.isHave(menuId);
	}

	/**
	 *  删除系统菜单
	 **/
	@Transactional
	public int delete(Integer menuId){
	       return menuDao.delete(menuId);
	}


	/**
	 *  标识删除系统菜单
	 **/
	@Transactional
	public int updateToDelete(Integer menuId){
	       return menuDao.updateToDelete(menuId);
	}

	/**
	 * 分页列表 系统菜单
	 **/
	public Page<SysMenu> getMenuList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return menuDao.getMenuList(map);
	}

	/**
	 * 已经存在的列表 系统菜单
	 **/
	public List<SysMenu> getHaveMenuList(List<SysMenu> list) {
		return menuDao.getHaveMenuList(list);
	}

	/**
	 * 根据ID获取系统菜单
	 */
	public SysMenu getMenuById(Integer menuId){
	       return menuDao.getMenuById(menuId);
	}

	/**
	 * ID Map 系统菜单
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:menuDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


