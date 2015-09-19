package com.sxit.mgt.caseManage.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.caseManage.dao.CaseUserDao;
import com.sxit.model.caseManage.TcasUser;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:案场用户 Service
 * @作者:张如兵    
 * @日期:2015-08-05 14:00:18  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class CaseUserService {

	@Autowired
	private CaseUserDao caseUserDao;

	/**
	 * 新增 案场用户
	 **/
	@Transactional
	public int insert(TcasUser caseUser) {
		return caseUserDao.insert(caseUser);
	}

	/**
	 * 批量新增 案场用户
	 **/
	@Transactional
	public void insertList(List<TcasUser> list) {
		if(list.size()>0)
		{
			caseUserDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 案场用户
	 **/
	@Transactional
	public void updateList(List<TcasUser> list) {
		if(list.size()>0)
		{
		 caseUserDao.updateList(list);
		}
	}

	/**
	 * 修改 案场用户
	 **/
	@Transactional
	public int update(TcasUser caseUser) {
		return caseUserDao.update(caseUser);
	}

	/**
	 * 是否存在 案场用户
	 **/
	public int isHave(Long userId) {
		return caseUserDao.isHave(userId);
	}

	/**
	 *  删除案场用户
	 **/
	@Transactional
	public int delete(Long userId){
	       return caseUserDao.delete(userId);
	}


	/**
	 *  标识删除案场用户
	 **/
	@Transactional
	public int updateToDelete(Long userId){
	       return caseUserDao.updateToDelete(userId);
	}

	/**
	 * 分页列表 案场用户
	 **/
	public Page<TcasUser> getCaseUserList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return caseUserDao.getCaseUserList(map);
	}

	/**
	 * 已经存在的列表 案场用户
	 **/
	public List<TcasUser> getHaveCaseUserList(List<TcasUser> list) {
		return caseUserDao.getHaveCaseUserList(list);
	}

	/**
	 * 根据ID获取案场用户
	 */
	public TcasUser getCaseUserById(Long userId){
	       return caseUserDao.getCaseUserById(userId);
	}

	/**
	 * ID Map 案场用户
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:caseUserDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


