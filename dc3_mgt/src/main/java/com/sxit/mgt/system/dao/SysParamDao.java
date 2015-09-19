package com.sxit.mgt.system.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.system.SysParams;

/**
 * @公司:深讯信科
 * @功能:系统参数 Dao
 * @作者:张如兵    
 * @日期:2015-07-20 14:00:23  
 * @版本:1.0
 * @修改:
 */
 
public interface SysParamDao {

        /**
	 *  新增系统参数
	 **/
	public int insert(SysParams sysParam);
        /**
	 *  修改系统参数
	 **/
	public int update(SysParams sysParam);
	/**
	 *  批量新增系统参数
	 **/
	public void insertList(List<SysParams> list);
	/**
	 *  批量更新系统参数
	 **/
	public void updateList(List<SysParams> list);
	/**
	 *  是否存在系统参数
	 **/
	public int isHave(Long paramsId);

	/**
	 *  删除系统参数
	 **/
	public int delete(Long paramsId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long paramsId);

	/**
	 *  已经存在系统参数列表
	 **/
	public List<SysParams> getHaveSysParamList(List<SysParams> list);
	/**
	 *  分页列表系统参数列表
	 **/
	public Page<SysParams> getSysParamList(Map map);

	/**
	 * 根据ID获取系统参数
	 */
	public SysParams getSysParamById(Long paramsId);

	/**
	 *  系统参数ID列表
	 **/
	public List<String> getIdList();

}


