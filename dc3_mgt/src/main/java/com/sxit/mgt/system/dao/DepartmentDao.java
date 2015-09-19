package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysDepartment;

/**
 * @公司:深讯信科
 * @功能:部门 Dao
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:22  
 * @版本:1.0
 * @修改:
 */
 
public interface DepartmentDao {

        /**
	 *  新增部门
	 **/
	public int insert(SysDepartment department);
        /**
	 *  修改部门
	 **/
	public int update(SysDepartment department);
	/**
	 *  批量新增部门
	 **/
	public void insertList(List<SysDepartment> list);
	/**
	 *  批量更新部门
	 **/
	public void updateList(List<SysDepartment> list);
	/**
	 *  是否存在部门
	 **/
	public int isHave(Integer depId);

	/**
	 *  删除部门
	 **/
	public int delete(Integer depId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer depId);

	/**
	 *  已经存在部门列表
	 **/
	public List<SysDepartment> getHaveDepartmentList(List<SysDepartment> list);
	/**
	 *  分页列表部门列表
	 **/
	public Page<SysDepartment> getDepartmentList(Map map);

	/**
	 * 根据ID获取部门
	 */
	public SysDepartment getDepartmentById(Integer depId);

	/**
	 *  部门ID列表
	 **/
	public List<String> getIdList();

}


