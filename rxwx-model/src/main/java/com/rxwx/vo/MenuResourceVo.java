package com.rxwx.vo;

import java.io.Serializable;
import java.util.List;

import com.rxwx.model.Resource;

public class MenuResourceVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1113449218184241937L;
	
	private Integer menuId;
	private String menuName;
	private List<Resource> resList;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public List<Resource> getResList() {
		return resList;
	}
	public void setResList(List<Resource> resList) {
		this.resList = resList;
	}
	
}
