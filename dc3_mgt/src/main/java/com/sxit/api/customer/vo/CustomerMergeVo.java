package com.sxit.api.customer.vo;

import java.util.ArrayList;
import java.util.List;

public class CustomerMergeVo {

	private String newCstGUID;
	private String newMemGUID;
	private List oldCstGUIDList;

	public CustomerMergeVo() {
		super();
		oldCstGUIDList = new ArrayList();
	}

	public CustomerMergeVo(String newCstGUID, String newMemGUID,
			List oldCstGUIDList) {
		super();
		this.newCstGUID = newCstGUID;
		this.newMemGUID = newMemGUID;
		this.oldCstGUIDList = oldCstGUIDList;
	}

	public String getNewCstGUID() {
		return newCstGUID;
	}

	public void setNewCstGUID(String newCstGUID) {
		this.newCstGUID = newCstGUID;
	}

	public String getNewMemGUID() {
		return newMemGUID;
	}

	public void setNewMemGUID(String newMemGUID) {
		this.newMemGUID = newMemGUID;
	}

	public List getOldCstGUIDList() {
		return oldCstGUIDList;
	}

	public void setOldCstGUIDList(List oldCstGUIDList) {
		this.oldCstGUIDList = oldCstGUIDList;
	}
	
	public void addOldCstGUID(String cstGuid){
		oldCstGUIDList.add(cstGuid);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
