package com.rxwx.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BaseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855494805210154174L;

	private String token = null; //

	private String queryStartTime = null;
	private String queryEndTime = null;

	private List<Long> queryUserIds = null;
	private List<Long> queryIds = null;
	private List<String> queryStatus = null;
	private List<String> queryNames = null;

	private String uuidKey = null;

	//////////////////////////////////

	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Field> fieldlist = new ArrayList<Field>();
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = this.getClass();
			while (!BaseVo.class
					.equals(clazz) /*
									 * !clazz.getName().endsWith( "Object")
									 */) {
				Field[] fieldArray = clazz.getDeclaredFields();
				for (int i = 0; i < fieldArray.length; i++) {
					if ("serialVersionUID".equals(fieldArray[i].getName()) || "log".equals(fieldArray[i].getName())) {
						continue;
					}

					fieldlist.add(fieldArray[i]);
				}
				clazz = clazz.getSuperclass();
			}

			sb.append('[').append(this.getClass()).append(']');
			sb.append('[');

			final int endCount = fieldlist.size() - 1;
			for (int i = 0; i < fieldlist.size(); i++) {
				fieldlist.get(i).setAccessible(true);
				sb.append(fieldlist.get(i).getName());
				sb.append(" = ");
				sb.append(fieldlist.get(i).get(this));
				if (i != endCount) {
					sb.append(" , ");
				}
			}
			sb.append(']');
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	/////////////////////////////////

	public String getQueryStartTime() {
		return this.queryStartTime;
	}

	public void setQueryStartTime(String queryStartTime) {
		this.queryStartTime = queryStartTime;
	}

	public String getQueryEndTime() {
		return this.queryEndTime;
	}

	public void setQueryEndTime(String queryEndTime) {
		this.queryEndTime = queryEndTime;
	}

	public List<Long> getQueryUserIds() {
		return this.queryUserIds;
	}

	public void setQueryUserIds(List<Long> queryUserIds) {
		this.queryUserIds = queryUserIds;
	}

	public List<Long> getQueryIds() {
		return this.queryIds;
	}

	public void setQueryIds(List<Long> queryIds) {
		this.queryIds = queryIds;
	}

	public List<String> getQueryStatus() {
		return this.queryStatus;
	}

	public void setQueryStatus(List<String> queryStatus) {
		this.queryStatus = queryStatus;
	}

	public void addQueryUserIds(Long userId) {
		if (null == this.queryUserIds) {
			this.queryUserIds = new ArrayList<Long>();
		}

		this.queryUserIds.add(userId);
	}

	public void addQueryIds(Long id) {
		if (null == this.queryIds) {
			this.queryIds = new ArrayList<Long>();
		}

		this.queryIds.add(id);
	}

	public void addQueryStatus(String status) {
		if (null == this.queryStatus) {
			this.queryStatus = new ArrayList<String>();
		}

		this.queryStatus.add(status);
	}

	public List<String> getQueryNames() {
		return this.queryNames;
	}

	public void setQueryNames(List<String> queryNames) {
		this.queryNames = queryNames;
	}

	public void addQueryNames(String name) {
		if (null == this.queryNames) {
			this.queryNames = new ArrayList<String>();
		}

		this.queryNames.add(name);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUuidKey() {
		return uuidKey;
	}

	public void setUuidKey(String uuidKey) {
		this.uuidKey = uuidKey;
	}
}
