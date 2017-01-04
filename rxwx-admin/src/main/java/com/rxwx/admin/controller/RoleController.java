package com.rxwx.admin.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.container.page.Page;
import com.alibaba.fastjson.JSONObject;
import com.rxwx.common.exception.CustomException;
import com.rxwx.common.mybatis.page.BootPage;
import com.rxwx.model.Role;
import com.rxwx.service.admin.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController{
	
	@Autowired RoleService roleService;

	@RequestMapping(value = "/roleList")
	@RequiresAuthentication
	@ResponseBody
	public String index(Map map,BootPage page) {	
		//角色
//    	List<Role> roles = roleService.findAllRoles();
//    	map.put("roles", roles);
    	if(page==null){
    		page = new BootPage<Role>();
    		page.setOffset(1);
    		page.setLimit(3);
    	}
    	BootPage<Role> roles = roleService.findAllRoleByPage(page);
    	JSONObject json = new JSONObject();
    	return json.toJSONString(roles);
	}
}
