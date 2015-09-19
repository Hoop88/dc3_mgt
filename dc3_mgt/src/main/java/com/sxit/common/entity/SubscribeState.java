package com.sxit.common.entity;

/**
 * 性别
 * 
 * @author mhpi
 * 
 */
public enum SubscribeState {
	y(1, "取消关注"), n(0, "已关注");

	private int value;
	private String name;

	private SubscribeState(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static SubscribeState getGenderType(int value) {
		for (SubscribeState type : SubscribeState.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
