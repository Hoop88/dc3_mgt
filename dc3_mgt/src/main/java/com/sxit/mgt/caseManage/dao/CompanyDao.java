package com.sxit.mgt.caseManage.dao;

import java.util.List;
import java.util.Map;

import com.sxit.common.pagehelper.Page;
import com.sxit.model.caseManage.TcasCompany;
import com.sxit.model.common.LongMap;

/**
 * @公司:深讯信科
 * @功能:城市公司 Dao
 * @作者:张如兵
 * @日期:2015-07-22 17:32:53
 * @版本:1.0
 * @修改:
 */

public interface CompanyDao {

	/**
	 * 新增城市公司
	 **/
	public int insert(TcasCompany company);

	/**
	 * 修改城市公司
	 **/
	public int update(TcasCompany company);

	/**
	 * 批量新增城市公司
	 **/
	public void insertList(List<TcasCompany> list);

	/**
	 * 批量更新城市公司
	 **/
	public void updateList(List<TcasCompany> list);

	/**
	 * 是否存在城市公司
	 **/
	public int isHave(Long companyId);

	/**
	 * 删除城市公司
	 **/
	public int delete(Long companyId);

	/**
	 * 标识删除
	 */
	public int updateToDelete(Long companyId);

	/**
	 * 已经存在城市公司列表
	 **/
	public List<LongMap> getCityCompanyMap();
	
	
	public List<LongMap> getAllCompanyMap();

	/**
	 * 分页列表城市公司列表
	 **/
	public Page<TcasCompany> getCompanyList(Map map);

	/**
	 * 根据ID获取城市公司
	 */
	public TcasCompany getCompanyById(Long companyId);

	/**
	 * 获取代理公司的所属公司
	 * 
	 * @param companyId
	 * @return
	 */
	public Long getProjectLevel1Id(Long companyId);

	/**
	 * 删除代理公司所属项目
	 * 
	 * @param companyId
	 */
	public void deleteCompanyProjectLevel1(Long companyId);

	/**
	 * 添加代理公司所属项目
	 * 
	 * @param map
	 */
	public void addCompanyProjectLevel1(Map map);

	/**
	 * 城市公司ID列表
	 **/
	public List<String> getIdList();

}
