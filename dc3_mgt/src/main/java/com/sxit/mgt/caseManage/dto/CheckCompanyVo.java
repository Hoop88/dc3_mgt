package com.sxit.mgt.caseManage.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sxit.model.common.CheckBoxVo;

public class CheckCompanyVo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3162842189137956753L;

	private Long id;

	private String name;

	private String code;

	private boolean checked = false;

	public CheckCompanyVo() {
		super();
		// Auto-generated constructor stub
	}

	public CheckCompanyVo(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

	/**
	 * 应用已有的值
	 * 
	 * @param clist
	 * @param ilist
	 * @return
	 */
	public static List<CheckBoxVo> applyCheckboxList(List<CheckBoxVo> clist,
			List<Long> ilist) {
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
	 * 
	 * @param newList
	 * @return
	 */
	public static List<CheckCompanyVo> getCheckedList(List<CheckCompanyVo> newList) {
		List<CheckCompanyVo> tempList = new ArrayList();

		for (CheckCompanyVo cb : newList) {
			if (cb.isChecked() && StringUtils.isNotBlank(cb.getCode())) {
				tempList.add(cb);
			}

		}
		return tempList;
	}

}
