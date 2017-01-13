package com.rxwx.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.container.page.Page;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.rxwx.common.exception.CustomException;
import com.rxwx.common.mybatis.page.BootPage;
import com.rxwx.model.Role;
import com.rxwx.service.admin.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController{
	
	@Autowired RoleService roleService;
	
	@RequestMapping(value = "/index")
	@RequiresAuthentication
	public String index(Map map) {	
		return super.showView(map,"/role/role_index");
	}
	

	@RequestMapping(value = "/roleList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	@RequiresAuthentication
	public String index(Map map,@RequestBody JSONObject jsonObj) {	
		
		int pageSize = jsonObj.getIntValue("pageSize");  
	    int pageNumber = jsonObj.getIntValue("pageNumber"); 
		//角色
//    	List<Role> roles = roleService.findAllRoles();
//    	map.put("roles", roles);
		BootPage page = new BootPage();
		page.setPageNum(pageNumber);
		page.setPageSize(pageSize);
    	PageInfo<Role> roles = roleService.findAllRoleByPage(page);
    	String str = new JSONObject().toJSONString(roles);
    	System.out.println("***"+str+"***");
    	return str;
	}
}
