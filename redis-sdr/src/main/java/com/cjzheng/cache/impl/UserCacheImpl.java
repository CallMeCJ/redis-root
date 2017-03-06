package com.cjzheng.cache.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.cjzheng.cache.UserCache;
import com.cjzheng.pojo.User;

/**
 * 
 * @Description: TODO
 * @author: zhengchaojie
 * @date 2017年3月6日 上午9:27:32
 *
 */
@Repository(value = "userCache")
public class UserCacheImpl implements UserCache {

	@Resource
	RedisTemplate<String, User> redisTemplate;

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
		return (User) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}
}
