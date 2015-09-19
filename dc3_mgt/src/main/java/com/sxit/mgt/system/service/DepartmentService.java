package com.sxit.mgt.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.system.dao.DepartmentDao;
import com.sxit.model.system.SysDepartment;

/**
 * @公司:深讯信科
 * @功能:部门 Service
 * @作者:张如兵    
 * @日期:2015-06-17 16:47:22  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * 新增 部门
	 **/
	@CacheEvict(value = "allDepartmentList", allEntries = true)
	@Transactional
	public int insert(SysDepartment department) {
		return departmentDao.insert(department);
	}


	/**
	 * 修改 部门
	 **/
	@CacheEvict(value = "allDepartmentList", allEntries = true)
	@Transactional
	public int update(SysDepartment department) {
		return departmentDao.update(department);
	}

	/**
	 * 是否存在 部门
	 **/
	public int isHave(Integer depId) {
		return departmentDao.isHave(depId);
	}

	/**
	 *  删除部门
	 **/
	@CacheEvict(value = "allDepartmentList", allEntries = true)
	@Transactional
	public int delete(Integer depId){
	       return departmentDao.delete(depId);
	}


	/**
	 *  标识删除部门
	 **/
	@Transactional
	public int updateToDelete(Integer depId){
	       return departmentDao.updateToDelete(depId);
	}

	/**
	 * 分页列表 部门
	 **/
	public Page<SysDepartment> getDepartmentList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return departmentDao.getDepartmentList(map);
	}

	/**
	 * 已经存在的列表 部门
	 **/
	@Cacheable(value = "allDepartmentList")
	public List<SysDepartment> getAllDepartmentList() {
		return departmentDao.getDepartmentList(null);
	}

	/**
	 * 根据ID获取部门
	 */
	public SysDepartment getDepartmentById(Integer depId){
	       return departmentDao.getDepartmentById(depId);
	}

	/**
	 * ID Map 部门
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:departmentDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


