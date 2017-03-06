package com.cjzheng.mapper;

import java.util.List;

import com.cjzheng.pojo.User;

public interface UserMapper {
	List<User> list();

	User selectById(Integer id);
}