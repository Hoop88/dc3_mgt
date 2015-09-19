package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.caseManage.TcasTeam;

/**
 * @公司:深讯信科
 * @功能:项目团队 Dao
 * @作者:张如兵    
 * @日期:2015-07-30 14:23:53  
 * @版本:1.0
 * @修改:
 */
 
public interface TeamDao {

        /**
	 *  新增项目团队
	 **/
	public int insert(TcasTeam team);
        /**
	 *  修改项目团队
	 **/
	public int update(TcasTeam team);
	/**
	 *  批量新增项目团队
	 **/
	public void insertList(List<TcasTeam> list);
	/**
	 *  批量更新项目团队
	 **/
	public void updateList(List<TcasTeam> list);
	/**
	 *  是否存在项目团队
	 **/
	public int isHave(Long teamId);

	/**
	 *  删除项目团队
	 **/
	public int delete(Long teamId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long teamId);

	/**
	 *  已经存在项目团队列表
	 **/
	public List<TcasTeam> getHaveTeamList(List<TcasTeam> list);
	/**
	 *  分页列表项目团队列表
	 **/
	public Page<TcasTeam> getTeamList(Map map);

	/**
	 * 根据ID获取项目团队
	 */
	public TcasTeam getTeamById(Long teamId);

	/**
	 *  项目团队ID列表
	 **/
	public List<String> getIdList();

}


