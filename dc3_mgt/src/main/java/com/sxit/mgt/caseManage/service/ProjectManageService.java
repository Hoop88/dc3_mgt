package com.sxit.mgt.caseManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.caseManage.dao.ProjectManageDao;
import com.sxit.mgt.caseManage.dto.CheckCompanyVo;
import com.sxit.model.caseManage.TcasProject;

/**
 * @公司:深讯信科
 * @功能:项目管理 Service
 * @作者:张如兵
 * @日期:2015-07-24 11:32:23
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class ProjectManageService {

	@Autowired
	private ProjectManageDao projectManageDao;

	/**
	 * 新增 项目管理
	 **/
	@Transactional
	public int insert(TcasProject projectManage) {
		return projectManageDao.insert(projectManage);
	}

	/**
	 * 批量新增 项目管理
	 **/
	@Transactional
	public void insertList(List<TcasProject> list) {
		if (list.size() > 0) {
			projectManageDao.insertList(list);
		}

	}

	/**
	 * 批量修改 项目管理
	 **/
	@Transactional
	public void updateList(List<TcasProject> list) {
		if (list.size() > 0) {
			projectManageDao.updateList(list);
		}
	}

	/**
	 * 修改 项目管理
	 **/
	@Transactional
	public int update(TcasProject projectManage) {
		
		int res = projectManageDao.update(projectManage);
		
		
		//获取代理公司配置
		List<CheckCompanyVo> list =	projectManage.getProxyCompanyList();
		
		//获取勾选的代理公司
		List<CheckCompanyVo> checklist = CheckCompanyVo.getCheckedList(list);
		
		//删除之前的代理公司
		projectManageDao.deleteCompanyList(projectManage.getProjectId());
		
		//添加新的代理公司
		java.util.Map map = new HashMap();
		
		map.put("projectId", projectManage.getProjectId());
		map.put("list", checklist);
		if(checklist!=null && checklist.size()>0)
		{
			projectManageDao.addCompanyList(map);
		}
		return res;
	}

	/**
	 * 是否存在 项目管理
	 **/
	public int isHave(Long projectId) {
		return projectManageDao.isHave(projectId);
	}

	/**
	 * 删除项目管理
	 **/
	@Transactional
	public int delete(Long projectId) {
		return projectManageDao.delete(projectId);
	}

	/**
	 * 标识删除项目管理
	 **/
	@Transactional
	public int updateToDelete(Long projectId) {
		return projectManageDao.updateToDelete(projectId);
	}

	/**
	 * 分页列表 项目管理
	 **/
	public Page<TcasProject> getProjectManageList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return projectManageDao.getProjectManageList(map);
	}

	/**
	 * 关联查询分页
	 * @param page
	 * @param map
	 * @return
	 */
	public Page<TcasProject> getProjectTreeList(PageVo page, Map map) {
		Page<TcasProject> pageList = new Page<TcasProject>(page.getPage(),
				page.getPageSize());

		map.put("startRecord", page.getStartRecord());
		map.put("pageSize", page.getPageSize());

		int total = projectManageDao.getProjectTreeCount(map);

		pageList.setTotal((long) total);
		List<TcasProject> list = projectManageDao.getProjectTreeList(map);
		pageList.addAll(list);

		return pageList;
	}

	/**
	 * 已经存在的列表 项目管理
	 **/
	public List<TcasProject> getHaveProjectManageList(List<TcasProject> list) {
		return projectManageDao.getHaveProjectManageList(list);
	}

	/**
	 * 根据ID获取项目管理
	 */
	public TcasProject getProjectManageById(Long projectId) {
		return projectManageDao.getProjectManageById(projectId);
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 */
	public List<CheckCompanyVo> getCheckCompanyList(TcasProject project) {
		List<CheckCompanyVo> all = projectManageDao.getCheckAllCompanyProject(project.getParentCode());
		List<CheckCompanyVo> checked = projectManageDao.getCheckedCompanyProject(project.getProjectId());
		for(CheckCompanyVo ccv1:all)
		{
			for(CheckCompanyVo ccv2:checked)
			{
				if(ccv1.getId().longValue()==ccv2.getId().longValue())
				{
					ccv1.setChecked(true);
					ccv1.setCode(ccv2.getCode());
				}
			}
		}
		return all;
	}
	

	/**
	 * 一级项目
	 **/
	public Map<String, String> getProjectCode1MapList() {
		Map<String, String> map = new HashMap();
		for (TcasProject p : projectManageDao.getProjectCode1MapList()) {
			map.put(p.getProjectCode(),p.getProjectName());
		}
		return map;
	}
	
	/**
	 * 所有项目
	 **/
	public Map<String, String> getProjectCodeMapList() {
		Map<String, String> map = new HashMap();
		for (TcasProject p : projectManageDao.getProjectCodeMapList()) {
			map.put(p.getProjectCode(),p.getProjectName());
		}
		return map;
	}

}
