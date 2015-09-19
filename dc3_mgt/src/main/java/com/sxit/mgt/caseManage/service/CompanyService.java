package com.sxit.mgt.caseManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.caseManage.dao.CompanyDao;
import com.sxit.model.caseManage.TcasCompany;
import com.sxit.model.common.LongMap;

/**
 * @公司:深讯信科
 * @功能:城市公司 Service
 * @作者:张如兵
 * @日期:2015-07-22 17:32:53
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	/**
	 * 新增 城市公司
	 **/
	@Transactional
	public int insert(TcasCompany company) {
		return companyDao.insert(company);
	}

	@Transactional
	public int insertProxyCompany(TcasCompany company) {
       
		return	companyDao.insert(company);
		
/*		if (company.getCompanyType() == 2) {
			companyDao.insert(company);
			if (company.getProjectId() != null) {
				Map map = new HashMap();
				map.put("projectId", company.getProjectId());
				map.put("companyId", company.getCompanyId());

				companyDao.addCompanyProjectLevel1(map);
			}
			return 1;
		} else {
			return 0;
		}*/
	}

	/**
	 * 修改 城市公司
	 **/
	@Transactional
	public int update(TcasCompany company) {
		return companyDao.update(company);
	}

	/**
	 * 
	 * @param company
	 * @return
	 */
	@Transactional
	public int updateProxyCompany(TcasCompany company) {

		if (company.getCompanyType() == 2) {
			/*Long projectId = companyDao.getProjectLevel1Id(company
					.getCompanyId());

			if (projectId != null && !projectId.equals(company.getProjectId())) {
				companyDao.deleteCompanyProjectLevel1(company.getCompanyId());
			}

			if (company.getProjectId() != null
					&& !company.getProjectId().equals(projectId)) {
				Map map = new HashMap();
				map.put("projectId", company.getProjectId());
				map.put("companyId", company.getCompanyId());

				companyDao.addCompanyProjectLevel1(map);
			}
			*/
			return companyDao.update(company);
		} else {
			return 0;
		}

	}

	/**
	 * 是否存在 城市公司
	 **/
	public int isHave(Long companyId) {
		return companyDao.isHave(companyId);
	}

	/**
	 * 删除城市公司
	 **/
	@Transactional
	public int delete(Long companyId) {
		return companyDao.delete(companyId);
	}

	/**
	 * 标识删除城市公司
	 **/
	@Transactional
	public int updateToDelete(Long companyId) {
		return companyDao.updateToDelete(companyId);
	}

	/**
	 * 分页列表 城市公司
	 **/
	public Page<TcasCompany> getCompanyList(PageVo page, Map map) {
		PageHelper.startPage(page.getPage(), page.getPageSize());
		return companyDao.getCompanyList(map);
	}

	/**
	 * 已经存在的列表 城市公司
	 **/
	public Map<Long, String> getCityCompanyMap() {

		List<LongMap> list = companyDao.getCityCompanyMap();

		Map<Long, String> map = new HashMap();

		for (LongMap im : list) {
			map.put(im.getId(), im.getName());
		}

		return map;
	}
	
	public Map<Long, String> getAllCompanyMap() {

		List<LongMap> list = companyDao.getAllCompanyMap();

		Map<Long, String> map = new HashMap();

		for (LongMap im : list) {
			map.put(im.getId(), im.getName());
		}

		return map;
	}

	/**
	 * 根据ID获取城市公司
	 */
	public TcasCompany getCompanyById(Long companyId) {
		return companyDao.getCompanyById(companyId);
	}

	/**
	 * 获取代理公司的所属公司
	 * 
	 * @param companyId
	 * @return
	 */
	public Long getProjectLevel1Id(Long companyId) {
		return companyDao.getProjectLevel1Id(companyId);
	}

	/**
	 * ID Map 城市公司
	 **/
	public Map<String, String> getIdMap() {
		Map<String, String> map = new HashMap();
		for (String id : companyDao.getIdList()) {
			map.put(id, id);
		}
		return map;
	}

}
