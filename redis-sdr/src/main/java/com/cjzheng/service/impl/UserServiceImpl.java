package com.cjzheng.service.impl;

import com.cjzheng.mapper.UserMapper;
import com.cjzheng.pojo.User;
import com.cjzheng.service.UserService;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	RedisTemplate<String, User> redisTemplate;

	@Resource
	UserMapper userMapper;

	public RedisTemplate<String, User> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(User user) {
		redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
	}

	public void delete(User key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	public User get(User key) {
		Object user = redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
		if (user == null) {
			System.out.println("we get from db this time");
			user = userMapper.get(key);
			put((User) user);
		}else {
			System.out.println("wee get from redis this time");
		}
		return (User) user;
	}

}
