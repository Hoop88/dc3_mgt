package com.sxit.mgt.auth.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.security.MD5;
import com.sxit.mgt.auth.dao.LoginDao;
import com.sxit.mgt.auth.vo.EMenu;
import com.sxit.mgt.auth.vo.EMenuMap;
import com.sxit.model.system.SysFunction;
import com.sxit.model.system.SysMenu;
import com.sxit.model.system.SysUser;

/**
 * @公司:深讯信科
 * @功能:登录 Service
 * @作者:张如兵
 * @日期:2015-03-02 15:50:48
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class LoginService {
	protected Logger log = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private LoginDao loginDao;

	/**
	 * 根据ID获取登录
	 */
	public SysUser login(String userName, String password) {

		String pass = MD5.md5(password);
		//log.info(pass);
		Map map = new HashMap();
		map.put("userName", userName);
		map.put("password", pass);
		return loginDao.login(map);
	}

	/**
	 * 根据角色获取权限
	 * 
	 * @param roleId
	 * @return
	 */
	public Set getRightSet(Integer userId) {

		List<String> list = loginDao.getRightSetByUser(userId);

		Set<String> rightset = new HashSet();

		for (String code : list) {
			rightset.add(code.toLowerCase().trim());
		}
		return rightset;
	}

	/**
	 * 获取系统管理员权限
	 * 
	 * @return
	 */
	public Set getSysRightSet() {
		List<String> list = loginDao.getRightSetAll();

		Set<String> rightset = new HashSet();

		for (String code : list) {
			rightset.add(code.toLowerCase().trim());
		}
		return rightset;
	}

	/**
	 * 获取用户权限
	 * 
	 * @return
	 */
	public Set getSysRightSetByUser(Integer userId) {
		List<String> list = loginDao.getRightSetByUser(userId);

		Set<String> rightset = new HashSet();

		for (String code : list) {
			rightset.add(code.toLowerCase().trim());
		}
		return rightset;
	}

	/**
	 * 获取管理员的菜单
	 * @return
	 */
	public List<EMenu> getEMenuAll() {
		EMenuMap map = new EMenuMap();
		List<SysMenu> list = loginDao.getMenuAll();
		List<EMenu> menuList = new ArrayList();
		for (SysMenu menu : list) {
			if (menu.getMenuLevel() == 1) {
				EMenu emenu = new EMenu(menu);
				List<EMenu> childMenus = this.getChild1(menu.getMenuId(), list);
				emenu.setMenuItems(childMenus);
				menuList.add(emenu);
			}
		}
		return menuList;
	}
	
	/**
	 * 获取用户的菜单
	 * @param userId
	 * @return
	 */
	public List<EMenu> getEMenuUser(Integer userId) {
		EMenuMap map = new EMenuMap();
		List<SysMenu> list = loginDao.getMenuByUser(userId);
		List<EMenu> menuList = new ArrayList();
		for (SysMenu menu : list) {
			if (menu.getMenuLevel() == 1) {
				EMenu emenu = new EMenu(menu);
				List<EMenu> childMenus = this.getChild1(menu.getMenuId(), list);
				emenu.setMenuItems(childMenus);
				menuList.add(emenu);
			}
		}
		return menuList;
	}

	/**
	 * 取一级菜单的子
	 * @param menuId
	 * @param list
	 * @return
	 */
	private List<EMenu> getChild1(Integer menuId, List<SysMenu> list) {
		List<EMenu> c_list = new ArrayList();
		for (SysMenu menu : list) {
			if (menuId.equals(menu.getParentId())) {
				EMenu emenu = new EMenu(menu);
				List<EMenu> childMenus = this.getChild2(menu.getMenuId(), list);
				emenu.setMenuItems(childMenus);
				c_list.add(emenu);
			}
		}
		return c_list;
	}
	
	/**
	 * 取二级菜单的子
	 * @param menuId
	 * @param list
	 * @return
	 */
	private List<EMenu> getChild2(Integer menuId, List<SysMenu> list) {
		List<EMenu> c_list = new ArrayList();
		for (SysMenu menu : list) {
			if (menuId.equals(menu.getParentId())) {
				c_list.add(new EMenu(menu));
			}
		}
		return c_list;
	}
}
