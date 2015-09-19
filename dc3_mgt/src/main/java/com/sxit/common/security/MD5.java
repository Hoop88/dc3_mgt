package com.sxit.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * md5签名
 * 
 * @author 刘哈哈
 * 
 */
public class MD5 {
	private static Logger LOG = LoggerFactory.getLogger(MD5.class);

	/**
	 * 默认密钥为空
	 */
	private static String DEFAULT_KEY = "你能破解么,我就不信了,哈哈,傻了吧 .就是要让你傻.";
	/**
	 * 默认字符串为utf-8
	 */
	private static String DEFAULT_CODING = "utf-8";

	/**
	 * 
	 * @Title: md5
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param buffer
	 * @param key
	 * @return
	 * @author 刘哈哈
	 * @date Jan 20, 2012
	 */
	public static byte[] md5(byte[] buffer, byte[] key) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(buffer);
			return md5.digest(key);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("md5异常", e);
		}
		return null;
	}

	/**
	 * 采用默认key和默认字符编码
	 * 
	 * @Title: md5
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param strSrc
	 * @return
	 * @author 刘哈哈
	 * @date Jan 20, 2012
	 */
	public static String md5(String strSrc) {
		return md5(strSrc, DEFAULT_KEY, DEFAULT_CODING);
	}

	/**
	 * 
	 * @Title: md5
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param strSrc
	 * @param key
	 * @return
	 * @author 刘哈哈
	 * @date Jan 20, 2012
	 */
	public static String md5(String strSrc, String key) {
		return md5(strSrc, key, DEFAULT_CODING);
	}

	/**
	 * 签名
	 * 
	 * @Title: md5
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param strSrc
	 * @param key
	 * @param encoding
	 * @return
	 * @author 刘哈哈
	 * @date Jan 20, 2012
	 */
	public static String md5(String strSrc, String key, String encoding) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSrc.getBytes(encoding));

			String result = "";
			byte[] temp = md5.digest(key.getBytes(encoding));
			for (int i = 0; i < temp.length; i++) {
				result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
			}
			return result;

		} catch (NoSuchAlgorithmException e) {
			LOG.error("md5异常", e);

		} catch (Exception e) {
			LOG.error("md5异常", e);
		}
		return null;
	}

	public static void main(String[] args) {
		String s="RFT_CUST_PAY_BILL1.01000000900EC201203021549http://61.134.115.206:8017/notify/receiveNotify.dohttp://61.134.115.206:8017/notify/receiveReturn.do易商通商品名称2012030206032010018220000A0B0C0D0E010202";
		// 这里的展示效果是说明采用密钥为1，对123456签名以及采用空密钥，对1234561签名的效果是一样的，都是aaa42296669b958c3cee6c0475c8093e
		System.out.println(md5(s, "0A0B0C0D0E010202"));
		System.out.println(md5("1234561", ""));
		
		System.out.println(md5("MERCHANTID=105150172990007&POSID=494806654&BRANCHID=150000000&AUTHID=1234567890&CURCODE=01&TXCODE=520105&UName=%C1%F5%D0%CB%BB%AA&IdType=01&IdNumber=430124198406132912&EPAYNO=6227000419910205587&OTHER1=&REMARK1=&REMARK2=&CLIENTIP=&REGINFO=&PROINFO=&PUB32=30819c300d06092a864886f70d0101", ""));
		System.out.println(md5("MERCHANTID=105150172990007&POSID=494806654&BRANCHID=150000000&AUTHID=1234567890&CURCODE=01&TXCODE=520105&UName=%C1%F5%D0%CB%BB%AA&IDTYPE=01&IdNumber=430124198406132912&EPAYNO=6227000419910205587&OTHER1=&REMARK1=&REMARK2=&CLIENTIP=&REGINFO=&PROINFO=&PUB32=30819c300d06092a864886f70d0101", ""));

		
	}

}
