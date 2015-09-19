package com.sxit.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxVo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3162842289137956753L;

	private Integer id;

	private String name;

	private boolean checked = false;

	public CheckBoxVo() {
		super();
		// Auto-generated constructor stub
	}

	public CheckBoxVo(Integer id, String name, boolean checked) {
		super();
		this.id = id;
		this.name = name;
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 应用已有的值
	 * 
	 * @param clist
	 * @param ilist
	 * @return
	 */
	public static List<CheckBoxVo> applyCheckboxList(List<CheckBoxVo> clist,
			List<Integer> ilist) {
		for (CheckBoxVo cb : clist) {
			if (ilist.contains(cb.getId())) {
				cb.setChecked(true);
			} else {
				cb.setChecked(false);
			}
		}
		return clist;
	}

	/**
	 * 获取添加的id
	 * 
	 * @param oldList
	 * @param newList
	 * @return
	 */
	public static List<Integer> getAddList(List<Integer> oldList,
			List<CheckBoxVo> newList) {
		List<Integer> tempList = getCheckedList(newList);

		tempList.removeAll(oldList);

		return tempList;
	}

	/**
	 * 获取删除id
	 * 
	 * @param oldList
	 * @param newList
	 * @return
	 */
	public static List<Integer> getDeleteList(List<Integer> oldList,
			List<CheckBoxVo> newList) {
		List<Integer> tempList = getCheckedList(newList);

		List<Integer> deleteList = new ArrayList(oldList);

		deleteList.removeAll(tempList);

		return deleteList;
	}

	public static List<Integer> getCheckedList(List<CheckBoxVo> newList) {
		List<Integer> tempList = new ArrayList();

		for (CheckBoxVo cb : newList) {
			if (cb.checked) {
				tempList.add(cb.getId());
			}

		}
		return tempList;
	}

}
