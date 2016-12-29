package com.rxwx.service.user;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.User;
import com.rxwx.vo.UserVo;


public interface AccountService {

	public UserVo login(String phone, String password,String ip)throws CustomException;
	
	public User selectUserByPhone(String phone , Integer status) throws CustomException;
	
	public List<User> selectUserList(User record) throws CustomException;

	public boolean verifToken(String token , Long userId, String ip) throws CustomException;

	public boolean loginOut(Long uid, String token, String ip) throws CustomException;

}
