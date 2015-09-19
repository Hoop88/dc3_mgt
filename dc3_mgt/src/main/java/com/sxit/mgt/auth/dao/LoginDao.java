package com.sxit.mgt.auth.dao;

import java.util.List;
import java.util.Map;

import com.sxit.model.system.SysMenu;
import com.sxit.model.system.SysUser;

/**
 * @公司:深讯信科
 * @功能:登录 Dao
 * @作者:张如兵
 * @日期:2015-03-02 15:50:48
 * @版本:1.0
 * @修改:
 */

public interface LoginDao {

	/**
	 * 新增登录
	 **/
	public SysUser login(Map map);

	/**
	 *  权限列表(所有)
	 **/
	public List<String> getRightSetAll();
	
	/**
	 *  权限列表(个人)
	 **/
	public List<String> getRightSetByUser(Integer userId);
	
	/**
	 *  权限列表(所有)
	 **/
	public List<SysMenu> getMenuAll();
	
	/**
	 *  权限列表(个人)
	 **/
	public List<SysMenu> getMenuByUser(Integer userId);
	
	
}
