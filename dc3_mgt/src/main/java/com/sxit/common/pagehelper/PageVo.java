package com.sxit.common.pagehelper;

import java.io.Serializable;

public class PageVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7289925623459534820L;

	/**
	 * 是否本地翻页
	 */
	private boolean local;
	/**
	 * 页码
	 */
	private int page = 1;
	/**
	 * 页面大小
	 */
	private int pageSize = 10;

	/**
	 * 总条数
	 */
	private int total;

	public PageVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageVo(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(long total) {
		this.total = (int) total;
	}
	
	public void setCurrentPage(int currentPage)
	{
		this.page= currentPage;
	}

	public int getStartRecord() {
		if (page < 1) {
			page = 1;
		}
		return pageSize * (page - 1);
	}

}
