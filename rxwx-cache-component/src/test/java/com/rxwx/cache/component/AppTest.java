package com.rxwx.cache.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.model.User;
import com.rxwx.service.cache.CacheService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {
	
	@Autowired CacheService cacheService;
	@Test
    public void cacheTest(){  
    	User user = new User();
    	user.setUsername("123");
    	cacheService.add("user1", user, 1);
    	User user2 =  (User) cacheService.get("user1");
    	System.out.println(user2.getUsername());
        
    } 
}
