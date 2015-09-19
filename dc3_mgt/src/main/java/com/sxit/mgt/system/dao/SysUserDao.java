package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;

import com.sxit.common.pagehelper.Page;
import com.sxit.model.common.CheckBoxVo;
import com.sxit.model.system.SysRole;
import com.sxit.model.system.SysUser;

/**
 * @公司:深讯信科
 * @功能:系统用户 Dao
 * @作者:张如兵    
 * @日期:2015-06-26 09:43:07  
 * @版本:1.0
 * @修改:
 */
 
public interface SysUserDao {

        /**
	 *  新增系统用户
	 **/
	public int insert(SysUser sysUser);
	
	/**
	 * 添加用户角色
	 * @param map
	 */
	public void addUserRole(Map map);
	
	/**
	 * 删除用户角色
	 * @param map
	 */
	public void deleteUserRole(Map map);
        /**
	 *  修改系统用户
	 **/
	public int update(SysUser sysUser);

	/**
	 *  是否存在系统用户
	 **/
	public int isHave(Integer userId);

	/**
	 *  删除系统用户
	 **/
	public int delete(Integer userId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer userId);

	/**
	 *  用户角色 候选
	 **/
	public List<SysRole> getRoleList();
	
	/**
	 *  用户角色 候选
	 **/
	public List<CheckBoxVo> getRoleCheckboxList();
	
	/**
	 *  分页列表系统用户列表
	 **/
	public Page<SysUser> getSysUserList(Map map);

	/**
	 * 根据ID获取系统用户
	 */
	public SysUser getSysUserById(Integer userId);

	/**
	 * 取用户的角色列表
	 * @param userId
	 * @return
	 */
	public List<SysRole> getRoleListByUserId(Integer userId);
	
	/**
	 * 取用户的角色ID列表
	 * @param userId
	 * @return
	 */
	public List<Integer> getRoleIdListByUserId(Integer userId);
	/**
	 *  系统用户ID列表
	 **/
	public List<String> getIdList();

}


