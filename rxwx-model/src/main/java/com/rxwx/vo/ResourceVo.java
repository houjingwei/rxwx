package com.rxwx.vo;

import java.io.Serializable;

public class ResourceVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6714826058765487077L;
	private Integer resourceId;
	private String resName;
	private String resDesc;
	private String url;
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResDesc() {
		return resDesc;
	}
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
