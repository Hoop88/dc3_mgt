package com.sxit.common.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sxit.common.pagehelper.Page;

public class ResultMessage {

	private Header header;

	private Object data;

	public ResultMessage() {
		super();
		// Auto-generated constructor stub
	}

	public ResultMessage(Header header, Object data) {
		super();
		this.header = header;
		this.data = data;
	}

	public ResultMessage(Header header) {
		super();
		this.header = header;
	}

	public ResultMessage(int code, String message) {
		super();
		this.header = new Header(code, message);
	}

	public ResultMessage(int code, String message, Object data) {
		super();
		this.header = new Header(code, message);
		this.data = data;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 返回成功 不带数据
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultMessage successMsg(String msg) {
		return new ResultMessage(0, msg);
	}

	/**
	 * 返回成功 带数据
	 * 
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResultMessage successMsg(String msg, Object data) {
		return new ResultMessage(0, msg, data);
	}

	/**
	 * 返回分页数据
	 * 
	 * @param page
	 * @return
	 */
	public static ResultMessage successPage(Page page) {
		Map map = new HashMap();
		SimplePage sp = new SimplePage(page);
		map.put("page", sp);
		map.put("list", (List) page);
		return new ResultMessage(0, "ok", map);
	}

	/**
	 * 返回错误
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultMessage errorMsg(String msg) {
		return new ResultMessage(-1, msg);
	}

	/**
	 * 返回带code错误
	 * 
	 * @param msg
	 * @param code
	 * @return
	 */
	public static ResultMessage errorMsg(String msg, int code) {
		return new ResultMessage(code, msg);
	}

}

class SimplePage {

	private Long pageCount; // 页数
	private Long currentPage; // 当前页
	private Long pageSize; // 一页的记录数
	private Long recordCount; // 记录总数

	public SimplePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimplePage(Page page) {
		super();
		pageCount = page.getPages() + 0l;
		currentPage = page.getPageNum() + 0l;
		pageSize = page.getPageSize() + 0l;
		recordCount = page.getTotal();
		// TODO Auto-generated constructor stub
	}

	public SimplePage(Long pageCount, Long currentPage, Long pageSize,
			Long recordCount) {
		super();
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

}
