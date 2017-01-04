package com.rxwx.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysMenuVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3740447127277895888L;
	
	private Integer id;
	private String name;
	private String code;
	private String type;
	private String url;
	private Integer pid;
	private Integer order;
	private Date createTime;
	private Integer status;
	
	private List<ResMenuVo> resMenuVoList;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public List<ResMenuVo> getResMenuVoList() {
		return resMenuVoList;
	}

	public void setResMenuVoList(List<ResMenuVo> resMenuVoList) {
		this.resMenuVoList = resMenuVoList;
	}
	

}
