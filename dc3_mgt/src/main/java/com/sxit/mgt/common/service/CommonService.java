package com.sxit.mgt.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sxit.weixin.entity.TSystemParamsBean;

import com.sxit.mgt.common.dao.CommonDao;
import com.sxit.model.common.StringMap;
import com.sxit.model.system.SysParams;

/**
 * @公司:深讯信科
 * @功能:公共 Service
 * @作者:张如兵
 * @日期:2015-03-12 16:38:59
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class CommonService {

	@Autowired
	private CommonDao commonDao;

	/**
	 * 获取系统参数列表
	 * @param map
	 * @return
	 */
	public List<SysParams> getParamsList(Map map)
	{
		return
				 commonDao.getParamsList(map);
	}
	/**
	 * 系统参数
	 **/
	@Cacheable(value = "sysParamsMap")
	public Map<String, String> getSysParamsMap() {
		Map<String, String> map = new HashMap();
		for (StringMap sm : commonDao.getSysParamsList()) {
			map.put(sm.getKeystr(), sm.getValuestr());
		}
		return map;
	}
	
	
	/**
	 * 系统参数
	 **/
	@Cacheable(value = "pathRightMap")
	public Map<String, String> getPathRightMap() {
		Map<String, String> map = new HashMap();
		for (StringMap sm : commonDao.getPathRight()) {
			map.put(sm.getKeystr().toLowerCase(), sm.getValuestr().toLowerCase());
		}
		return map;
	}
	

	
	/**
	 * 根据参数名称获取系统参数
	 * @param paramsname
	 * @return
	 */
	public SysParams getSysParamsByName(SysParams params) {
		return commonDao.getSysParamsByName(params);
	}
	
	
	/**
	 * 查询微信引擎参数配置
	 * @return
	 */
	public List<TSystemParamsBean> querySystemParamList() {
		return commonDao.querySystemParamList();
	}

}
