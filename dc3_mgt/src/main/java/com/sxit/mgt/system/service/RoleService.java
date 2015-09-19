package com.sxit.mgt.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.system.dao.RoleDao;
import com.sxit.model.system.IdVo;
import com.sxit.model.system.SysRole;

/**
 * @公司:深讯信科
 * @功能:角色 Service
 * @作者:张如兵
 * @日期:2015-06-17 16:47:42
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	/**
	 * 新增 角色
	 **/
	@Transactional
	public int insert(SysRole role) {
		return roleDao.insert(role);
	}

	/**
	 * 批量新增 角色
	 **/
	@Transactional
	public void insertList(List<SysRole> list) {
		if (list.size() > 0) {
			roleDao.insertList(list);
		}

	}

	/**
	 * 批量修改 角色
	 **/
	@Transactional
	public void updateList(List<SysRole> list) {
		if (list.size() > 0) {
			roleDao.updateList(list);
		}
	}

	/**
	 * 添加权限
	 * 
	 * @param role
	 * @param addlist
	 */
	@Transactional
	public void addPower(Integer roleId, List<IdVo> addlist) {
		if (addlist.size() > 0) {
			Map map = new HashMap();
			map.put("roleId", roleId);
			map.put("list", addlist);
			roleDao.addPower(map);
		}
	}

	/**
	 * 删除权限
	 * 
	 * @param roleId
	 * @param addlist
	 */
	@Transactional
	public void deletePower(Integer roleId, List<IdVo> addlist) {
		if (addlist.size() > 0) {
			Map map = new HashMap();
			map.put("roleId", roleId);
			map.put("list", addlist);
			roleDao.deletePower(map);
		}
	}

	/**
	 * 修改 角色
	 **/
	@Transactional
	public int update(SysRole role) {
		return roleDao.update(role);
	}

	/**
	 * 是否存在 角色
	 **/
	public int isHave(Integer roleId) {
		return roleDao.isHave(roleId);
	}

	/**
	 * 删除角色
	 **/
	@Transactional
	public int delete(Integer roleId) {
		return roleDao.delete(roleId);
	}

	/**
	 * 标识删除角色
	 **/
	@Transactional
	public int updateToDelete(Integer roleId) {
		return roleDao.updateToDelete(roleId);
	}

	/**
	 * 分页列表 角色
	 **/
	public Page<SysRole> getRoleList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return roleDao.getRoleList(map);
	}

	/**
	 * 已经存在的列表 角色
	 **/
	public List<SysRole> getHaveRoleList(List<SysRole> list) {
		return roleDao.getHaveRoleList(list);
	}

	/**
	 * 根据ID获取角色
	 */
	public SysRole getRoleById(Integer roleId) {
		return roleDao.getRoleById(roleId);
	}

	/**
	 * 根据角色获取功能Id
	 **/
	public List<IdVo> getFunctionIdList(Integer roleId) {
		return roleDao.getFunctionIdList(roleId);
	}

}
