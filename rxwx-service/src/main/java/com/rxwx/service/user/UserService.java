package com.rxwx.service.user;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.common.mybatis.page.Page;
import com.rxwx.common.mybatis.page.PageVo;
import com.rxwx.model.User;
import com.rxwx.vo.UserVo;

/**
 * 
 * @author hjw
 *
 */
public interface UserService {

	/**
	 * 用户集合
	 * 
	 * @return
	 */
	List<User> findUserList() throws CustomException;

	/**
	 * 通过用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username) throws CustomException;

	PageVo<User> findUserListByPage(Page page)throws CustomException;

	
}
