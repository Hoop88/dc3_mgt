package com.sxit.client.mingyuan;

import com.sxit.common.web.WebClient;
import com.sxit.config.MingYuanApiConfig;

/**
 * 明源接口封装类
 * 
 * @author agu
 * 
 */
public class MingYuanClient {
	private WebClient client;
	
	public MingYuanClient() {
		super();
		client = new WebClient();
	}

	/**
	 * 2.1.10 根据客户GUID查询会员信息
	 * @param cstguid
	 * @return
	 */
	public CstMemberVo getCstMemInfo(String cstguid) {
		String action = MingYuanApiConfig.api_url+"?methodname=querymemberinfo";
		
		System.out.println(action);
		
		String content = "[{\"cstguid\":\""+cstguid+"\"}]";
		
		System.out.println(content);
		
		String res =client.doPost(action, content,"gb2312");
		
		System.out.println(res);
		
		return null;
	}
	
	public static void main(String[] args) {
		
		MingYuanClient myclient = new MingYuanClient();
		
		myclient.getCstMemInfo("59fa4f1f-92fc-4ca6-be40-2a4aaa224550");
		
	}

}
