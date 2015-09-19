package com.sxit.api.customer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxit.api.customer.dao.CustomerMergeDao;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageHelper;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.model.member.CstAuth;
import com.sxit.model.member.CstCustomer;
import com.sxit.model.member.CstMember;

/**
 * @公司:深讯信科
 * @功能:客户合并 Service
 * @作者:张如兵
 * @日期:2015-05-16 13:50:40
 * @版本:1.0
 * @修改:
 */

@Service
@Transactional(readOnly = true)
public class CustomerMergeService {

	@Autowired
	private CustomerMergeDao customerMergeDao;

	/**
	 * 新增 客户
	 **/
	@Transactional
	public int insertCustomer(CstCustomer customerMerge) {
		return customerMergeDao.insertCustomer(customerMerge);
	}

	/**
	 * 修改 客户
	 **/
	@Transactional
	public int updateCustomer(CstCustomer customerMerge) {
		return customerMergeDao.updateCustomer(customerMerge);
	}
	
	/**
	 * 新增 会员
	 **/
	@Transactional
	public int insertMember(CstMember member) {
		return customerMergeDao.insertMember(member);
	}

	/**
	 * 修改 会员
	 **/
	@Transactional
	public int updateMember(CstMember member) {
		return customerMergeDao.updateMember(member);
	}



	/**
	 * 客户列表
	 * 
	 **/
	public List<CstCustomer> getCustomerList(List<String> list) {
		return customerMergeDao.getCustomerList(list);
	}

	/**
	 * 根据ID获取客户
	 */
	public CstCustomer getCustomerById(Long cstguid) {
		return customerMergeDao.getCustomerMergeById(cstguid);
	}

	/**
	 * 获取绑定
	 * @param cstguid
	 * @return
	 */
	public CstAuth getCstAuthByCstguid(Long cstguid) {
		return customerMergeDao.getCstAuthByCstguid(cstguid);
	}

	/**
	 * 获取客户
	 * @param origuid
	 * @return
	 */
	public CstCustomer getCustomerByGuid(String origuid) {
		return customerMergeDao.getCustomerByGuid(origuid);
	}

	/**
	 * 获取会员
	 * 
	 * @param orimemguid
	 * @return
	 */
	public CstMember getCstMemberByCstid(Long cstguid) {
		return customerMergeDao.getCstMemberByCstid(cstguid);
	}
	
	/**
	 * 获取会员
	 * @param orimemguid
	 * @return
	 */
	public CstMember getCstMemberByGuid(String orimemguid) {
		return customerMergeDao.getCstMemberByGuid(orimemguid);
	}

	
	/**
	 * 删除多个客户
	 * @param list
	 */
	@Transactional
	public void deleteCustomers(List<String> list) {
		customerMergeDao.deleteCustomers(list);
	}

	/**
	 * 删除多个会员
	 * @param list
	 */
	@Transactional
	public void deleteMembers(List<String> list) {
		customerMergeDao.deleteMembers(list);
	}

	/**
	 * 是否已经绑定微信
	 * @param cstguid
	 * @return
	 */
	public int isHaveBind(Long cstguid) {
		return customerMergeDao.isHaveBind(cstguid);
	}

}
