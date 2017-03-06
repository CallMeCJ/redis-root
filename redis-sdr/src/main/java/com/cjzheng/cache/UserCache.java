package com.cjzheng.cache;

import com.cjzheng.pojo.User;

/**
 * 
 * @Description: TODO
 * @author: zhengchaojie
 * @date 2017年3月6日 上午9:26:54
 *
 */
public interface UserCache {
	
	public void put(User user);

	public void delete(User user);

	public User get(User user);
}
