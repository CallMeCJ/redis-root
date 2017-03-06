package com.cjzheng.service.impl;

import com.cjzheng.cache.UserCache;
import com.cjzheng.mapper.UserMapper;
import com.cjzheng.pojo.User;
import com.cjzheng.service.UserService;
import com.cjzheng.util.JsonUtils;
import com.cjzheng.util.StringUtils;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserCache userCache;

	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Value("${USER_BASE_INFO_KEY}")
	private String USER_BASE_INFO_KEY;
	@Value("${ITEM_EXPIRE_SECOND}")
	private Integer ITEM_EXPIRE_SECOND;

	@Autowired
	public UserMapper mapper;

	public User selectByPrimaryKey(Integer id) {
		String json = userCache.get(REDIS_USER_KEY + ":" + id + ":" + USER_BASE_INFO_KEY);
		User user = null;
		if (!StringUtils.isEmpty(json)) {
			user = JsonUtils.jsonToPojo(json, User.class);
			System.out.println("we get data from redis this time");
			return user;
		}
		try {
			user = mapper.selectById(id);
			userCache.set(REDIS_USER_KEY + ":" + id + ":" + USER_BASE_INFO_KEY, JsonUtils.objectToJson(user));
			userCache.expire(REDIS_USER_KEY + ":" + id + ":" + USER_BASE_INFO_KEY, ITEM_EXPIRE_SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("we get data from db this time");
		return user;
	}

}
