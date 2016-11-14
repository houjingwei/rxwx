package com.rxwx.user.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.model.User;
import com.rxwx.service.cache.CacheService;
import com.rxwx.service.user.UserService;
import com.rxwx.user.mapper.UserMapper;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired CacheService cacheService;
	
	@Autowired UserMapper userMapper;
	
	public List<User> findUserList() {
		if(cacheService.exists("findUserList")){
			System.out.println("findUserList() >> 缓存中获取数据");
			return (List<User>) cacheService.getList("findUserList");
		}
		System.out.println("findUserList() >> 数据库获取数据");
		List<User>  userList = userMapper.findUserList();
		if(null!=userList && userList.size()>0)
			cacheService.addList("findUserList",userList , 10);
		return userList;
	}

	public User findByUsername(String username) {
		if(cacheService.exists("findByUsername")){
			System.out.println("findByUsername() >> 缓存中获取数据");
			return (User) cacheService.get("findByUsername");
		}
		System.out.println("findByUsername() >> 数据库获取数据");
		User user = userMapper.findByUsername(username);
		if(null!=user)
			cacheService.add("findByUsername",user , 10);
		return user;
	}

//	public User saveOrUpdateUser(User user) {
//		return userMapper.saveOrUpdateUser(user);
//	}

}
