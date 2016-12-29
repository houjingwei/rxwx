package com.rxwx.task.quartz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.rxwx.model.User;
import com.rxwx.service.user.UserService;


public class UserTask implements SimpleJob {

	@Autowired UserService userService;

	public void execute(ShardingContext arg0) {
		
		System.out.println("***userService****"+userService);
		User user = userService.findByUsername("hjw");
		System.out.println("执行任务 >>>>>>"+new Date()+"***********"+user.toString()+"**********");
		
		
	}

}
