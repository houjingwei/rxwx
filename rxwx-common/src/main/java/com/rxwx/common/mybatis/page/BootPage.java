package com.rxwx.common.mybatis.page;

import java.io.Serializable;
import java.util.List;

public class BootPage<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9145438643374500712L;

	private Long total;

	private List<T> rows;

	private int pageNum = 0;

	private int pageSize = 1;


	public BootPage(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public BootPage() {
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}