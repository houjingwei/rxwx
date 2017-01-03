package com.rxwx.model;

import java.util.Date;

public class Role extends BaseModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1678817863429128653L;
	private Integer id;
	private String name;
	private String description;
	private Integer order;
	private Date createTime;
	private Integer status;
	
	public Role(int id) {
		this.id = id;
	}
	
	public Role() {
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
