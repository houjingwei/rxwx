package com.rxwx.common.constants;

public class CacheConstants {

	

	// captch
	public final static String CACHE_KCAPTURE = "CKT:";

	///////////////////////
	// 用户登录
	public final static String CACHE_FRONT_USER_LOGIN = "USER:";
	
	// 用户信息
	public final static String CACHE_FRONT_USER_INFO = "USER:";
	
	// 获得验证码key
	public static String getKCapture(Object id) {
		return CACHE_KCAPTURE + id;
	}

	
	//用户登录key
	public static String getUserLogin(Object id) {
		return CACHE_FRONT_USER_LOGIN + id;
	}
	
	public static String getUserInfo(Object id) {
		return CACHE_FRONT_USER_INFO + id;
	}
	
}
