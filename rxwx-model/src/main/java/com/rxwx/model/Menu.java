package com.rxwx.model;

import java.util.Date;

public class Menu extends BaseModel {

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5860536279483556846L;
	
	private Integer id;
	private String name;
	private Date createTime;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
