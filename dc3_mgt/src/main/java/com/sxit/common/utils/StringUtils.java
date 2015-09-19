package com.sxit.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class StringUtils {

	private static DecimalFormat df = new DecimalFormat("#.0");

	/**
	 * 验证字符串是否为空
	 * @param str 字符串
	 * @return true 空 false 非空
	 * @see 必须先初始化微博对象后才能调用此方法
	 */
	public static boolean isEmpty(String str) {
		if (null == str) {
			return true;
		} else if ("".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证字符串是否为空
	 * @param str 字符串
	 * @see 必须先初始化微博对象后才能调用此方法
	 * @return true 空 false 非空
	 */
	public static boolean isNotEmpty(String str) {
		if (null == str) {
			return false;
		} else if ("".equals(str)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断指定的字符串是否为数字
	 * @param str 字符串
	 * @return boolean
	 */
	public static boolean isNum(String str) {
		String regex = "9";
		if (str == null)
			return false;
		if (str.length() == 0)
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (regex.indexOf(str.charAt(i)) == -1)
				return false;
		}
		return true;
	}

	/**
	 * 把字符串中的带‘与"转成\'与\"
	 * @param orgStr
	 * @return
	 */
	public static String convertQuot(String orgStr) {
		return orgStr.replace("'", "\\'").replace("\"", "\\\"");
	}

	/**
	 * 把字符串中的带.与"转成\
	 * @param orgStr
	 * @return
	 */
	public static String convertPoint(String orgStr) {
		return orgStr.replace(".", "\\").replace(";", "\\");
	}

	/**
	 * 把字符串中的带_与"转成空字符串
	 * @param orgStr
	 * @return
	 */
	public static String convertUnderLine(String orgStr) {
		return orgStr.replace("_", "");
	}

	/**
	 * HTML实体编码转成普通的编码
	 * @param dataStr
	 * @return
	 */
	public static String htmlEntityToString(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			int system = 10;// 进制
			if (start == 0) {
				int t = dataStr.indexOf("&#");
				if (start != t)
					start = t;
			}
			end = dataStr.indexOf(";", start + 2);
			String charStr = "";
			if (end != -1) {
				charStr = dataStr.substring(start + 2, end);
				// 判断进制
				char s = charStr.charAt(0);
				if (s == 'x' || s == 'X') {
					system = 16;
					charStr = charStr.substring(1);
				}
			}
			// 转换
			try {
				char letter = (char) Integer.parseInt(charStr, system);
				buffer.append(new Character(letter).toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			// 处理当前unicode字符到下一个unicode字符之间的非unicode字符
			start = dataStr.indexOf("&#", end);
			if (start - end > 1) {
				buffer.append(dataStr.substring(end + 1, start));
			}
			// 处理最后面的非unicode字符
			if (start == -1) {
				int length = dataStr.length();
				if (end + 1 != length) {
					buffer.append(dataStr.substring(end + 1, length));
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * 把String转成html实体字符
	 * @param str
	 * @return
	 */
	public static String stringToHtmlEntity(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 0x0A:
				sb.append(c);
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			default:
				if ((c < ' ') || (c > 0x7E)) {
					sb.append("&#x");
					sb.append(Integer.toString(c, 16));
					sb.append(';');
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 转UNICODE
	 * @param str
	 * @return
	 */
	public static String stringToUnicode(String s) {
		String unicode = "";
		char[] charAry = new char[s.length()];
		for (int i = 0; i < charAry.length; i++) {
			charAry[i] = (char) s.charAt(i);
			unicode += "\\u" + Integer.toString(charAry[i], 16);
		}
		return unicode;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String unicodeToString(String unicodeStr) {
		StringBuffer sb = new StringBuffer();
		String str[] = unicodeStr.toUpperCase().split("\\\\U");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			char c = (char) Integer.parseInt(str[i].trim(), 16);
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String html2Text(String inputString) {
		// 含html标签的字符串
		String htmlStr = inputString;
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script>]*?>[\s\S]*?<\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style>]*?>[\s\S]*?<\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = java.util.regex.Pattern.compile(regEx_script,
					java.util.regex.Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = java.util.regex.Pattern.compile(regEx_style,
					java.util.regex.Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = java.util.regex.Pattern.compile(regEx_html,
					java.util.regex.Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * escape编码
	 * @param src
	 * @return
	 */
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String formatDou2Str(Double d) {
		if (d == null) {
			return "0";
		}
		return df.format(d);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeStr(String encodeparam) {
		try {
			if (encodeparam == null || "".equalsIgnoreCase(encodeparam)) {
				return null;
			}
			return java.net.URLDecoder.decode(encodeparam, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 字段首字母大写并把_去掉
	 * @param str
	 * @return
	 */
	public static String initialStrToUpper(String str) {
		String[] strArray = str.toLowerCase().split("_");
		String tranColumn = "";
		for (int i = 0; i < strArray.length; i++) {
			tranColumn = tranColumn
					+ strArray[i].substring(0, 1).toUpperCase()
					+ strArray[i].substring(1);
		}

		return tranColumn;
	}

	/**
	 * 字段转换成Java属性
	 * @param str
	 * @return
	 */
	public static String initialStrToTran(String str) {
		String[] strArray = str.toLowerCase().split("_");
		String tranColumn = "";
		for (int i = 0; i < strArray.length; i++) {
			if (i == 0) {
				tranColumn = tranColumn + strArray[i];
			} else {
				tranColumn = tranColumn
						+ strArray[i].substring(0, 1).toUpperCase()
						+ strArray[i].substring(1);
			}
		}

		return tranColumn;
	}
	
	/**
	 * 字符串的首字母变成小写
	 * @param str
	 * @return
	 */
	public static String strToLower(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
	
	/**
	 * 字符串的首字母变成大写
	 * @param str
	 * @return
	 */
	public static String strToUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * 字符串的所有字母变成小写
	 * @param str
	 * @return
	 */
	public static String strToAllLower(String str) {
		return str.toLowerCase();
	}

	/**
	 * 替换斜杠
	 * @param str
	 * @return
	 */
	public static String replaceSlash(String str) {
		String result = str.replaceAll("//", ".");
		result = result.replaceAll("/", ".");
		result = result.replaceAll("\\\\", ".");
		return result;
	}

	/**
	 * 是否加“.”
	 * @param str
	 * @param addStr
	 * @return
	 */
	public static String addPoint(String str, String addStr) {
		String result = str;
		if (str.endsWith(".")) {
			result += addStr;
		} else {
			result += "." + addStr;
		}
		return result;
	}
	
	/**
	 * 字符串里某个字符的出现次数
	 * @param str
	 * @param compareStr
	 * @return
	 */
	public static int countStr(String str,String compareStr) {
		int count=0;
		while( str.indexOf(compareStr)!=-1){
			count++;
			int i = str.indexOf(compareStr);
			str = str.substring(i+compareStr.length());
		}
		return count;
	}
	
	/**
	 * 验证是否是邮箱
	 */
	public static boolean isEmail(String str){
		if(!str.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})$")){
			return false;
		}
		return true;
	}
	
	/**
	 * 验证是否是座机号
	 */
	public static boolean isPhone(String str){
		if(!str.matches("^([0-9]{3}-?[0-9]{7})|([0-9]{3}-?[0-9]{8})|([0-9]{4}-?[0-9]{7})|([0-9]{4}-?[0-9]{8})|([0-9]{8})|([0-9]{7})$")){
			return false;
		}
		return true;
	}
	
	/**
	 * 验证是否是手机号
	 */
	public static boolean isMobile(String str){
		if(!str.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(18[0-9]))\\d{8}$")){
			return false;
		}
		return true;
	}
	
	/**
	 * 字符串长度
	 * @param str
	 * @return
	 */
	public static int strLength(String str) {
		int strLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(chinese)) {
            	strLength += 2;
            } else {
            	strLength += 1;
            }
        }
        return strLength;
	}
	
	/**
	 * 检查配置的本地路径格式是否正确
	 * @param webPath
	 * @return
	 */
	public static String checkWebPath(String webPath) {
		String first = webPath.substring(0, 1);
		if (!"/".equals(first)) {
			webPath = "/" + webPath;
		}
		String last = webPath.substring(webPath.length() - 1, webPath.length());
		if (!"/".equals(last)) {
			webPath = webPath + "/";
		}
		return webPath;
	}
	
}
