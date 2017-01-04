package com.rxwx.admin.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rxwx.admin.shiro.ShiroSessionUtils;
import com.rxwx.model.Admin;
import com.rxwx.service.admin.AdminService;
import com.rxwx.service.admin.ResourceService;
import com.rxwx.vo.SysMenuVo;


public class BaseController {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired AdminService adminService;
	@Autowired ResourceService resourceService;

	public String showView(Map map, String view) {
		Admin admin = ShiroSessionUtils.getLoginAccount();
		List<SysMenuVo> menuList = resourceService.findMenu();
		Set<String> roles = adminService.findRoles(admin.getAccount());
		map.put("roles",new ArrayList<String>(roles));
		map.put("menus", menuList);
		map.put("admin", admin);
		return view;
	}
}
