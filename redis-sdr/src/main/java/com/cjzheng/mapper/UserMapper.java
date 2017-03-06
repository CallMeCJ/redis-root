package com.cjzheng.mapper;

import com.cjzheng.pojo.User;

public interface UserMapper {

	public void put(User user);

	public void delete(User user);

	public User get(User user);
}