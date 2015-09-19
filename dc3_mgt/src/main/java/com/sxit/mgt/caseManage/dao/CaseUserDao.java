package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.caseManage.TcasUser;

/**
 * @公司:深讯信科
 * @功能:案场用户 Dao
 * @作者:张如兵    
 * @日期:2015-08-05 14:00:18  
 * @版本:1.0
 * @修改:
 */
 
public interface CaseUserDao {

        /**
	 *  新增案场用户
	 **/
	public int insert(TcasUser caseUser);
        /**
	 *  修改案场用户
	 **/
	public int update(TcasUser caseUser);
	/**
	 *  批量新增案场用户
	 **/
	public void insertList(List<TcasUser> list);
	/**
	 *  批量更新案场用户
	 **/
	public void updateList(List<TcasUser> list);
	/**
	 *  是否存在案场用户
	 **/
	public int isHave(Long userId);

	/**
	 *  删除案场用户
	 **/
	public int delete(Long userId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long userId);

	/**
	 *  已经存在案场用户列表
	 **/
	public List<TcasUser> getHaveCaseUserList(List<TcasUser> list);
	/**
	 *  分页列表案场用户列表
	 **/
	public Page<TcasUser> getCaseUserList(Map map);

	/**
	 * 根据ID获取案场用户
	 */
	public TcasUser getCaseUserById(Long userId);

	/**
	 *  案场用户ID列表
	 **/
	public List<String> getIdList();

}


