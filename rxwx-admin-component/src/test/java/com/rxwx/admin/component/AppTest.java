package com.rxwx.admin.component;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.model.Admin;
import com.rxwx.model.Menu;
import com.rxwx.model.Resource;
import com.rxwx.service.admin.AdminService;
import com.rxwx.service.admin.MenuResourceService;
import com.rxwx.service.admin.MenuService;
import com.rxwx.service.admin.ResourceService;
import com.rxwx.vo.MenuResourceVo;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {

	@Autowired AdminService adminService;
	
	@Autowired MenuService menuService;
	
	@Autowired MenuResourceService menuResourceService;

	@Test
	public void findByAccount() {
		
		Admin admin=adminService.findByAccount("admin");
		System.out.println("账户信息 >> 账户－admin，账户ID－"+admin.getId()+"账户名称－"+admin.getName()+"");
	
		Set<String> roles = adminService.findRoles("admin");
		System.out.println("admin 拥有的角色"+roles);
		
		
		Set<String> resSet = adminService.findResources("admin");
		System.out.println("admin 拥有的权限资源"+resSet);
		
		System.out.println("admin 拥有的菜单结构");
		List<MenuResourceVo> menuList = menuResourceService.userMenuList(admin.getId());
		for (MenuResourceVo menuResourceVo : menuList) {
			System.out.println(menuResourceVo.getMenuName());
			for (Resource res : menuResourceVo.getResList()) {
				System.out.println("    |-"+res.getDesc()+" url:"+res.getUrl());
			}
		}
		
		
	}
	
//	@Test
//	public void findByUsername() {
//		List<Admin> list = adminService.findList();
//		System.out.println(list);
//	}

}
