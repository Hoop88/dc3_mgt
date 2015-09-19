package com.sxit.mgt.system.dto;

import java.util.List;

public class TreeNode {
	private String ids = "";
	private List<TreeNode> nodes;
	private String id= "";
	private String pId = "";
	private String name = "";
	private boolean open = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String id) {
		pId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<TreeNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeNode> nodes) {
		this.nodes = nodes;
	}
}
