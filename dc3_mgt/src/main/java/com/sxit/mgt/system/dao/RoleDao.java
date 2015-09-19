package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.IdVo;
import com.sxit.model.system.SysRole;

/**
 * @公司:深讯信科
 * @功能:角色 Dao
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:42  
 * @版本:1.0
 * @修改:
 */
 
public interface RoleDao {

        /**
	 *  新增角色
	 **/
	public int insert(SysRole role);
        /**
	 *  修改角色
	 **/
	public int update(SysRole role);
	
	/**
	 * 添加权限
	 * @param roleId
	 * @param addlist
	 */
	public void addPower(Map map);
	/**
	 * 删除权限
	 * @param roleId
	 * @param addlist
	 */
	public void deletePower(Map map);
	/**
	 *  批量新增角色
	 **/
	public void insertList(List<SysRole> list);
	/**
	 *  批量更新角色
	 **/
	public void updateList(List<SysRole> list);
	/**
	 *  是否存在角色
	 **/
	public int isHave(Integer roleId);

	/**
	 *  删除角色
	 **/
	public int delete(Integer roleId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer roleId);

	/**
	 *  已经存在角色列表
	 **/
	public List<SysRole> getHaveRoleList(List<SysRole> list);
	/**
	 *  分页列表角色列表
	 **/
	public Page<SysRole> getRoleList(Map map);

	/**
	 * 根据ID获取角色
	 */
	public SysRole getRoleById(Integer roleId);

	/**
	 *  根据角色获取功能Id
	 **/
	public List<IdVo> getFunctionIdList(Integer roleId);

}


