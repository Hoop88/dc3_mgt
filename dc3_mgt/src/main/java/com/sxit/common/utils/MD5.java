package com.sxit.common.utils;

import java.security.*;

/**
 * MD5加密算法 用于用户密码的加密
 */
public class MD5 {
	private static String seed = "你能破解么,我就不信了,哈哈,傻了吧 .就是要让你傻.";

	// 加密函数
	public static String md5(String s) {
		try {
			String temp = s + seed;
			byte[] strTemp = temp.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			return byte2hex(md);
		} catch (Exception e) {
			return null;
		}
	}

	// 二进制转字符串
	public final static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
				// if (n<b.length-1) hs=hs+":";
			}
		}
		return hs.toUpperCase();
	}

	// 验证函数
	public final static boolean isEquale(String pass, String key) { // 二行制转字符串
		try {
			byte[] strTemp = pass.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			String str = byte2hex(md);
			return key.equals(str);
		} catch (Exception e) {
			return false;
		}
	}

	// 测试
	public static void main(String[] args) {
			MD5 md5=new MD5();
		 System.out.println("qweqwe="+md5.md5("qweqwe"));
		 System.out.println("123456="+md5.md5("123456"));

	}

}
