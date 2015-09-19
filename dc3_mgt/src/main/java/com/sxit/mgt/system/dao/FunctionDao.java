package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysFunction;

/**
 * @公司:深讯信科
 * @功能:系统功能 Dao
 * @作者:张如兵    
 * @日期:2015-06-17 16:45:33  
 * @版本:1.0
 * @修改:
 */
 
public interface FunctionDao {

        /**
	 *  新增系统功能
	 **/
	public int insert(SysFunction function);
        /**
	 *  修改系统功能
	 **/
	public int update(SysFunction function);
	/**
	 *  批量新增系统功能
	 **/
	public void insertList(List<SysFunction> list);
	/**
	 *  批量更新系统功能
	 **/
	public void updateList(List<SysFunction> list);
	/**
	 *  是否存在系统功能
	 **/
	public int isHave(Integer functionId);

	/**
	 *  删除系统功能
	 **/
	public int delete(Integer functionId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Integer functionId);

	/**
	 *  已经存在系统功能列表
	 **/
	public List<SysFunction> getAllFunctionList();
	/**
	 *  分页列表系统功能列表
	 **/
	public Page<SysFunction> getFunctionList(Map map);

	/**
	 * 根据ID获取系统功能
	 */
	public SysFunction getFunctionById(Integer functionId);

	/**
	 *  系统功能ID列表
	 **/
	public List<String> getIdList();

}


