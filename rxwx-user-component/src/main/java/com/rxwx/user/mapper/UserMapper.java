package com.rxwx.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rxwx.model.User;

public interface UserMapper {

	public List<User> findUserList();

	public User findByUsername(String username);

	public List<User> selectUserList(@Param(value="vo") User user);


}
