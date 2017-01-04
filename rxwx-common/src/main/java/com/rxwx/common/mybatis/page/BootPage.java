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

	private int limit = 0;

	private int offset = 1;

	private String order = "asc";

	public BootPage(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}