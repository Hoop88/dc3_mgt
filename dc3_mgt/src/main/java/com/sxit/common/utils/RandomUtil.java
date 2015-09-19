package com.sxit.common.utils;

import java.util.Random;

/**
 * 通用工具类
 * @author wuym
 */
public class RandomUtil {

	/**
	 * 获得a位到b位
	 * 数的随机码(包括数字和字母)
	 * isConLetterswei为false，则只
	 * 能为数字，为true，则包含数字和字母
	 */
	public static String getAToBRandom(int a, int b, boolean isConLetters) {
		StringBuffer backSb = new StringBuffer();
		// 数字
		StringBuffer sb = new StringBuffer("1234567890");
		if (isConLetters) {
			// 字母
			sb.append("ABCDEFGHIJKLMNOPQRSTUVWXVYabcdefghijklmnopqrstuvwxyz");
		}
		Random randCount = new Random();
		int spec = a + randCount.nextInt(b - a > 0 ? b - a : 0);
		int rdm = 0;
		char str = 0;
		for (int i = 0 ; i < spec; i++) {
			rdm = randCount.nextInt(sb.toString().length());
			str = sb.toString().charAt(rdm);
			backSb.append(str);
		}
		
		return backSb.toString();
	}
	
	/**
	 * 获得a位数的数字随机码
	 */
	public static Long getNumRandom(int a) {
		Random randCount = new Random();
		StringBuffer backSb = new StringBuffer();
		// 生成第一位
		backSb.append(randCount.nextInt(8) + 1);
		StringBuffer sb = new StringBuffer("123456789");
		int rdm = 0;
		char str = 0;
		// 生成后面的a - 1位
		for(int i = 0 ; i < (a - 1); i++){
			rdm = randCount.nextInt(sb.toString().length());
			str = sb.toString().charAt(rdm);
			backSb.append(str);
		}
		
		return Long.valueOf(backSb.toString());
	}
}


