package com.rxwx.user.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.model.User;
import com.rxwx.service.user.UserService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {

	@Autowired
	private UserService userService;

	@Test
	public void findUserList() {
		User user = userService.findByUsername("hjw");
		System.out.println("****************"+user);
	}
	
	@Test
	public void findByUsername() {
		User list = userService.findByUsername("hjw9");
		System.out.println(">>>>>>>>>>>"+list);
	}

}
