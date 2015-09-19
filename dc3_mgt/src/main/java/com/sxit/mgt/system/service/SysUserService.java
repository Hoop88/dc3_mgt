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
import com.sxit.mgt.system.dao.SysUserDao;
import com.sxit.model.common.CheckBoxVo;
import com.sxit.model.system.SysRole;
import com.sxit.model.system.SysUser;

/**
 * @公司:深讯信科
 * @功能:系统用户 Service
 * @作者:张如兵
 * @日期:2015-06-26 09:43:07
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 新增 系统用户
	 **/
	@Transactional
	public void insert(SysUser sysUser) {

		sysUserDao.insert(sysUser);

		List<Integer> addList = CheckBoxVo
				.getCheckedList(sysUser.getRoleList());

		if (addList != null && addList.size() > 0) {
			Map map = new HashMap();
			map.put("userId", sysUser.getUserId());
			map.put("list", addList);
			sysUserDao.addUserRole(map);
		}
	}

	/**
	 * 修改 系统用户
	 **/
	@Transactional
	public void update(SysUser sysUser) {

		sysUserDao.update(sysUser);

		List<Integer> oldList = sysUserDao.getRoleIdListByUserId(sysUser
				.getUserId());

		List<Integer> addList = CheckBoxVo.getAddList(oldList,
				sysUser.getRoleList());
		
		List<Integer> delList = CheckBoxVo.getDeleteList(oldList,
				sysUser.getRoleList());

		if (addList.size() > 0) {
			Map map = new HashMap();
			map.put("userId", sysUser.getUserId());
			map.put("list", addList);
			sysUserDao.addUserRole(map);
		}

		if (delList.size() > 0) {
			Map map = new HashMap();
			map.put("userId", sysUser.getUserId());
			map.put("list", delList);
			sysUserDao.deleteUserRole(map);
		}
	}

	/**
	 * 是否存在 系统用户
	 **/
	public int isHave(Integer userId) {
		return sysUserDao.isHave(userId);
	}

	/**
	 * 删除系统用户
	 **/
	@Transactional
	public int delete(Integer userId) {
		return sysUserDao.delete(userId);
	}

	/**
	 * 标识删除系统用户
	 **/
	@Transactional
	public int updateToDelete(Integer userId) {
		return sysUserDao.updateToDelete(userId);
	}

	/**
	 * 分页列表 系统用户
	 **/
	public Page<SysUser> getSysUserList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return sysUserDao.getSysUserList(map);
	}

	/**
	 * 角色
	 **/
	public List<SysRole> getRoleList() {
		return sysUserDao.getRoleList();
	}

	/**
	 * 角色checkbox列表
	 **/
	public List<CheckBoxVo> getRoleCheckboxList() {
		return sysUserDao.getRoleCheckboxList();
	}

	/**
	 * 根据ID获取系统用户
	 */
	public SysUser getSysUserById(Integer userId) {
		return sysUserDao.getSysUserById(userId);
	}

	/**
	 * 取用户的角色列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRole> getRoleListByUserId(Integer userId) {
		return sysUserDao.getRoleListByUserId(userId);
	}

	/**
	 * 取用户的角色ID列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> getRoleIdListByUserId(Integer userId) {
		return sysUserDao.getRoleIdListByUserId(userId);
	}

	/**
	 * ID Map 系统用户
	 **/
	public Map<String, String> getIdMap() {
		Map<String, String> map = new HashMap();
		for (String id : sysUserDao.getIdList()) {
			map.put(id, id);
		}
		return map;
	}

}
