package com.sxit.api.customer.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sxit.api.base.handler.AbstractHandler;
import com.sxit.api.base.vo.ResponseVo;
import com.sxit.api.customer.service.CustomerMergeService;
import com.sxit.api.customer.vo.CustomerVo;
import com.sxit.api.customer.vo.MemberVo;
import com.sxit.api.customer.vo.CustomerMergeVo;
import com.sxit.client.yxwxapi.YxwxApi;
import com.sxit.common.utils.JsonUtils;
import com.sxit.model.member.CstAuth;
import com.sxit.model.member.CstCustomer;
import com.sxit.model.member.CstMember;

/**
 * 置业顾问 添加基础信息
 * 
 * @author agu
 * 
 */
@Component("customerMerge")
@Scope("prototype")
public class CustomerRergeHandler extends AbstractHandler {

	private CustomerMergeVo vo;

	@Autowired
	private CustomerMergeService customerMergeService;

	/**
	 * 初始化
	 */
	@Override
	public boolean handlerInitial() {
		try {
			if (StringUtils.isBlank(content)) {
				throw new Exception("content内容不能为空");
			}
			vo = JsonUtils.deserialize(content, CustomerMergeVo.class);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg(ResponseVo.errorMsg("json解析错误", 1));
			return false;
		}
	}

