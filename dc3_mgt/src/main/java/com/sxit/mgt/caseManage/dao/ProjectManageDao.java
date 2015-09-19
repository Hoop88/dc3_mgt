package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.mgt.caseManage.dto.CheckCompanyVo;
import com.sxit.model.caseManage.TcasProject;

/**
 * @公司:深讯信科
 * @功能:项目管理 Dao
 * @作者:张如兵    
 * @日期:2015-07-24 11:32:23  
 * @版本:1.0
 * @修改:
 */
 
public interface ProjectManageDao {

        /**
	 *  新增项目管理
	 **/
	public int insert(TcasProject projectManage);
        /**
	 *  修改项目管理
	 **/
	public int update(TcasProject projectManage);
	/**
	 *  批量新增项目管理
	 **/
	public void insertList(List<TcasProject> list);
	/**
	 *  批量更新项目管理
	 **/
	public void updateList(List<TcasProject> list);
	/**
	 *  是否存在项目管理
	 **/
	public int isHave(Long projectId);

	/**
	 *  删除项目管理
	 **/
	public int delete(Long projectId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long projectId);

	/**
	 *  已经存在项目管理列表
	 **/
	public List<TcasProject> getHaveProjectManageList(List<TcasProject> list);
	/**
	 *  分页列表项目管理列表
	 **/
	public Page<TcasProject> getProjectManageList(Map map);
	
	/**
	 * 关联查询一级项目二级项目
	 * @param map
	 * @return
	 */
	public List<TcasProject> getProjectTreeList(Map map);
	
	/**
	 * 关联查询分页count
	 * @param map
	 * @return
	 */
	public int getProjectTreeCount(Map map);
	
	
	/**
	 * 根据ID获取项目管理
	 */
	public TcasProject getProjectManageById(Long projectId);
	

	/**
	 *  一级项目map
	 **/
	public List<TcasProject> getProjectCode1MapList();
	
	/**
	 * 所有项目map
	 * @return
	 */
	public List<TcasProject> getProjectCodeMapList();
	
	/**
	 * 
	 * @param ProjectCode
	 * @return
	 */
	public List<CheckCompanyVo> getCheckAllCompanyProject(String ProjectCode);
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public List<CheckCompanyVo> getCheckedCompanyProject(Long projectId);
	
	
	/**
	 * 删除项目的代理公司
	 * @param projectId
	 * @return
	 */
	public int deleteCompanyList(Long projectId);
	
	/**
	 * 添加项目的代理公司
	 * @param list
	 * @return
	 */
	public int addCompanyList(java.util.Map map);

}


