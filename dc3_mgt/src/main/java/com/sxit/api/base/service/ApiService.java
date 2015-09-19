package com.sxit.api.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.api.base.dao.ApiDao;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.model.report.LogApi;

/**
 * @公司:深讯信科
 * @功能:接口Service
 * @作者:张如兵    
 * @日期:2015-05-16 11:52:49  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class ApiService {

	@Autowired
	private ApiDao apiDao;

	/**
	 * 新增 接口日志
	 **/
	@Transactional
	public int insert(LogApi api) {
		return apiDao.insert(api);
	}

	/**
	 * 批量新增 接口日志
	 **/
	@Transactional
	public void insertList(List<LogApi> list) {
		if(list.size()>0)
		{
			apiDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 接口日志
	 **/
	@Transactional
	public void updateList(List<LogApi> list) {
		if(list.size()>0)
		{
		 apiDao.updateList(list);
		}
	}

	/**
	 * 修改 接口日志
	 **/
	@Transactional
	public int update(LogApi api) {
		return apiDao.update(api);
	}

	/**
	 * 是否存在 接口日志
	 **/
	public int isHave(Integer id) {
		return apiDao.isHave(id);
	}

	/**
	 *  删除接口日志
	 **/
	@Transactional
	public int delete(Integer id){
	       return apiDao.delete(id);
	}


	/**
	 *  标识删除接口日志
	 **/
	@Transactional
	public int updateToDelete(Integer id){
	       return apiDao.updateToDelete(id);
	}

	/**
	 * 分页列表 接口日志
	 **/
	public Page<LogApi> getApiList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return apiDao.getApiList(map);
	}

	/**
	 * 已经存在的列表 接口日志
	 **/
	public List<LogApi> getHaveApiList(List<LogApi> list) {
		return apiDao.getHaveApiList(list);
	}

	/**
	 * 根据ID获取接口日志
	 */
	public LogApi getApiById(Integer id){
	       return apiDao.getApiById(id);
	}

	/**
	 * ID Map 接口日志
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:apiDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


