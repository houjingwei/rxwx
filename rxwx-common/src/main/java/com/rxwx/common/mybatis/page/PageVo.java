package com.rxwx.common.mybatis.page;


import java.io.Serializable;
import java.util.List;


/**
 * 
 * @author hjw
 *
 * @param <T>
 */
public class PageVo<T> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 358464585025542343L;

	private Paginator paginator;

	private List<T> list;

	private int size;

	public PageVo()
	{}
	
	public PageVo(PageList<T> pageList)
	{
		this.paginator = pageList.getPaginator();
		this.size = pageList.size();

		this.list = pageList.subList(0, pageList.size());
	}

	public Paginator getPaginator()
	{
		return this.paginator;
	}

	public List<T> getList()
	{
		return this.list;
	}

	public int getSize()
	{
		return this.size;
	}

	public int size()
	{
		return this.size;
	}
}
