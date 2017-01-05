package com.rxwx.common.exception;

public enum CustomExceptionEnum {
	// 系统异常-1至100
		ERROR_SYSTEM(1, "系统异常"),
		ERROR_DATA(2, "数据异常"),
		COMMON_WRONG_PARAMS(3, "参数不全"),
		COMMON_ERROR_TOKEN(4, "token无效。"),
		COMMON_DB_ERRORS(5, "操作失败，请重试或联系客服人员。"),
		LOGIN_USER_STAUTS_ERROR(6, "操作失败，用户状态异常。"), 
		USER_STAUTS_ERROR(7, "操作失败，用户状态异常。"), 
		LOGIN_USER_PSW_ERROR(8, "操作失败，密码错误。"), 

		// 缓存异常100至200
		CACHE_ERROR(100, "缓存组件异常"),

		// 业务异常 300至1000
		USER_NOT_EXIST(300, "用户不存在"), 
		EXC_CACHE_ERROR(100, "缓存组件异常");
	

	/**
	 * 错误码
	 */
	private int code;

	/**
	 * 错误信息
	 */
	private String msg;

	/**
	 * 扩展信息
	 */
	private String extend;

	private CustomExceptionEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		if (extend != null && !"".equals(extend)) {
			return msg + "," + extend;
		} else {
			return msg;
		}
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}
}
