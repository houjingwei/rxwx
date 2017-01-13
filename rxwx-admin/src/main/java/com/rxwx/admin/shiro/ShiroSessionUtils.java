package com.rxwx.admin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.rxwx.model.Admin;

public class ShiroSessionUtils {
	public static final String LOGIN_ATTRIVUTE_NAME = "login_admin_user";

	public static void setAttribute(Object key, Object value) {
		Subject account = SecurityUtils.getSubject();
		if (null != account) {
			Session session = account.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	public static Object getAttribute(Object key) {
		Subject account = SecurityUtils.getSubject();
		if (null != account) {
			Session session = account.getSession();
			if (null != session) {
				return session.getAttribute(key);
			}
		}
		return null;
	}

	public static Object removeAttribute(Object key) {
		Subject account = SecurityUtils.getSubject();
		if (null != account) {
			Session session = account.getSession();
			if (null != session) {
				return session.removeAttribute(key);
			}
		}
		return null;
	}

	public static boolean hasLogin() {
		return getAttribute(LOGIN_ATTRIVUTE_NAME) != null ? true : false;
	}


	public static Admin getLoginAccount() {
		return (Admin) getAttribute(LOGIN_ATTRIVUTE_NAME);
	}
	
	public static void setLoginAccount(Admin admin) {
		setAttribute(LOGIN_ATTRIVUTE_NAME, admin);
	}
}
