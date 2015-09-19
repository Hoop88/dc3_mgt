package com.sxit.mgt.caseManage.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.caseManage.dao.TeamDao;
import com.sxit.model.caseManage.TcasTeam;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:项目团队 Service
 * @作者:张如兵    
 * @日期:2015-07-30 14:23:53  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class TeamService {

	@Autowired
	private TeamDao teamDao;

	/**
	 * 新增 项目团队
	 **/
	@Transactional
	public int insert(TcasTeam team) {
		return teamDao.insert(team);
	}

	/**
	 * 批量新增 项目团队
	 **/
	@Transactional
	public void insertList(List<TcasTeam> list) {
		if(list.size()>0)
		{
			teamDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 项目团队
	 **/
	@Transactional
	public void updateList(List<TcasTeam> list) {
		if(list.size()>0)
		{
		 teamDao.updateList(list);
		}
	}

	/**
	 * 修改 项目团队
	 **/
	@Transactional
	public int update(TcasTeam team) {
		return teamDao.update(team);
	}

	/**
	 * 是否存在 项目团队
	 **/
	public int isHave(Long teamId) {
		return teamDao.isHave(teamId);
	}

	/**
	 *  删除项目团队
	 **/
	@Transactional
	public int delete(Long teamId){
	       return teamDao.delete(teamId);
	}


	/**
	 *  标识删除项目团队
	 **/
	@Transactional
	public int updateToDelete(Long teamId){
	       return teamDao.updateToDelete(teamId);
	}

	/**
	 * 分页列表 项目团队
	 **/
	public Page<TcasTeam> getTeamList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return teamDao.getTeamList(map);
	}

	/**
	 * 已经存在的列表 项目团队
	 **/
	public List<TcasTeam> getHaveTeamList(List<TcasTeam> list) {
		return teamDao.getHaveTeamList(list);
	}

	/**
	 * 根据ID获取项目团队
	 */
	public TcasTeam getTeamById(Long teamId){
	       return teamDao.getTeamById(teamId);
	}

	/**
	 * ID Map 项目团队
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:teamDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


