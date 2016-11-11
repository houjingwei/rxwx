package com.rxwx.service.user;

import java.util.List;
import java.util.Set;

import com.rxwx.model.User;


/**
 * 
 * @author hjw
 *
 */
public interface UserService {
	
	/**
	 * 用户集合
	 * @return
	 */
	List<User> findUserList();

	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	
	
//	/**
//	 * 保存或更新用户
//	 * @param user
//	 * @return
//	 */
//	User saveOrUpdateUser(User user);
}
