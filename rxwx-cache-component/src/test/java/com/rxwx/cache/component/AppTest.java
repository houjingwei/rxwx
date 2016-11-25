package com.rxwx.cache.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.common.utils.DateUtil;
import com.rxwx.model.User;
import com.rxwx.service.cache.CacheService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {
	
	@Autowired CacheService cacheService;
	@Test
    public void cacheTest(){  
		List<User> userList = new ArrayList<User>();
    	for(int i=0 ;i<2;i++){
    		User user = new User();
    		user.setEmail("houjingwei"+i+"@163.com");
    		user.setPassword("password"+i);
    		user.setUsername("houjingwei"+i);
    		userList.add(user);
    		
    	}
    	Date startSaveDate = new Date();
    	System.out.println("开始缓存"+DateUtil.convert2String(startSaveDate, "yyyy-MM-dd HH:mm:ss"));
    	
    	cacheService.add("userList", userList);
    	
    	Date endSaveDate = new Date();
    	System.out.println("缓存结束"+DateUtil.convert2String(endSaveDate, "yyyy-MM-dd HH:mm:ss"));
    	System.out.println("存储对象集合耗时<毫秒>:"+DateUtil.diffMs(startSaveDate, endSaveDate)+"ms");
    	
    	Date startGetDate = new Date();
    	System.out.println("开始读取"+DateUtil.convert2String(startGetDate, "yyyy-MM-dd HH:mm:ss"));
    	Object obj = cacheService.get("userList");
    	List<User> users = (List<User>) obj;
    	Date endGetDate = new Date();
    	System.out.println("读取结束"+DateUtil.convert2String(endGetDate, "yyyy-MM-dd HH:mm:ss"));
    	System.out.println("读取对象集合耗时<毫秒>:"+DateUtil.diffMs(startGetDate, endGetDate)+"ms");
    } 
}
