package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;
import com.sxit.common.pagehelper.Page;
import com.sxit.model.caseManage.TcasStation;

/**
 * @公司:深讯信科
 * @功能:岗位 Dao
 * @作者:张如兵    
 * @日期:2015-08-03 16:55:52  
 * @版本:1.0
 * @修改:
 */
 
public interface StationDao {

        /**
	 *  新增岗位
	 **/
	public int insert(TcasStation station);
        /**
	 *  修改岗位
	 **/
	public int update(TcasStation station);
	/**
	 *  批量新增岗位
	 **/
	public void insertList(List<TcasStation> list);
	/**
	 *  批量更新岗位
	 **/
	public void updateList(List<TcasStation> list);
	/**
	 *  是否存在岗位
	 **/
	public int isHave(String stationGuid);

	/**
	 *  删除岗位
	 **/
	public int delete(String stationGuid);

	/**
	 * 标识删除
	 */
	public int updateToDelete(String stationGuid);

	/**
	 *  已经存在岗位列表
	 **/
	public List<TcasStation> getHaveStationList(List<TcasStation> list);
	/**
	 *  分页列表岗位列表
	 **/
	public Page<TcasStation> getStationList(Map map);

	/**
	 * 根据ID获取岗位
	 */
	public TcasStation getStationById(String stationGuid);

	/**
	 *  岗位ID列表
	 **/
	public List<String> getIdList();

}


