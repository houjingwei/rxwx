package com.rxwx.admin.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.rxwx.admin.shiro.ShiroSessionUtils;
import com.rxwx.model.Admin;
import com.rxwx.service.admin.AdminService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
		// (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			doClearCache(principals);
			SecurityUtils.getSubject().logout();
			return null;
		}
		System.out.println("进入授权了");
		String account = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(this.adminService.findRoles(account));
		authorizationInfo.setStringPermissions(this.adminService.findResources(account));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account = (String) token.getPrincipal();
		Admin admin = this.adminService.findByAccount(account);
		if (admin == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		System.out.println("authenticationinfo start ...");
		
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin.getAccount(), // 用户名
				admin.getPassword(), // 密码
				getName() // realm name
		);
		ShiroSessionUtils.setLoginAccount(admin);
		System.out.println("authenticationinfo end ...");

		// 登陆成功，将用户存入session
		ShiroSessionUtils.setLoginAccount(admin);

		/**
		 * 关闭浏览器，再打开后，虽然授权缓存了，但是认证是必须的，在认证成功后，清除之前的缓存。
		 */
		clearCache(authenticationInfo.getPrincipals());

		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
