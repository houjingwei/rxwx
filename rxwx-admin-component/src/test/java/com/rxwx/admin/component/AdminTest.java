package com.rxwx.admin.component;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.model.Admin;
import com.rxwx.service.admin.AdminService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AdminTest extends TestCase {

	@Autowired AdminService adminService;

	@Test
	public void findByAccount() {
		
		Admin admin=adminService.findByAccount("admin");
		System.out.println("账户信息 >> 账户－admin，账户ID－"+admin.getId()+"账户名称－"+admin.getName()+"");
	
		Set<String> roles = adminService.findRoles("admin");
		System.out.println("admin 拥有的角色"+roles);
		
		
		Set<String> resSet = adminService.findResources("admin");
		System.out.println("admin 拥有的权限资源"+resSet);
		
		
		
	}
	
	
	
	@Test
	public void addAdmin() {
		Admin admin= new Admin();
		admin.setAccount("houjingwei");
		admin.setName("zijing");
		admin.setPhone("18823701350");
		admin.setEmail("houjingwei@163.com");
		admin.setPassword("123");
		admin.setSex(1);
		admin.setAge(28);
		boolean bool = adminService.addAdmin(admin);
		System.out.println("addAdmin >>" + bool);
	}
	
	@Test
	public void updateAdmin() {
		Admin admin= new Admin(2);
		admin.setAccount("houjingwei");
		admin.setName("zijing-Hou");
		admin.setPhoto(admin.randomPhoto());
		boolean bool = adminService.updateAdmin(admin);
		System.out.println("updateAdmin >>" + bool);
	}
	
	@Test
	public void isEnableAdmin() {
		Admin admin= new Admin(2);
		admin.setStatus(1);
		boolean bool = adminService.isEnableAdmin(admin);
		System.out.println("isEnableAdmin >>" + bool);
	}
	
	@Test
	public void adminAddRole() {
		Integer adminId = 2;
		Integer[] roleIds = new Integer[]{3,5};
		boolean bool = adminService.adminAddRole(adminId,roleIds);
		System.out.println("adminAddRole >>" + bool);
	}
	

}
