package com.sxit.client.mingyuan;

import com.sxit.common.utils.JsonUtils;
import com.sxit.config.MingYuanApiConfig;


/**
 * 明源接口封装类
 * 
 * @author agu
 * 
 */
public class MingYuanApi {

	public MingYuanApi() {
		super();
	}

	/**
	 * 2.1.10 根据客户GUID查询会员信息
	 * @param cstguid
	 * @return
	 */
	public static CstMemberVo getCstMemInfo(String cstguid) {
		String action = MingYuanApiConfig.api_url+"?methodname=querymemberinfo";
		
		String content = "[{\"cstguid\":\""+cstguid+"\"}]";
		
		String res =SimpleMingYuanClient.execute(action, content);
		
		try{
			MingYuanRes myRes = JsonUtils.toObject(res, MingYuanRes.class);
			
			if("0".equals(myRes.getErrorcode()))
			{
				CstMemberVo cst = JsonUtils.toObject(myRes.getMessage(), CstMemberVo.class);
				
				return cst;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
		
	public static void main(String[] args) {
		

		
		MingYuanApi.getCstMemInfo("E6969509-1362-494D-82ED-E5E44414CD52");
		
	}

}
