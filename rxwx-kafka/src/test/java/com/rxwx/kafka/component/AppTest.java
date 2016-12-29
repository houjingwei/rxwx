package com.rxwx.kafka.component;

import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.model.User;
import com.rxwx.service.user.UserService;

import junit.framework.TestCase;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {

	@Autowired
	private UserService userService;

	@Test
	public void findUserList() {
		User user = userService.findByUsername("meizhen");
		System.out.println("****************"+user);
		
	}
	
	@Test
	public void findByUsername() {
		User list = userService.findByUsername("hjw9");
		System.out.println(list);
	}

}
