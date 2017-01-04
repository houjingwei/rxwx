package com.rxwx.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rxwx.admin.shiro.ShiroSessionUtils;
import com.rxwx.model.Admin;
import com.rxwx.service.admin.AdminService;
import com.rxwx.service.admin.MenuResourceService;
import com.rxwx.vo.MenuResourceVo;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired MenuResourceService menuResourceService;
	@Autowired AdminService adminService;

	@RequestMapping(value = "/index")
	@RequiresAuthentication
	public String index(Map map) {
		Admin admin = ShiroSessionUtils.getLoginAccount();
		List<MenuResourceVo> menuList = menuResourceService.userMenuList(admin.getId());
		Set<String> roles = adminService.findRoles(admin.getAccount());
		map.put("roles",new ArrayList<String>(roles));
		map.put("resources", menuList);
		map.put("admin", admin);
		return "index";
	}
}
