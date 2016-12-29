package com.rxwx.task.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AppTest extends TestCase {
	
	@Test
    public void cacheTask() throws InterruptedException{  
    	
    	Thread.sleep(100000);
    	System.out.println("end");
    } 
}
