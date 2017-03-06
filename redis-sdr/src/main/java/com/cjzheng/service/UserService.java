package com.cjzheng.service;

import com.cjzheng.pojo.User;

public interface UserService {
	public void put(User user);

	public void delete(User user);

	public User get(User user);
}
