package com.sxit.mgt.caseManage.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.caseManage.dao.ProjectUserDao;
import com.sxit.model.caseManage.TcasProjectUser;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:项目用户 Service
 * @作者:张如兵    
 * @日期:2015-08-10 09:09:35  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class ProjectUserService {

	@Autowired
	private ProjectUserDao projectUserDao;

	/**
	 * 新增 项目用户
	 **/
	@Transactional
	public int insert(TcasProjectUser projectUser) {
		return projectUserDao.insert(projectUser);
	}

	/**
	 * 批量新增 项目用户
	 **/
	@Transactional
	public void insertList(List<TcasProjectUser> list) {
		if(list.size()>0)
		{
			projectUserDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 项目用户
	 **/
	@Transactional
	public void updateList(List<TcasProjectUser> list) {
		if(list.size()>0)
		{
		 projectUserDao.updateList(list);
		}
	}

	/**
	 * 修改 项目用户
	 **/
	@Transactional
	public int update(TcasProjectUser projectUser) {
		return projectUserDao.update(projectUser);
	}

	/**
	 * 是否存在 项目用户
	 **/
	public int isHave(Long id) {
		return projectUserDao.isHave(id);
	}

	/**
	 *  删除项目用户
	 **/
	@Transactional
	public int delete(Long id){
	       return projectUserDao.delete(id);
	}


	/**
	 *  标识删除项目用户
	 **/
	@Transactional
	public int updateToDelete(Long id){
	       return projectUserDao.updateToDelete(id);
	}

	/**
	 * 分页列表 项目用户
	 **/
	public Page<TcasProjectUser> getProjectUserList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return projectUserDao.getProjectUserList(map);
	}

	/**
	 * 已经存在的列表 项目用户
	 **/
	public List<TcasProjectUser> getHaveProjectUserList(List<TcasProjectUser> list) {
		return projectUserDao.getHaveProjectUserList(list);
	}

	/**
	 * 根据ID获取项目用户
	 */
	public TcasProjectUser getProjectUserById(Long id){
	       return projectUserDao.getProjectUserById(id);
	}

	/**
	 * ID Map 项目用户
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:projectUserDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


