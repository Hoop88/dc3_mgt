package com.sxit.mgt.system.dto;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private Integer id;
	private String text;
	private Integer parentId;
	private List<Node> children;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(Integer id, String text, Integer parentId) {
		super();
		this.id = id;
		this.text = text;
		this.parentId = parentId;
	}

	public Node(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Node(Integer id, String text, List<Node> children) {
		super();
		this.id = id;
		this.text = text;
		this.children = children;
	}

	public void addChild(Node child) {
		if (children == null) {
			children = new ArrayList<Node>();
		}
		children.add(child);
	}

	/**
	 * 构建树
	 * 
	 * @param list
	 * @return
	 */
	public static List<Node> buildTree(List<Node> list) {
		List<Node> nodelist = new ArrayList<Node>();
		for (Node node : list) {
			if (node.getParentId() == null || 0 == node.getParentId()) {
				node.buildNode(list);
				nodelist.add(node);
			}
		}
		return nodelist;
	}

	/**
	 * 构建一个节点
	 * 
	 * @param list
	 */
	public void buildNode(List<Node> list) {
		List<Node> nodelist = new ArrayList<Node>();

		for (Node node : list) {
			if (this.id == node.getParentId()) {
				node.buildNode(list);
				nodelist.add(node);
			}
		}
		children = nodelist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
}
