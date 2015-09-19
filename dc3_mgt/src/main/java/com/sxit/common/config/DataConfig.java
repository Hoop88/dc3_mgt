package com.sxit.common.config;

public class DataConfig {

	public static String handSex(String value){
		if("男".equals(value)){
			value = "1001";
        }else if("女".equals(value)){
        	value = "1002";
        }else{
        	value = "0";
        }
		return value;
	}
	
	public static String switchSex(int key){
		String str = "";
		switch (key) {
		case 1001:
			str = "男";
			 break;
		case 1002:
			str = "女";
			break;
		default:
			str = "未知";
			break;
		}
		return str;
	}
	
	public static String handNation(String value){
		if("汉族".equals(value)){
			value = "1";
        }else if("回族".equals(value)){
        	value = "2";
        }else if("满族".equals(value)){
        	value = "3";
        }else if("蒙古族".equals(value)){
        	value = "4";
        }else{
        	value = "0";
        }
		return value;
	}
	
	public static String switchNation(int key){
		String str = "";
		switch (key) {
		case 1:
			str = "汉族";
			 break;
		case 2:
			str = "回族";
			break;
		case 3:
			str = "满族";
			break;
		case 4:
			str = "蒙古族";
			break;
		default:
			str = "无";
			break;
		}
		return str;
	}
	
	public static String handXueli(String value){
		if("小学".equals(value)){
			value = "1";
        }else if("初中".equals(value)){
        	value = "2";
        }else if("中专".equals(value)){
        	value = "3";
        }else if("高中".equals(value)){
        	value = "4";
        }else if("大专".equals(value)){
        	value = "5";
        }else if("大本".equals(value)){
        	value = "6";
        }else if("研究生".equals(value)){
        	value = "7";
        }else if("博士".equals(value)){
        	value = "8";
        }else{
        	value = "0";
        }
		return value;
	}
	
	public static String switchXueli(int key){
		String str = "";
		switch (key) {
		case 1:
			str = "小学";
			 break;
		case 2:
			str = "初中";
			break;
		case 3:
			str = "中专";
			break;
		case 4:
			str = "高中";
			break;
		case 5:
			str = "大专";
			break;
		case 6:
			str = "大本";
			break;
		case 7:
			str = "研究生";
			break;
		case 8:
			str = "博士";
			break;
		default:
			str = "无";
			break;
		}
		return str;
	}
	
	public static String handZhiwu(String value){
		if("学生".equals(value)){
			value = "1";
        }else if("员工".equals(value)){
        	value = "2";
        }else if("管理人员".equals(value)){
        	value = "3";
        }else{
        	value = "0";
        }
		return value;
	}
	
	public static String switchZhiwu(int key){
		String str = "";
		switch (key) {
		case 1:
			str = "学生";
			 break;
		case 2:
			str = "员工";
			break;
		case 3:
			str = "管理人员";
			break;
		default:
			str = "无";
			break;
		}
		return str;
	}
	
	public static String handCertificateType(String value){
		if("身份证".equals(value)){
			value = "1";
        }else if("军人证".equals(value)){
        	value = "2";
        }else if("驾驶证".equals(value)){
        	value = "3";
        }else if("退休证".equals(value)){
        	value = "4";
        }else{
        	value = "0";
        }
		return value;
	}
	
	public static String switchCertificateType(int key){
		String str = "";
		switch (key) {
		case 1:
			str = "身份证";
			 break;
		case 2:
			str = "军人证";
			break;
		case 3:
			str = "驾驶证";
			break;
		case 4:
			str = "退休证";
			break;
		default:
			str = "无";
			break;
		}
		return str;
	}
	
	public static String handMemberSrc(String value){
		if("微信".equals(value)){
			value = "2";
        }else if("微博".equals(value)){
        	value = "3";
        }else{
        	value = "1";
        }
		return value;
	}
	
	public static String switchMemberSrc(int key){
		String str = "";
		switch (key) {
		case 1:
			str = "店铺";
			 break;
		case 2:
			str = "微信";
			break;
		case 3:
			str = "微博";
			break;
		default:
			str = "店铺";
			break;
		}
		return str;
	}
	
	public static String switchMemberType(int key){
		String str = "";
		switch (key) {
		case 0:
			str = "电子会员";
			 break;
		case 1:
			str = "非电子会员";
			break;
		default:
			str = "非电子会员";
			break;
		}
		return str;
	}
}
