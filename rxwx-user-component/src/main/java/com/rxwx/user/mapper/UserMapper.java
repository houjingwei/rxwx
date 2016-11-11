package com.rxwx.user.mapper;

import java.util.List;

import com.rxwx.model.User;

public interface UserMapper {

	public List<User> findUserList();

	public User findByUsername(String username);

	public User saveOrUpdateUser(User user);

}
