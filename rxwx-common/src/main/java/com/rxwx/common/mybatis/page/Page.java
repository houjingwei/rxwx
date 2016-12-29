package com.rxwx.common.mybatis.page;

import com.rxwx.common.constants.Constants;

/**
 * 
 * @author hjw
 *
 */
public class Page extends PageBounds {

	private static final long serialVersionUID = 7740871206924072607L;
	private int totalPage = 0;
	private int totalCount = 0;
	private Paginator paginator;

	public Page(Integer page,Integer pageSize){
		if(page==null){
			page=0;
		}
		if(pageSize==null){
			pageSize=Constants.PAGE_SIZE;
		}
		super.setPage(page);
		super.setLimit(pageSize);
	}
	
	public Page(Integer page,Integer pageSize, boolean sc){
		this(page, pageSize);
		this.setContainsTotalCount(sc);
	}

	public Page(Integer page){
		if(page==null){
			page=0;
		}
		super.setPage(page);
		super.setLimit(Constants.PAGE_SIZE);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
		if (null != paginator) {
			setTotalCount(paginator.getTotalCount());
			setTotalPage(paginator.getTotalPages());
		}
	}

}