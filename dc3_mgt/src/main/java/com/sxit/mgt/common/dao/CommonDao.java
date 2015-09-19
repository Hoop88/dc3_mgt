package com.sxit.mgt.common.dao;

import java.util.List;
import java.util.Map;

import cn.com.sxit.weixin.entity.TSystemParamsBean;

import com.sxit.model.common.StringMap;
import com.sxit.model.system.SysParams;

/**
 * @公司:深讯信科
 * @功能:公共 Dao
 * @作者:张如兵    
 * @日期:2015-03-12 16:38:59  
 * @版本:1.0
 * @修改:
 */
 
public interface CommonDao {
	
	
	/**
	 * 获取路径的权限
	 * @return
	 */
	public List<StringMap> getPathRight();
	/**
	 * 获取系统参数列表
	 * @param map
	 * @return
	 */

	public List<SysParams> getParamsList(Map map);
	
	/**
	 *  获取系统参数
	 **/
	public List<StringMap> getSysParamsList();
	
	/**
	 * 根据参数名称获取系统参数
	 * @param paramsname
	 * @return
	 */
	public SysParams getSysParamsByName(SysParams params);
	
	
	/**
	 * 查询微信引擎参数配置
	 * @return
	 */
	public List<TSystemParamsBean> querySystemParamList();

}


