package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.caseManage.TcasProjectUser;

/**
 * @公司:深讯信科
 * @功能:项目用户 Dao
 * @作者:张如兵    
 * @日期:2015-08-10 09:09:35  
 * @版本:1.0
 * @修改:
 */
 
public interface ProjectUserDao {

        /**
	 *  新增项目用户
	 **/
	public int insert(TcasProjectUser projectUser);
        /**
	 *  修改项目用户
	 **/
	public int update(TcasProjectUser projectUser);
	/**
	 *  批量新增项目用户
	 **/
	public void insertList(List<TcasProjectUser> list);
	/**
	 *  批量更新项目用户
	 **/
	public void updateList(List<TcasProjectUser> list);
	/**
	 *  是否存在项目用户
	 **/
	public int isHave(Long id);

	/**
	 *  删除项目用户
	 **/
	public int delete(Long id);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long id);

	/**
	 *  已经存在项目用户列表
	 **/
	public List<TcasProjectUser> getHaveProjectUserList(List<TcasProjectUser> list);
	/**
	 *  分页列表项目用户列表
	 **/
	public Page<TcasProjectUser> getProjectUserList(Map map);

	/**
	 * 根据ID获取项目用户
	 */
	public TcasProjectUser getProjectUserById(Long id);

	/**
	 *  项目用户ID列表
	 **/
	public List<String> getIdList();

}