	/**
	 * 执行
	 */
	@Override
	public void handle() throws Exception {
       try{
    	   
    	   if(StringUtils.isBlank(vo.getNewCstGUID()))
    	   {
    		   errorMsg(ResponseVo.errorMsg("缺少参数:NewCstGUID"));
    		   return;
    	   }
    	   
    	   if(vo.getOldCstGUIDList()==null || vo.getOldCstGUIDList().isEmpty())
    	   {
    		   errorMsg(ResponseVo.errorMsg("缺少参数:OldCstGUIDList"));
    		   return;
    	   }
    	   List<String> oriGuidList = new ArrayList();
    	   
    	   //oriGuidList.add(vo.getNewCstGUID());
    	   oriGuidList.addAll(vo.getOldCstGUIDList());
    	   
    	   CstCustomer new_cst = customerMergeService.getCustomerByGuid(vo.getNewCstGUID());
    	  
    	   
    	   int is_have_bind = 0;   //是否绑定过 
    	   
    	   Long cstguid=0l;  //保存绑定的客户ID
    	   
    	   String origuid=null; //保存绑定的明源guid;
    	   
    	   
    	   if(new_cst!=null)
    	   {
    		   is_have_bind = customerMergeService.isHaveBind(new_cst.getCstguid());
    		   //如果新的客户就是绑定的客户, 只需要删除其余的客户 , 不需要额外处理
    		   if(is_have_bind==1)
    		   {
    			   cstguid = new_cst.getCstguid();
    			   origuid = new_cst.getOriguid();
    		   }
    	   }
    	   
    	    
    	   if(is_have_bind!=1)
		   {
    		   List<CstCustomer> cstList = customerMergeService.getCustomerList(oriGuidList);
        	   //查询是否有绑定 
        	   for(CstCustomer cst:cstList)
        	   {
        		   is_have_bind = customerMergeService.isHaveBind(cst.getCstguid());
        		   //如果新的客户就是绑定的客户, 只需要删除其余的客户 , 不需要额外处理
        		   if(is_have_bind==1)
        		   {
        			   cstguid = cst.getCstguid();
        			   origuid = new_cst.getOriguid();
        			   break;
        		   }
        	   }
		   }
    	   
    	   //如果绑定过
    	   if(is_have_bind==1)
		   {
    		   //获取绑定记录
    		   CstAuth ca = customerMergeService.getCstAuthByCstguid(cstguid);
    		   if(ca!=null)
    		   {
    			   //先处理会员数据合并
    			   if(StringUtils.isNotBlank(vo.getNewMemGUID()) && !"NULL".equals(vo.getNewMemGUID()))
    			   {
    				   //从接口请求数据
    				   MemberVo mem =YxwxApi.getCstMemInfo(vo.getNewMemGUID());
        			   
        			   if(mem==null)
        			   {
        				   errorMsg(ResponseVo.errorMsg("合并失败,获取客户信息失败 NewMemGUID:"+vo.getNewMemGUID()));
        				   return;
        			   }
    				   
    				   List<String> templist = new ArrayList();
    				      				   
    				   CstMember member =  customerMergeService.getCstMemberByGuid(vo.getNewMemGUID());
    				   
    				   if(member!=null)
    				   {
        				   templist.add(vo.getNewCstGUID());
        				   templist.addAll(oriGuidList);
        				   templist.remove(member.getOricstguid());
        				   
        				   //删除多余的会员
        				   customerMergeService.deleteMembers(templist);
        				   
        				   member.setOricstguid(vo.getNewCstGUID());
        				   member.setOrimemguid(vo.getNewMemGUID());
        				   member.setBuguid(mem.getBuguid());
        				   member.setCstguid(cstguid);
        				   member.setJoinpath(mem.getJoinpath());
        				   member.setJoindate(mem.getJoindate());
        				   member.setLjpoint(mem.getLjpoint());
        				   member.setApplydate(mem.getApplydate());
        				   member.setMemcode(mem.getMemcode());
        				   member.setMemstation(mem.getMemstation());
        				   member.setMemlevel(mem.getMemlevel());
        				   member.setMemstatus(mem.toMemstatus());
        				   member.setAccountid(ca.getAccountid());
        				   member.setBindDate(ca.getLastupdatetime());
        				   member.setBuguid(mem.getBuguid());
        				   log.info("=========================");
        				   log.info("buguid:"+member.getBuguid());
        				   customerMergeService.updateMember(member);
        				   log.info("==========================");
        				   
    				   }else{
    					   //新增一个会员
    					   member = new CstMember();
        				   member.setOricstguid(vo.getNewCstGUID());
        				   member.setOrimemguid(vo.getNewMemGUID());
        				   member.setBuguid(mem.getBuguid());
        				   member.setCstguid(cstguid);
        				   member.setJoinpath(mem.getJoinpath());
        				   member.setJoindate(mem.getJoindate());
        				   member.setLjpoint(mem.getLjpoint());
        				   member.setApplydate(mem.getApplydate());
        				   member.setMemcode(mem.getMemcode());
        				   member.setMemstation(mem.getMemstation());
        				   member.setMemlevel(mem.getMemlevel());
        				   member.setMemstatus(mem.toMemstatus());
        				   member.setAccountid(ca.getAccountid());
        				   member.setBindDate(ca.getLastupdatetime());
        				   member.setBuguid(mem.getBuguid());
        				   log.info("=========================");
        				   customerMergeService.insertMember(member);
        				   log.info("==========================");
    				   }
    			   }
    			   
    			   //从接口请求数据
    			   CustomerVo cst =	YxwxApi.getCstCustomerInfo(vo.getNewCstGUID());
    			  
    			   CstCustomer customer = customerMergeService.getCustomerById(cstguid);
    			   
    			  
    			   //合并客户

    			   if(customer != null)
    			   {
    				   oriGuidList.add(vo.getNewCstGUID());
        			   oriGuidList.remove(customer.getOriguid());
        			   //删除多余的客户
        			   customerMergeService.deleteCustomers(oriGuidList);
        			   
    				   customer.setCstname(cst.getCstname());
    				   
    				   customer.setCsttype(cst.toCsttype());
    				   customer.setCardtype(cst.toCardtype());
    				   customer.setCardid(cst.getCardid());
    				   customer.setCardid15(cst.getCardid15());
    				   customer.setMobiletel(cst.getMobiletel());
    				   customer.setHometel(cst.getHometel());
    				   customer.setEmail(cst.getEmail());
    				   customer.setAddress(cst.getAddress());
    				   customer.setProvince(cst.getProvince());
    				   customer.setCity(cst.getCity());
    				   customer.setRegional(cst.getRegional());
    				   customer.setRoad(cst.getRoad());
    				   customer.setOriguid(vo.getNewCstGUID());
    				   
    				   
    				   customerMergeService.updateCustomer(customer);	   
    			   } else {
    				   customerMergeService.deleteCustomers(oriGuidList);
    				   
    				   customer = new CstCustomer();
    				   
    				   customer.setCstname(cst.getCstname());
    				   customer.setCsttype(cst.toCsttype());
    				   customer.setCardtype(cst.toCardtype());
    				   customer.setCardid(cst.getCardid());
    				   customer.setCardid15(cst.getCardid15());
    				   customer.setMobiletel(cst.getMobiletel());
    				   customer.setHometel(cst.getHometel());
    				   customer.setEmail(cst.getEmail());
    				   customer.setAddress(cst.getAddress());
    				   customer.setProvince(cst.getProvince());
    				   customer.setCity(cst.getCity());
    				   customer.setRegional(cst.getRegional());
    				   customer.setRoad(cst.getRoad());
    				   customer.setOriguid(vo.getNewCstGUID());
    				   customerMergeService.insertCustomer(customer);	   
    				   
    			   } 			   
    			   
    		   }else{
    			   //未绑定过删除数据即可  下次绑定的时候会自动取数据
    			   customerMergeService.deleteCustomers(oriGuidList);
    			   customerMergeService.deleteMembers(oriGuidList);
    		   }
		   }else{
			   
			   //未绑定过删除数据即可  下次绑定的时候会自动取数据
			   oriGuidList.add(vo.getNewCstGUID());
			   customerMergeService.deleteCustomers(oriGuidList);
			   customerMergeService.deleteMembers(oriGuidList);
			   
		   }
    	   
			successMsg(ResponseVo.successMsg("合并成功"));
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg(ResponseVo.errorMsg(e.getMessage()));
		}
	}

	/**
	 * 验证
	 */
	@Override
	public boolean verify() throws Exception {
		return this.verify(vo);
	}

}
