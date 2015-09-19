/**   
 * @Title: ApiUtil.java 
 * @Package com.sxit.api.client 
 * @Description: 接口请求 
 * @author lit  
 * @date 2014年8月22日 下午12:02:43 
 * @version V1.0   
 */
package com.sxit.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.sxit.api.client.common.vo.RequestVo;
import com.sxit.api.client.common.vo.ResponseVo;
import com.sxit.common.memery.CacheData;
import com.sxit.common.security.DESCoder;
import com.sxit.common.security.MD5;
import com.sxit.common.utils.JsonUtils;
import com.sxit.common.web.WebClient;

/**
 * @ClassName: ApiUtil
 * @Description: 接口请求
 * @author lit
 * @date 2014年8月22日 下午12:02:43
 * 
 */
public class ApiUtil {

	private static final Logger log = Logger.getLogger(ApiUtil.class);

	public static final String md5key = "F0204FA319309C84FA404545D96F1122";
	//public static final String md5key = EntityCache.getInstance().getParamByName(Consts.MD5KEY);
	public static final String deskey = "F0204FA319309D84FA404545D96F5522";
	//public static final String deskey = EntityCache.getInstance().getParamByName(Consts.DESKEY);

	// public static final String action =
	// "http://localhost:8082/anchang/api/interface";
//	public static final String action =
//	 "http://10.10.0.69:8000/api/interface";
//	 public static final String action =
//	 "http://58.60.231.4:55584/api/interface";
	public static String action = "http://10.2.128.205:8087/anchang_test/api/interface";

	/**
	 * @Title: printResLog
	 * @Description: (打印服务器响应的日志)
	 * @param result
	 * @return void
	 * @throws
	 */
	private static void printResLog(String result) {
		// 查看返回加密参数
		try {
			if (result == null) {
				log.info("返回result: is null");
				return;
			}
			ResponseVo res = JsonUtils.toObject(result, ResponseVo.class);

			if (res.getContent() != null) {
				log.info("返回json: " + DESCoder.decrypt(URLDecoder.decode(res.getContent(), "utf-8"), deskey));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String requestApi(String json, String command) {
		
		action = CacheData.getParamsMap().get("anchang_api");

		String result = null;
		try {
			WebClient client = new WebClient();
			client.cookies = "";

			// 内容使用des加密
			log.info(json);
			log.info(DESCoder.encrypt(json, deskey));
			String content = URLEncoder.encode(DESCoder.encrypt(json, deskey), "utf-8");

			String imei = "1111111";
			String modelNum = "weixin";
			String versionNum = "1.0";
			String appVersionNum = "1000100";
			String time = System.currentTimeMillis() + "";

			// vercode 参数
			String vercode = "";
			StringBuffer sb = new StringBuffer();
			sb.append("commond=" + command);
			if (StringUtils.isNotBlank(content)) {
				sb.append("content=" + content);
			}
			if (StringUtils.isNotBlank(versionNum)) {
				sb.append("versionNum=" + versionNum);
			}
			if (StringUtils.isNotBlank(appVersionNum)) {
				sb.append("appVersionNum=" + appVersionNum);
			}
			sb.append("time=" + time);
			vercode = MD5.md5(sb.toString(), md5key);

			RequestVo vo = new RequestVo();
			vo.setCommand(command);
			vo.setContent(content);
			vo.setImei(imei);
			vo.setModelNum(modelNum);
			vo.setTime(time);
			vo.setVercode(vercode);
			vo.setVersionNum(versionNum);
			vo.setAppVersionNum(appVersionNum);

			// 转为JSON字符串
			String param = JsonUtils.serialize(vo);
			result = client.doPost(action, param, "utf-8");
			log.info("================================");
			log.info("请求数据:" + param);
			log.info("================================");
			log.info("返回数据:" + result);
			log.info("================================");
			log.info("请求Json:" + json);
			log.info("================================");
			printResLog(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String decodeResult(String content) {
		String json = null;
		try {
			json = DESCoder.decrypt(URLDecoder.decode(content, "utf-8"), deskey);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
