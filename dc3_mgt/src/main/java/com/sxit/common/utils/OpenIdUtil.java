package com.sxit.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.sxit.weixin.system.SystemUtil;

import com.sxit.common.memery.CacheData;

public class OpenIdUtil {

	private static final Log LOG = LogFactory.getLog(OpenIdUtil.class);

	public static String getWebUrl(String openId, Integer roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("openid", openId);

		String baseurl = CacheData.getParamsMap().get("base_url");

		if (baseurl == null || "".equals(baseurl)) {
			baseurl = "http://acsx.timesgroup.cn/st_web/bind/initBind";
		}

		return SystemUtil.appendParam(baseurl + "?bindType=" + roleId, params);
	}

	public static String getPmUrl(String openId) {

		return getWebUrl(openId, 2);
	}

	public static String getAcUrl(String openId) {
		return getWebUrl(openId, 1);
	}

	public static String getAdUrl(String openId) {
		return getWebUrl(openId, 3);
	}

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();

		// params.put("openid","ohZa6jmCf7MeFTCqP62p_jd28Sdf");

		// params.put("openid","oQQF7jtBMa-PNZp9R_SwevBVS6NQ");

		// params.put("openid", "o44-auDqW-lAmjkHMI8_i1aZCSaw");
		params.put("openid", "o44-auOay9XaRw3flJwYhGU44lI0");

		// oQQF7jtBMa-PNZp9R_SwevBVS6NQ

		// o44-auK7O96QqndIvol0CoL4g0pQ

		String url = SystemUtil
				.appendParam(
						"http://yxwxkf.yuexiuproperty.cn/yxwx/memberCenter/initMemberCenter.action",
						params);
		System.out.println(url);

		url = SystemUtil
				.appendParam(
						"http://yxwxkf.yuexiuproperty.cn/yxwx/propertyPay/initPropertyPay.action",
						params);
		System.out.println(url);

		// http://yxwxkf.yuexiuproperty.cn/yxac_test/bind/initBind.action?bindType=3&s=bmbpZ9Of6MILlhkgh%2Bxl0I0Hv3Bd4fzVWqTlvz7Ra%2FlwMRH974cAdDdpPftd%2Fv3sp%2BodyQvowEKq%0D%0AUnDgi4GmAn1H8bY7jectxQASbIdgrGHkFW23Xpg%3D%0D%0A&v=7462CECD316FD7B3AA379E7481FF1003B98960BB
		url = SystemUtil
				.appendParam(
						"http://yxwxkf.yuexiuproperty.cn/yxac/bind/initBind.action?bindType=3",
						params);
		System.out.println(url);

		url = SystemUtil
				.appendParam(
						"http://yxwxkf.yuexiuproperty.cn/yxac/bind/initBind.action?bindType=2",
						params);
		System.out.println(url);

		// http://weixin.sxit.com.cn/ac_wx/bind/initBind.action?bindType=2&s=bmbpZ9Of6MILlhkgh%2Bxl0I0Hv3Bd4fzVWqTlvz7Ra%2FlwMRH974cAdDdpPftd%2Fv3sp%2BodyQvowEKq%0D%0AUnDgi4GmAn1H8bY7jectxQASbIdgrGHkFW23Xpg%3D%0D%0A&v=7462CECD316FD7B3AA379E7481FF1003B98960BB

		// http://yxwxkf.yuexiuproperty.cn/yxac/bind/initBind.action?bindType=3&s=bmbpZ9Of6MILlhkgh%2Bxl0I0Hv3Bd4fzVWqTlvz7Ra%2FlwMRH974cAdDdpPftd%2Fv3sp%2BodyQvowEKq%0D%0AUnDgi4GmAn1H8bY7jectxQASbIdgrGHkFW23Xpg%3D%0D%0A&v=7462CECD316FD7B3AA379E7481FF1003B98960BB
	}
}
