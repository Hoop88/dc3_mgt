package com.sxit.client.yxwxapi;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JavaType;
import com.sxit.api.customer.vo.CustomerVo;
import com.sxit.api.customer.vo.MemberVo;
import com.sxit.common.utils.JsonUtils;
import com.sxit.common.web.WebClient;
import com.sxit.config.WeiXinConfig;
import com.sxit.model.member.CstCustomer;

/**
 * 前端微信接口 查询明源的数据 前端有接入明源的数据库 因此中转了一下
 * 
 * @author agu
 * 
 */
public class YxwxApi {
	private static Logger LOG = Logger.getLogger(YxwxApi.class);
	public YxwxApi() {
		super();
	}

	public static MemberVo getCstMemInfo(String memguid) {

		try {
			String action = WeiXinConfig.apiurl
					+ "getMemberInfoFromMingYuan.action?newMemGUID=";
			WebClient client = new WebClient();
			String res = client.doGet(action + memguid, "utf-8");
			///System.out.println(res);
			LOG.info("=============================");
			LOG.info("请求action:"+action+memguid);
			LOG.info("返回:"+res);
			LOG.info("=============================");
			JavaType type = JsonUtils.getCollectionType(SimpleMessage.class,
					MemberVo.class);

			if (StringUtils.isNotBlank(res)) {
				SimpleMessage<MemberVo> sm = JsonUtils.deserialize(res, type);

				if (sm.isSuccess()) {
					return sm.getData();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static CustomerVo getCstCustomerInfo(String cstguid) {
		try {
			String action = WeiXinConfig.apiurl
					+ "getCustomerInfoFromMingYuan.action?newCstGUID=";
			WebClient client = new WebClient();
			String res = client.doGet(action + cstguid, "utf-8");
			LOG.info("=============================");
			LOG.info("请求action:"+action+cstguid);
			LOG.info("返回:"+res);
			LOG.info("=============================");
			JavaType type = JsonUtils.getCollectionType(SimpleMessage.class,
					CustomerVo.class);

			if (StringUtils.isNotBlank(res)) {
				SimpleMessage<CustomerVo> sm = JsonUtils
						.deserialize(res, type);

				if (sm.isSuccess()) {
					return sm.getData();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		// newCstGUID=86451E7F-CDEB-48AB-A44D-75422C45E458

		MemberVo mem =YxwxApi.getCstMemInfo("0008751E-5571-498F-93B5-FC6677F3770B");

		CustomerVo cst =	YxwxApi.getCstCustomerInfo("86451E7F-CDEB-48AB-A44D-75422C45E458");
		
		
		System.out.println("-----");
		
		System.out.println(JsonUtils.toJson(mem));

	}

}
