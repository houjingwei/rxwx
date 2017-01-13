package com.rxwx.admin.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController{
	
	

	@RequestMapping(value = "/index")
	@RequiresAuthentication
	public String index(Map map) {
		System.out.println("hasRole fuck :" +SecurityUtils.getSubject().hasRole("fuck"));
		return super.showView(map,"index");
	}
	
	@RequestMapping(value = "/empty")
	@RequiresAuthentication
	public String empty(Map map) {
		return super.showView(map,"empty_page");
	}

}
