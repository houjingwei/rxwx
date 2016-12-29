package com.rxwx.model;

public class AdminRole extends BaseModel {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9129473423647551809L;
	private Integer id;
	private Integer adminId;
	private Integer roleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	
}
