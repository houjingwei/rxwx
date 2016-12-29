package com.rxwx.task.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String args[]) {
		// 这个xml文件是Spring配置beans的文件，顺带一提，路径 在整个应用的根目录
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
	}

}
