package com.sxit.api.customer.dao;

import java.util.List;

import com.sxit.model.member.CstAuth;
import com.sxit.model.member.CstCustomer;
import com.sxit.model.member.CstMember;

/**
 * @公司:深讯信科
 * @功能:客户合并 Dao
 * @作者:张如兵    
 * @日期:2015-05-16 13:50:40  
 * @版本:1.0
 * @修改:
 */
 
public interface CustomerMergeDao {

	/**
	 * 获取绑定
	 * @param cstguid
	 * @return
	 */
	public CstAuth getCstAuthByCstguid(Long cstguid);
	
	
	/**
	 *  获取多个客户
	 **/
	public List<CstCustomer> getCustomerList(List<String> list);
	
	/**
	 * 根据ID获取客户合并
	 */
	public CstCustomer getCustomerMergeById(Long cstguid);
	
	
	/**
	 * 获取客户
	 * @param origuid
	 * @return
	 */
	public CstCustomer getCustomerByGuid(String origuid);
	
	
	/**
	 * 获取会员 通过会员id
	 * @param cstguid
	 * @return
	 */
	public CstMember getCstMemberByGuid(String orimemguid);
	
	
	/**
	 * 获取会员
	 * @param orimemguid
	 * @return
	 */
	public CstMember getCstMemberByCstid(Long cstguid);
	
	
    /**
	 *  新增客户
	 **/
	public int insertCustomer(CstCustomer customerMerge);
        /**
	 *  修改客户
	 **/
	public int updateCustomer(CstCustomer customerMerge);
	
	
    /**
	 *  新增会员
	 **/
	public int insertMember(CstMember member);
        /**
	 *  修改会员
	 **/
	public int updateMember(CstMember member);

	/**
	 * 删除一个客户
	 * @param origuid
	 * @return
	 */
	public int deleteByGuid(String origuid);
	
	/**
	 * 是否绑定
	 * @param cstguid
	 * @return
	 */
	public int isHaveBind(Long cstguid);
	/**
	 * 删除多个客户
	 * @param list
	 */
	public void deleteCustomers(List<String> list);
	/**
	 * 删除多个会员
	 * @param list
	 */
	public void deleteMembers(List<String> list);

}


