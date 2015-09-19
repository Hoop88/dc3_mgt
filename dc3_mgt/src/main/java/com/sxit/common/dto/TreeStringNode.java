package com.sxit.common.dto;

import java.util.ArrayList;
import java.util.List;

import com.sxit.mgt.system.dto.Node;

public class TreeStringNode {
	private String id;
	private String name;
	private String code;
	private String parentId;
	private List<TreeStringNode> children;

	public TreeStringNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeStringNode(String id, String name, String parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return name;
	}

	public void setText(String text) {
		this.name = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<TreeStringNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeStringNode> children) {
		this.children = children;
	}

	/**
	 * 构建树
	 * 
	 * @param list
	 * @return
	 */
	public static List<TreeStringNode> buildTree(List<TreeStringNode> list) {
		List<TreeStringNode> nodeList = new ArrayList<TreeStringNode>();
		for (TreeStringNode node1 : list) {
			boolean mark = false;
			for (TreeStringNode node2 : list) {
				if (node1.getParentId() != null
						&& node1.getParentId().equals(node2.getId())) {
					mark = true;
					if (node2.getChildren() == null)
						node2.setChildren(new ArrayList<TreeStringNode>());
					node2.getChildren().add(node1);
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return nodeList;
	}

	public void addChild(TreeStringNode child) {
		if (children == null) {
			children = new ArrayList<TreeStringNode>();
		}
		children.add(child);
	}
}
