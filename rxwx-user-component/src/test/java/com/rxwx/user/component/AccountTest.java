package com.rxwx.user.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.service.user.AccountService;
import com.rxwx.vo.UserVo;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AccountTest extends TestCase {

	@Autowired
	private AccountService as;

	@Test
	public void findUserList() {
		UserVo vo = as.login("18823701350", "123456", "192.168.9.08");
		System.out.println(vo.getToken());
	}

}
