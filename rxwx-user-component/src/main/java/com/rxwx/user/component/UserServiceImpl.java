package com.rxwx.user.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.common.exception.CustomException;
import com.rxwx.common.exception.CustomExceptionEnum;
import com.rxwx.common.mybatis.page.Page;
import com.rxwx.common.mybatis.page.PageVo;
import com.rxwx.model.User;
import com.rxwx.service.cache.CacheService;
import com.rxwx.service.user.UserService;
import com.rxwx.user.mapper.UserMapper;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired CacheService cacheService;
	
	@Autowired UserMapper userMapper;
	
	public List<User> findUserList() {
		List<User> userList = null;
		try {
			if(cacheService.exists("findUserList")){
				System.out.println("findUserList() >> 缓存中获取数据");
				return (List<User>) cacheService.getList("findUserList");
			}
		
			System.out.println("findUserList() >> 数据库获取数据");
			userList = userMapper.findUserList();
			if(null!=userList && userList.size()>0)
				cacheService.addList("findUserList",userList , 10);
		} catch (CustomException e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		return userList;
	}

	public User findByUsername(String username) {
		User user = null;
		try {
			String key = "userNameKey-"+username;
			if(cacheService.exists("findByUsername")){
				System.out.println("key >> 缓存中获取数据");
				return (User) cacheService.get(key);
			}
		
			System.out.println("findByUsername() >> 数据库获取数据");
			user = userMapper.findByUsername(username);
			if(null!=user){
				cacheService.add(key,user,10);
			}
		} catch (CustomException e) {
			logger.error(e.getMessage());
		}
		return user;
	}

	public PageVo<User> findUserListByPage(Page page) throws CustomException {
		
		try {
			return userMapper.findUserListByPage(page).toPageVO();

		} catch (Exception e) {
			logger.error("catch Exception", e);

			throw new CustomException(CustomExceptionEnum.COMMON_DB_ERRORS);
		}
	}



}
