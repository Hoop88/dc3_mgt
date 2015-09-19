package com.sxit.common.entity;

/**
 * 性别
 * @author mhpi
 *
 */
public enum GenderType {
	m(1, "男", "先生"), g(2, "女", "女士");

	private int value;
	private String name;
	private String name2;

	private GenderType(int value, String name, String name2) {
		this.value = value;
		this.name = name;
		this.name2 = name2;
	}

	public static GenderType getGenderType(int value) {
		for (GenderType type : GenderType.values()) {
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

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
}
