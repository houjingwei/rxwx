package com.rxwx.admin.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.rxwx.common.mybatis.page.BootPage;
import com.rxwx.model.Role;
import com.rxwx.service.admin.RoleService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class RoleTest extends TestCase {

	@Autowired
	RoleService roleService;

	@Test
	public void addRole() {
		Role role = new Role();
		role.setName("CTO");
		role.setDescription("运营－总监");
		boolean bool = roleService.addRole(role);
		System.out.println("addRole() >> "+bool);
	}

	@Test
	public void updateRole() {
		Role role = new Role(7);
		role.setName("cto");
		role.setDescription("运营总监");
		boolean bool = roleService.updateRole(role);
		System.out.println("addRole() >> "+bool);
	}

	@Test
	public void isEnableRole() {
		Role role = new Role(7);
		role.setStatus(1);
		boolean bool = roleService.isEnableRole(role);
		System.out.println("addRole() >> "+bool);
	}
	
	@Test
	public void roleAddResource() {
		Integer roleId = 7;
		Integer[] resoureIds = new Integer[]{1,2,3,6,7,8,9};
		boolean bool = roleService.roleAddResource(roleId, resoureIds);
		System.out.println("roleAddResource() >> "+bool);
	}
	
	@Test
	public void findAll() {
		BootPage page = new BootPage();
		page.setPageNum(1);
		page.setPageSize(8);
		PageInfo<Role> pageinfo = roleService.findAllRoleByPage(page);
		System.out.println("findAll() >> "+pageinfo.getList());
	}
	
	

}
