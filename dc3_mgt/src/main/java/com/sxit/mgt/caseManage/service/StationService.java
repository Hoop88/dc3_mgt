package com.sxit.mgt.caseManage.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sxit.mgt.caseManage.dao.StationDao;
import com.sxit.model.caseManage.TcasStation;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.pagehelper.PageHelper;

/**
 * @公司:深讯信科
 * @功能:岗位 Service
 * @作者:张如兵    
 * @日期:2015-08-03 16:55:52  
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class StationService {

	@Autowired
	private StationDao stationDao;

	/**
	 * 新增 岗位
	 **/
	@Transactional
	public int insert(TcasStation station) {
		return stationDao.insert(station);
	}

	/**
	 * 批量新增 岗位
	 **/
	@Transactional
	public void insertList(List<TcasStation> list) {
		if(list.size()>0)
		{
			stationDao.insertList(list);
		}
		 
	}

	/**
	 * 批量修改 岗位
	 **/
	@Transactional
	public void updateList(List<TcasStation> list) {
		if(list.size()>0)
		{
		 stationDao.updateList(list);
		}
	}

	/**
	 * 修改 岗位
	 **/
	@Transactional
	public int update(TcasStation station) {
		return stationDao.update(station);
	}

	/**
	 * 是否存在 岗位
	 **/
	public int isHave(String stationGuid) {
		return stationDao.isHave(stationGuid);
	}

	/**
	 *  删除岗位
	 **/
	@Transactional
	public int delete(String stationGuid){
	       return stationDao.delete(stationGuid);
	}


	/**
	 *  标识删除岗位
	 **/
	@Transactional
	public int updateToDelete(String stationGuid){
	       return stationDao.updateToDelete(stationGuid);
	}

	/**
	 * 分页列表 岗位
	 **/
	public Page<TcasStation> getStationList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return stationDao.getStationList(map);
	}

	/**
	 * 已经存在的列表 岗位
	 **/
	public List<TcasStation> getHaveStationList(List<TcasStation> list) {
		return stationDao.getHaveStationList(list);
	}

	/**
	 * 根据ID获取岗位
	 */
	public TcasStation getStationById(String stationGuid){
	       return stationDao.getStationById(stationGuid);
	}

	/**
	 * ID Map 岗位
	 **/
	public Map<String,String> getIdMap(){
		Map<String,String> map = new HashMap();
		for(String id:stationDao.getIdList())
		{
			map.put(id, id);
		}
		return map;
	}

}


